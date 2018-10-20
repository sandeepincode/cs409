import Database.Database;
import Database.Models.JavaFile;

import Util.Printer;
import Util.Parser;

import Visitors.Method.MethodVisitor;
import Visitors.Class.ClassVisitor;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

public class Runner {

    private static Database db;
    private static Printer printer;
    private static TestSuite testSuite;

    public static void main(String[] args) throws Exception {

        db = new Database();
        printer = new Printer();
        boolean print = true;

        Parser p = new Parser();
        p.parse(new File("Mock"));
        ArrayList<String> files = p.getPaths();

        for (String file : files) {

            FileInputStream in = new FileInputStream(file);
            CompilationUnit cu = JavaParser.parse(in);

            cu.findAll(ClassOrInterfaceDeclaration.class).forEach(f -> {

                JavaFile javaFile = new JavaFile(file);

                cu.accept(new ClassVisitor(javaFile, f.getNameAsString()), null);
                cu.accept(new MethodVisitor(javaFile), null);

                testSuite = new TestSuite(javaFile);
                testSuite.runClassTests();
                testSuite.runMethodTests();

                db.dbPush(javaFile);
            });
        }

        if (print) {

            System.out.println("\n=========================");
            System.out.println("    Java-Parser-Linter: ");
            System.out.println("=========================");

            // Results Inside The Java Files
            for (JavaFile cd : db.dbPull()) {
                if (cd.getErrorLog().size() > 0) {
                    System.out.println("\n=========================");
                    System.out.println("    Class: " + cd.getClassName());
                    System.out.println("    Path: " + cd.getPath());
                    System.out.println("=========================\n");
                    printer.prettyPrint(cd.getErrorLog());
                }
            }
        }

    }
}
