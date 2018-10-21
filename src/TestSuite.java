import Database.Log;
import Database.Models.JavaFile;
import Database.Models.Method;
import Detectors.InspectClass;
import Detectors.InspectMethod;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.Parameter;

import java.util.ArrayList;
import java.util.HashMap;

public class TestSuite {

    private InspectClass inspectClass;
    private InspectMethod inspectMethod;

    private JavaFile javaFile;

    public TestSuite(JavaFile javaFile) {
        this.inspectClass = new InspectClass();
        this.inspectMethod = new InspectMethod();
        this.javaFile = javaFile;
    }

    public void runClassTests() {
        String className = this.javaFile.getClassName();
        String inspecting = "Class: " + className;

        int classLength = this.javaFile.getClassLength();

        // CHECK CLASS LENGTH
        if (!inspectClass.inspectLength(classLength)) {
            int recommendedClassLength = inspectClass.getLengthLimit();
            this.javaFile.addErrorLog(
                    new Log(
                            className,
                            "Long Class, looks like this class has too many statements, we recommend a limit of:" + recommendedClassLength,
                            "Statements Counted: " + classLength,
                            inspecting
                    )
            );
        }

        // CHECK FOR TOO PRIMITIVE OBSESSION
        HashMap<String, Integer> primitiveMap = this.javaFile.getFields();
        primitiveMap.keySet().forEach(primitive -> {
            int numberOfPrimitives = primitiveMap.get(primitive);
            if (!inspectClass.validatePrimitive(numberOfPrimitives)) {
                int recommendedPrimitiveCount = inspectClass.getPrimitiveLimit();
                this.javaFile.addErrorLog(
                        new Log(
                                className,
                                "Primitive Obession, you have too many primitives, we recommend a limit of: " + recommendedPrimitiveCount,
                                " We found " + numberOfPrimitives + " " + primitive + "'s in this class.",
                                "Fields"
                        )
                );
            }
        });

        // CHECK FOR DATA CLUMPS
        HashMap<Parameter, Integer> dataClumpMap = new HashMap<>();

        this.javaFile.getMethods().forEach(method -> {
            method.getParameters().forEach(parameter -> {
                Integer previousValue = dataClumpMap.get(parameter);
                dataClumpMap.put(parameter, previousValue == null ? 1 : previousValue + 1);
            });
        });

        int variations = dataClumpMap.keySet().size();
        if (!inspectClass.checkDataClump(variations)) {
            this.javaFile.addErrorLog(
                    new Log(
                            className,
                            "Data Clump, you are using " + variations + " different parameters, we recommend a cap at " + inspectClass.getDataClumpLimit() + " different type parameters",
                            "Frequency of parameter against occurrence within this class is shown below\n" +dataClumpMap.toString(),
                            inspecting
                    )
            );
        }

        // CHECK FOR LAZY CLASSES
        int methodCount = this.javaFile.getMethods().size();
        int fieldCount = this.javaFile.getFields().keySet().size();

        if ( !inspectClass.isValid(methodCount, fieldCount) )  {
            this.javaFile.addErrorLog(
                    new Log(
                            className,
                            "Lazy Class, this class only has " + methodCount + " method(s) and " + fieldCount + " field(s)",
                            "We expect a minimum of " + inspectClass.getMiniMethodCount() + " methods and " + inspectClass.getMiniFieldCount() + " fields",
                            inspecting
                    )
            );
        }

        // CHECK FOR DATA CLASSES
        HashMap<String, Boolean> dataClass = new HashMap<>();
        this.javaFile.getMethods().forEach(method -> {
            if (method.getSetter()){
                dataClass.put(method.getName(), true);
            }
            if (method.getGetter()){
                dataClass.put(method.getName(), true);
            }
        });

        int numberOfMethods = this.javaFile.getMethods().size();
        int numberOfGettersAndSetters = dataClass.values().size();

        if ( inspectClass.isDataClass(numberOfMethods, numberOfGettersAndSetters)) {
            this.javaFile.addErrorLog(
                    new Log(
                            className,
                            "Data Class, this class only contains getters and setters",
                            "We found " + numberOfMethods + " method(s) and " + numberOfGettersAndSetters + " method(s) are only getters or setters",
                            inspecting
                    )
            );
        }
    }

    public void runMethodTests() {
        for (Method m : this.javaFile.getMethods()) {

            String className = this.javaFile.getClassName();
            String methodName = m.getName();

            String inspecting = "Method: " + methodName;

            int methodLength = m.getLength();

            //  CHECK METHOD LENGTH
            if (!inspectMethod.validateMethodLength(m.getLength())) {
                int recommendedMethodLength = inspectMethod.getLengthLimit();
                this.javaFile.addErrorLog(
                        new Log(
                                className,
                                "Long Method, looks like this method is too may statements, we recommend a limit of: " + recommendedMethodLength,
                                "Statements Counted: " + methodLength,
                                inspecting
                        )
                );
            }

            // CHECK PARAMETERS
            NodeList<Parameter> parameters = m.getParameters();
            if (!inspectMethod.validateParameterCount(parameters.size())) {
                this.javaFile.addErrorLog(
                        new Log(
                                className,
                                "Long Parameter List, looks like this method has too many parameters, we recommend a limit of: " + inspectMethod.getParamLimit(),
                                parameters.toString(),
                                inspecting
                        )
                );
            }

            // CHECK EXPRESSIONS
            ArrayList messageChain = m.getExpressions();
            if (messageChain.size() > 0) {
                messageChain.forEach(expression -> {
                    this.javaFile.addErrorLog(
                            new Log(
                                    className,
                                    "Message Chain too long, should be less than " + inspectMethod.getMessageChainLength() + " expressions",
                                    "Expression: " + expression.toString(),
                                    inspecting
                            )
                    );
                });
            }
        }
    }
}