package Visitors.Method;

import Database.Models.JavaFile;
import Database.Models.Method;
import Visitors.Expressions.ExpressionVisitor;
import Visitors.Statement.StatementVisitor;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.ArrayList;

public class MethodVisitor extends VoidVisitorAdapter<Void> {

    private JavaFile javaFile;

    public MethodVisitor(JavaFile javaFile) {
        this.javaFile = javaFile;
    }

    @Override
    public void visit(MethodDeclaration n, Void arg) {

        StatementVisitor statementVisitor = new StatementVisitor();
        ExpressionVisitor expressionVisitor = new ExpressionVisitor();

        n.accept(statementVisitor, null);
        n.accept(expressionVisitor, null);

        int length = statementVisitor.getStatementCount();
        String methodName = n.getNameAsString();
        NodeList<Parameter> parameters = n.getParameters();
        ArrayList messageChain = expressionVisitor.getMessageChain();

        Method m = new Method(
                methodName,
                length,
                parameters
        );

        m.setExpression(messageChain);

        this.javaFile.addMethod(m);
        super.visit(n, arg);
    }
}