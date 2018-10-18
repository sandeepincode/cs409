package Visitors.Method;

import Database.Models.JavaFile;
import Database.Models.Method;
import Visitors.Statement.StatementVisitor;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.expr.VariableDeclarationExpr;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.concurrent.atomic.AtomicReference;

public class MethodVisitor extends VoidVisitorAdapter<Void> {

    private JavaFile c;

    public MethodVisitor(JavaFile c) {
        this.c = c;
    }

//    @Override
//    public void visit(SwitchEntryStmt n, Void arg) {
////        System.out.println(n.toString());
//
//        // use to check that we have a break
//        // n.getStatements().forEach(l -> System.out.println(l));
//        super.visit(n, arg);
//    }
//    @Override
//    public void visit(SwitchStmt n, Void arg) {
//        super.visit(n, arg);
//    }

    @Override
    public void visit(FieldDeclaration n, Void arg) {
//        System.out.println(n.getVariables());
    }

    @Override
    public void visit(VariableDeclarationExpr n, Void arg) {
//        System.out.println("VariableDeclarationExpr" + n.getVariables());
    }


    @Override
    public void visit(MethodCallExpr g, Void arg) {
        System.out.println(g + " : "  + g.is());

//        if (g.getChildNodes().size() > 1 ) {
//            boolean searching = true;
//            AtomicReference<Node> messageChain = new AtomicReference<>(g.getChildNodes().get(0));
//            NodeList results = new NodeList();
//            // Inital Code List
//            results.add(g.getChildNodes().get(g.getChildNodes().size()-1));
//           for(int i = 0; i < 5; i+=1) { // Will go 5 time down,
//                System.out.println(results);
//                if (results.size() > 3) {
//                    break;
//                }
//                messageChain.get().getChildNodes().forEach(l -> {
//                    if (l.getChildNodes().size() > 0) {
//                        messageChain.set(l);
//                    }
//                    if (l.getChildNodes().isEmpty()) {
//                        results.add(l);
//                    }
//                });
////            methodCallExpr.getChildNodes().forEach( l -> {
////                System.out.println(l.getChildNodes());
////            });
//            }
//        }
    }

    @Override
    public void visit(MethodDeclaration n, Void arg) {
//        n.getBody().stream().forEach(l -> {
//            l.getStatements().forEach(g -> {
//                if (g.isExpressionStmt()) {
//                    System.out.println("TRUE");
//                } else {
//                    g.getChildNodes();
//
//                    System.out.println(g.getChildNodes().size());
//
//                }
//            });
//        });

//        n.getBody().stream().forEach(l -> l.getStatements().forEach(g -> {
//            System.out.println(g + " : " + g.isExpressionStmt());
//        }));
//        n.getBody().stream().forEach(l -> {
//            l.getStatements().forEach(
//                    g -> {
//                        System.out.println(g + " : " + g.isExpressionStmt());
//                    }
//            );
//        });
//        n.getParameters().forEach(l -> {
//            n.getBody().get().containsData(l.);
//        });
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
    }
}
