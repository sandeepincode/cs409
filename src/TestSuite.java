import Database.Log;
import Database.Models.JavaFile;
import Database.Models.Method;
import Detectors.InspectClass;
import Detectors.InspectMethod;
import Visitors.Statement.StatementVisitor;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.stmt.SwitchStmt;

import java.util.ArrayList;
import java.util.Arrays;
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
        String error;
        String className = this.javaFile.getClassName();
        String inspecting = "Class: " + className;

        int classLength = this.javaFile.getClassLength();

        if (!inspectClass.inspectLength(classLength)) {

            int recommendedClassLength = inspectClass.getLengthLimit();
            error = "Long Class, looks like this class has too many statements, we recommend a limit of:" + recommendedClassLength;

            this.javaFile.addErrorLog(
                    new Log(
                            className,
                            error,
                            "Statements Counted: " + classLength,
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