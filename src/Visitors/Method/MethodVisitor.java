package Visitors.Method;

import Database.Models.JavaFile;
import Detectors.Methods.LargeParamList;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class MethodVisitor extends VoidVisitorAdapter<Void> {

    private JavaFile c;
    private LargeParamList paramCheck;

    public MethodVisitor(JavaFile c) {
        this.c = c;
        int PARAM_LIMIT = 2;
        this.paramCheck = new LargeParamList(PARAM_LIMIT);
    }

    @Override
    public void visit(MethodDeclaration n, Void arg) {
//        System.out.println("MethodDeclaration In MethodVisitor");
//
//        // Create a 2d array?
//        Integer[] lines = new Integer[2];
//
//        int paramCount = n.getParameters().size();
//        String className = "Test class name";
//        String method = n.getNameAsString();
//        String error = "";
//
//        if (!paramCheck.checkParamaterList(paramCount)) {
//            error = "Too many parameters within this method: " + method;
//////            lines[0] = 123;
//////            lines[1] = 3554;
//            this.c.addErrorLog(new Log(
//                    className,
//                    lines,
//                    error,
//                    n.getParameters().toString()
//            ));
    // }


//        System.out.println("++++++++++++++++++++++++++++++++++");
//        System.out.println(n.toString());
//        System.out.println("------------------------------------");
        super.visit(n, arg);
    }
}
