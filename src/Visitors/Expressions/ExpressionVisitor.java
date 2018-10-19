package Visitors.Expressions;

import Database.Models.Method;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

public class ExpressionVisitor extends VoidVisitorAdapter<Void> {

    public NodeList results;
    public HashMap<String, NodeList> messageChains;

    public ExpressionVisitor() {
        this.messageChains = new HashMap<>();
        this.results = new NodeList();
    }

    public HashMap getMessageChain() {
        return this.messageChains;
    }

    @Override
    public void visit(MethodCallExpr g, Void arg) {
        String[] blackList = {"System", "out", ".println"};
        if (g.getChildNodes().size() > 1) {
            AtomicReference<Node> messageChain = new AtomicReference<>(g.getChildNodes().get(0));
            results = new NodeList();
            results.add(g.getChildNodes().get(g.getChildNodes().size() - 1));
            for (int i = 0; i < 10; i += 1) { // Will go 5 time down,
                messageChain.get().getChildNodes().forEach(l -> {
                    if (l.getChildNodes().size() > 0) {
                        messageChain.set(l);
                    }
                    if (l.getChildNodes().isEmpty() && !Arrays.stream(blackList).anyMatch(l.toString()::equals)) {
                        results.add(l);
                    }
                });
            }
            messageChains.put(g.toString(), results);
        }
    }
}
