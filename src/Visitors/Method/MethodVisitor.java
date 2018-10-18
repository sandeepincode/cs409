package Visitors.Method;

import Database.Models.JavaFile;
import Database.Models.Method;
import Visitors.Expressions.ExpressionVisitor;
import Visitors.Statement.StatementVisitor;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.expr.AssignExpr;
import com.github.javaparser.ast.expr.CastExpr;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.expr.VariableDeclarationExpr;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.stmt.ExpressionStmt;
import com.github.javaparser.ast.stmt.IfStmt;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

public class MethodVisitor extends VoidVisitorAdapter<Void> {

    private JavaFile c;

    public MethodVisitor(JavaFile c) {
        this.c = c;
    }

    @Override
    public void visit(FieldDeclaration n, Void arg) {
//        System.out.println(n.getVariables());
    }

    // Get things like x = 10
    @Override
    public void visit(AssignExpr n, Void arg) {
        // System.out.println(n);
    }

    @Override
    public void visit(VariableDeclarationExpr n, Void arg) {
//        System.out.println("VariableDeclarationExpr" + n.getVariables());
    }

    // Create another visitor then create the method expr first then do the others

    @Override
    public void visit(MethodDeclaration n, Void arg) {

        StatementVisitor statementVisitor = new StatementVisitor();
        ExpressionVisitor expressionVisitor = new ExpressionVisitor();

        n.accept(statementVisitor, null);
        n.accept(expressionVisitor, null);

        int length = statementVisitor.getStatementCount();
        String methodName = n.getNameAsString();
        NodeList messageChain = expressionVisitor.getMessageChain();

        if (messageChain.size() >= 3) {
            System.out.println(messageChain);
        }

        NodeList<Parameter> parameters = n.getParameters();

        Method m = new Method(
                methodName,
                length,
                parameters
        );

        this.c.addMethod(m);
        super.visit(n, arg);
    }
}
