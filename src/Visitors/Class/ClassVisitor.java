package Visitors.Class;

import Database.Models.JavaFile;
import Visitors.Statement.StatementVisitor;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;

public class ClassVisitor extends VoidVisitorAdapter<Void> {

    private JavaFile javaFile;

    public ClassVisitor(JavaFile javaFile) {
        this.javaFile = javaFile;
    }

    @Override
    public void visit(FieldDeclaration n, Void arg) {
        n.getVariables().forEach(f->this.javaFile.addField(f.getTypeAsString()));
    }

    @Override
    public void visit(ClassOrInterfaceDeclaration n, Void arg) {
        StatementVisitor statementVisitor = new StatementVisitor();
        n.accept(statementVisitor, arg);
        this.javaFile.setClassName(n.getNameAsString());
        this.javaFile.setClassLength(statementVisitor.getStatementCount());
        super.visit(n, arg);
    }

}
