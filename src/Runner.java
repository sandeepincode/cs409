import Database.Database;
import Database.Models.JavaFile;

import Util.Printer;
import Visitors.Expressions.ExpressionVisitor;
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
        boolean print = false;


        // move to util
        ArrayList<String> files = new ArrayList<>();
        File dir = new File("Mock");
        File[] directoryListing = dir.listFiles();
        if (directoryListing != null) {
            for (File path : directoryListing) {
                files.add(path.toString());
            }
        }


        // Look out for nested classes
        for (String file : files) {

            FileInputStream in = new FileInputStream(file);
            CompilationUnit cu = JavaParser.parse(in);
            // Get information and populate class object

            cu.findAll(ClassOrInterfaceDeclaration.class).forEach(f->{

                System.out.println("Runner Says: " + f.getNameAsString());
                JavaFile javaFile = new JavaFile(file);

                // Creating the class
                cu.accept(new ClassVisitor(javaFile, f.getNameAsString()), null);

                // Creating the method
                cu.accept(new MethodVisitor(javaFile), null);

                // Run tests internally and create test suites to determine the results
                // testSuite = new TestSuite(javaFile);
                // testSuite.runClassTests();
                //testSuite.runMethodTests();

                // Push the java file to a database
                db.dbPush(javaFile);
            });
        }

        // Finally print linter results
        if (print) {
            System.out.println("\n=========================");
            System.out.println("        D33P-LINT: ");
            System.out.println("=========================");

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
