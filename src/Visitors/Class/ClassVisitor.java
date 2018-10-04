package Visitors.Class;
import Database.Database;
import com.github.javaparser.ast.PackageDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class ClassVisitor extends VoidVisitorAdapter<Void> {
    private Database db;
    public ClassVisitor (Database db) {
        this.db = db;
    }
    @Override
    public void visit(PackageDeclaration n, Void arg) {
//        System.out.println("++++++++++++++++++++++++++++++++++++++");
        System.out.println("    PackageDeclaration In ClassVisitor");

//        Integer[] array = new Integer[2];
//        array[0] = 1;
//        array[1] = 2;
//        this.db.dbPush("PackageDeclaration", array, "PLZ WORK");


//        System.out.println(n.toString());
//        System.out.println("--------------------------------------");
        super.visit(n, arg);
    }

    @Override
    public void visit(FieldDeclaration n, Void arg) {
//        System.out.println("++++++++++++++++++++++++++++++++++++++");
        System.out.println("    FieldDeclaration In ClassVisitor");

//        Integer[] array = new Integer[2];
//        array[0] = 3;
//        array[1] = 4;
//        this.db.dbPush("FieldDeclaration", array, "PLZ WORK");

//        System.out.println(n.toString());
//        System.out.println("--------------------------------------");
        super.visit(n, arg);
    }
}
