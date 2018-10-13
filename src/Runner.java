import Database.Database;
import Database.Models.JavaFile;

import Util.Printer;
import Visitors.Method.MethodVisitor;
import Visitors.Class.ClassVisitor;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;

import java.io.FileInputStream;
import java.util.ArrayList;

public class Runner {

    private static Database db;
    private static Printer printer;
    private static TestSuite testSuite;

    public static void main(String[] args) throws Exception {

        db = new Database();
        printer = new Printer();

        ArrayList<String> files = new ArrayList<>();

        /***********Config*****************/
        boolean print = false;
        files.add("src/Mock/test.java");
        // files.add("src/Mock/test2.java");
        /*********************************/


        for (String file : files) {

            JavaFile javaFile = new JavaFile(file);

            FileInputStream in = new FileInputStream(file);
            CompilationUnit cu = JavaParser.parse(in);

            // Get information and populate class object
            cu.accept(new ClassVisitor(javaFile), null);
            cu.accept(new MethodVisitor(javaFile), null);

            // Run tests internally and create test suites to determine the results
            testSuite = new TestSuite(javaFile);

            // testSuite.runClassTests();
            testSuite.runMethodTests();

            // Push the java file to a database
            db.dbPush(javaFile);

        }

        // Finally print linter results
        if (print) {
            System.out.println("\n=========================");
            System.out.println("        D33P-LINT: ");
            System.out.println("=========================\n");

            for (JavaFile cd : db.dbPull()) {
                System.out.println("\n=========================");
                System.out.println("    Class: " + cd.getClassName());
                System.out.println("    Path: " + cd.getPath());
                System.out.println("=========================\n");
                printer.prettyPrint(cd.getErrorLog());
            }
        }

    }
}
