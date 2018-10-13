import Database.Log;
import Database.Models.JavaFile;
import Detectors.InspectClass;
import Detectors.InspectMethod;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.stmt.SwitchStmt;

import java.util.Arrays;

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
        String error;
        String inspecting = "Class";

        if (!inspectClass.inspectLength(this.javaFile.getClassLength())) {
            error = "Bad news, looks like this class is the line limit of: " + inspectClass.getLengthLimit();
            this.javaFile.addErrorLog(
                    new Log(
                            this.javaFile.getClassName(),
                            error,
                            "",
                            inspecting
                    )
            );
        }

    }

    public void runMethodTests() {
        String error;
        for (MethodDeclaration m : this.javaFile.getMethods()) {

            String inspecting = "Method: " + m.getNameAsString();
            int methodLength = m.toString().split("\r\n|\r|\n").length;

            //  CHECK METHOD LENGTH
            if (!inspectMethod.length(methodLength)) {
                error = "Bad news, looks like this method is too large, we recommend a limit of: " + inspectMethod.getLengthLimit();
                this.javaFile.addErrorLog(
                        new Log(
                                this.javaFile.getClassName(),
                                error,
                                "Length Calculated: " + methodLength,
                                inspecting
                        )
                );
            }

            // CHECK PARAMETERS
            if (!inspectMethod.paramCount(m.getParameters().size())) {
                error = "Bad news, looks like this method has too many parameters, we recommend a limit of: " + inspectMethod.getParamLimit();
                this.javaFile.addErrorLog(
                        new Log(
                                this.javaFile.getClassName(),
                                error,
                                m.getParameters().toString(),
                                inspecting
                        )
                );
            }

            // CHECK SWITCH STATEMENT
//            m.getBody().get().getStatements().forEach(l -> {
//                boolean result = inspectMethod.switchStatement(l);
//                if (!result) {
//                    this.javaFile.addErrorLog(
//                            new Log(
//                                    this.javaFile.getClassName(),
//                                    "Switch Statement Is: ",
//                                    l.toString(),
//                                    inspecting
//                            )
//                    );
//                }
//            });

            // Check inside method for dead code
            // For each parameter check its used

            System.out.println(m.getNameAsString() + " : " + m.getParameters() + "\n" + m.getBody() + "\n");

            m.getParameters().forEach(p -> {

                // Check declared variables are used
                System.out.println(m.getBody().toString().contains(p.toString()));
//                m.getBody().get().getStatements().forEach(l -> {
//                    System.out.println(l.toString().contains(p.toString()));
//                    System.out.println(l + "\n");
//                });

            });

        }
    }
}
