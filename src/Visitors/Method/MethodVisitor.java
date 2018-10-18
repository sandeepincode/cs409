package Visitors.Method;

import Database.Models.JavaFile;
import Database.Models.Method;
import Visitors.Statement.StatementVisitor;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.stmt.SwitchEntryStmt;
import com.github.javaparser.ast.stmt.SwitchStmt;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class MethodVisitor extends VoidVisitorAdapter<Void> {

    private JavaFile c;

    public MethodVisitor(JavaFile c) {
        this.c = c;
    }

    @Override
    public void visit(SwitchEntryStmt n, Void arg) {
//        System.out.println(n.toString());

        // use to check that we have a break
        // n.getStatements().forEach(l -> System.out.println(l));
        super.visit(n, arg);
    }

    @Override
    public void visit(SwitchStmt n, Void arg) {
        super.visit(n, arg);
    }

    @Override
    public void visit(MethodDeclaration n, Void arg) {
//        System.out.println(
//                "================="
//        );
//        System.out.println(
//                n.getBody().filter(l -> l.isSwitchEntryStmt())
//        );
//        System.out.println(
//                n.getBody().filter(l -> l.isSwitchStmt())
//        );
//        System.out.println(
//                "================="
//        );
//

        StatementVisitor statementVisitor = new StatementVisitor();
        n.accept(statementVisitor, null);

        int length = statementVisitor.getStatementCount();
        String methodName = n.getNameAsString();
        NodeList<Parameter> parameters = n.getParameters();

        Method m = new Method(
                methodName,
                length,
                parameters
        );

        this.c.addMethod(m);
        super.visit(n, arg);
//        System.out.println("+");
//        System.out.println("Method Name: " + n.getNameAsString());
//
//        System.out.println("Parameters: " + n.getParameters());
//        System.out.println("Parameters List: " + n.getParameters().toString());
//
//        System.out.println(n.getBody());
//
//
//
//        test.forEach(d -> System.out.println(d.getName()));
//
//        System.out.println("Method Length: " + lines.length);
//        System.out.println("-");

//        System.out.println("MethodDeclaration In MethodVisitor");
//        // Create a 2d array?
//        Integer[] lines = new Integer[2];
//
//        int paramCount = n.getParameters().size();
//        String className = "Test class name";
//        String method = n.getNameAsString();
//        String error = "";
//        System.out.println("++++++++++++++++++++++++++++++++++");
//        System.out.println(n.toString());
//        System.out.println("------------------------------------");
    }
}
