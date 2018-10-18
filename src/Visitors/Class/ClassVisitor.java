package Visitors.Class;

import Database.Models.JavaFile;
import Visitors.Statement.StatementVisitor;
import com.github.javaparser.ast.PackageDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;

public class ClassVisitor extends VoidVisitorAdapter<Void> {

    private JavaFile c;

    public ClassVisitor(JavaFile c) {
        this.c = c;
    }

    @Override
    public void visit(PackageDeclaration n, Void arg) {
        super.visit(n, arg);
    }

    @Override
    public void visit(ClassOrInterfaceDeclaration n, Void arg) {

        StatementVisitor statementVisitor = new StatementVisitor();

        n.accept(statementVisitor, arg);
//        System.out.println("Statements in class visitor: " + statementVisitor.getStatementCount());
        this.c.setClassName(n.getNameAsString());
        this.c.setClassLength(statementVisitor.getStatementCount());
        this.c.setIsInterface(n.isInterface());
        super.visit(n, arg);
    }

}
