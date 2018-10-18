package Visitors.Expressions;

import Database.Models.Method;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

public class ExpressionVisitor extends VoidVisitorAdapter<Void> {

    public NodeList results;

    public ExpressionVisitor(){
        this.results = new NodeList();
    }

    public NodeList getMessageChain() {
        return this.results;
    }

    @Override
    public void visit(MethodCallExpr g, Void arg) {
        String[] blackList = {"System", "out", ".println"};
        if (g.getChildNodes().size() > 1) {
            AtomicReference<Node> messageChain = new AtomicReference<>(g.getChildNodes().get(0));
            results = new NodeList();
            results.add(g.getChildNodes().get(g.getChildNodes().size() - 1));
            for (int i = 0; i < 5; i += 1) { // Will go 5 time down,
                messageChain.get().getChildNodes().forEach(l -> {
                    if (l.getChildNodes().size() > 0) {
                        messageChain.set(l);
                    }
                    if (l.getChildNodes().isEmpty() && !Arrays.stream(blackList).anyMatch(l.toString()::equals)) {
                        results.add(l);
                    }
                });
            }
            if (results.size() > 3) {
                System.out.println(results);
                System.out.println("Too Long: " + g.toString());
            }
        }
    }
}
