package Visitors.Class;

import Database.Models.JavaFile;
import Visitors.Statement.StatementVisitor;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;

public class ClassVisitor extends VoidVisitorAdapter<Void> {

    private JavaFile c;

    public ClassVisitor(JavaFile c) {
        this.c = c;
    }

    @Override
    public void visit(ClassOrInterfaceDeclaration n, Void arg) {
        StatementVisitor statementVisitor = new StatementVisitor();
        n.accept(statementVisitor, arg);
        this.c.setClassName(n.getNameAsString());
        this.c.setClassLength(statementVisitor.getStatementCount());
        super.visit(n, arg);
    }

}
