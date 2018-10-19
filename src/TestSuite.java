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
            error = "Bad news, looks like this class has too many statements, we recommend a limit of:" + recommendedClassLength;

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
        String error;
        for (Method m : this.javaFile.getMethods()) {

            String className = this.javaFile.getClassName();
            String methodName = m.getName();

            String inspecting = "Method: " + methodName;

            int methodLength = m.getLength();

            // Add more information about what information you have

            //  CHECK METHOD LENGTH
            if (!inspectMethod.length(m.getLength())) {

                int recommendedMethodLength = inspectMethod.getLengthLimit();
                error = "Bad news, looks like this method is too may statements, we recommend a limit of: " + recommendedMethodLength;
                this.javaFile.addErrorLog(
                        new Log(
                                className,
                                error,
                                "Statements Counted: " + methodLength,
                                inspecting
                        )
                );
            }

            // CHECK PARAMETERS
            NodeList<Parameter> parameters = m.getParameters();

            if (!inspectMethod.paramCount(parameters.size())) {

                error = "Bad news, looks like this method has too many parameters, we recommend a limit of: " + inspectMethod.getParamLimit();

                this.javaFile.addErrorLog(
                        new Log(
                                className,
                                error,
                                parameters.toString(),
                                inspecting
                        )
                );
            }

            // CHECK EXPRESSIONS
            HashMap map = m.getExpressions();
            map.keySet().forEach(expression -> {

                NodeList messageChain = (NodeList) map.get(expression);
                int messageChainCount = messageChain.size();

                if (inspectMethod.checkMessageChain(messageChainCount)) {
                    this.javaFile.addErrorLog(
                            new Log(
                                    className,
                                    "Bad news, this expression is too long we don't recommend anything more than " + inspectMethod.getMessageChainLength() + " expressions",
                                    "Expression: " + expression.toString(),
                                    inspecting
                            )
                    );
                }
            });
        }
    }
}
