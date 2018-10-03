package Visitors.Class;
import com.github.javaparser.ast.PackageDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class ClassVisitor extends VoidVisitorAdapter<Void> {
    @Override
    public void visit(PackageDeclaration n, Void arg) {
        System.out.println("++++++++++++++++++++++++++++++++++++++");
        System.out.println("    PackageDeclaration In ClassVisitor");
        System.out.println(n.toString());
        System.out.println("--------------------------------------");
        super.visit(n, arg);
    }

    @Override
    public void visit(FieldDeclaration n, Void arg) {
        System.out.println("++++++++++++++++++++++++++++++++++++++");
        System.out.println("    FieldDeclaration In ClassVisitor");
        System.out.println(n.toString());
        System.out.println("--------------------------------------");
        super.visit(n, arg);
    }
}
