import Database.Database;
import Database.Log;
import Util.Printer;
import Visitors.Method.MethodVisitor;
import Visitors.Class.ClassVisitor;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;

import java.io.FileInputStream;

public class Runner {
    private static Database db;
    private static Printer printer;
    public static void main(String[] args) throws Exception {

        db = new Database();
        printer = new Printer();

        FileInputStream in = new FileInputStream("src/Mock/test.java");
        CompilationUnit cu = JavaParser.parse(in);
//        cu.findAll(FieldDeclaration.class).stream()
//                .filter(f -> f.isPublic() && !f.isStatic())
//                .forEach(f -> System.out.println("Check field at line " +
//                        f.getRange().map(r -> r.begin.line).orElse(-1)));

        // How to print on completion?
        cu.accept(new ClassVisitor(db), null);
        cu.accept(new MethodVisitor(db), null);
        printer.prettyPrint(db.dbPull());
    }
}
