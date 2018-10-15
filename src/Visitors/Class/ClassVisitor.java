package Visitors.Class;

import Database.Models.JavaFile;
import com.github.javaparser.ast.*;
import com.github.javaparser.ast.PackageDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.stmt.SwitchEntryStmt;
import com.github.javaparser.ast.stmt.SwitchStmt;
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
        String[] lines = n.toString().split("\r\n|\r|\n");
        this.c.setClassLength(lines.length);
        this.c.setClassName(n.getNameAsString());
        this.c.setIsInterface(n.isInterface());
//        System.out.println("Class Name: " + n.getName());
//        System.out.println("Class Implements: ");
//        for (ClassOrInterfaceType coi : n.getImplementedTypes()) {
//            System.out.println(coi.getName());
//        }
        super.visit(n, arg);
    }

    @Override
    public void visit(FieldDeclaration n, Void arg) {
//        System.out.println("++++++++++++++++++++++++++++++++++++++");
//         System.out.println("    FieldDeclaration In ClassVisitor");
//
//        Integer[] array = new Integer[2];
//        array[0] = 3;
//        array[1] = 4;
//        this.db.dbPush("FieldDeclaration", array, "PLZ WORK");
//
//        System.out.println(n.toString());
//        System.out.println("--------------------------------------");
        super.visit(n, arg);
    }
}
