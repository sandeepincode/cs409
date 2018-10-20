package Visitors.Class;

import Database.Models.JavaFile;
import Visitors.Statement.StatementVisitor;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;

public class ClassVisitor extends VoidVisitorAdapter<Void> {

    private JavaFile c;
    private String className;

    public ClassVisitor(JavaFile c, String className) {
        this.c = c;
        this.className = className;
    }

    @Override
    public void visit(ClassOrInterfaceDeclaration n, Void arg) {
        if (n.getNameAsString().equals(className)) {
            StatementVisitor statementVisitor = new StatementVisitor();
            n.accept(statementVisitor, arg);
            this.c.setClassName(n.getNameAsString());
            this.c.setClassLength(statementVisitor.getStatementCount());
        }
        super.visit(n, arg);
    }

}
