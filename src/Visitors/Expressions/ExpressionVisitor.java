package Visitors.Expressions;

import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.ArrayList;
import java.util.Optional;

public class ExpressionVisitor extends VoidVisitorAdapter<Void> {

    private ArrayList<String> messageChains;

    public ExpressionVisitor() {
        this.messageChains = new ArrayList<>();
    }

    public ArrayList<String> getMessageChain() {
        return this.messageChains;
    }

    @Override
    public void visit(MethodCallExpr g, Void arg) {
        if (g.getScope().isPresent()) {
            Optional<Expression> insiderExpression = g.getScope();
            if (insiderExpression.get().isMethodCallExpr()) {
//                Optional<Expression> nextExpression = insiderExpression.get().asMethodCallExpr().getScope();
                this.messageChains.add(g.toString());
            }
        }
    }
}