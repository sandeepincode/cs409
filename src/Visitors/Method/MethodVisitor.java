package Visitors.Method;
import Detectors.Methods.LargeParamList;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class MethodVisitor extends VoidVisitorAdapter<Void> {

    private LargeParamList paramCheck;

    public MethodVisitor(){
        int PARAM_LIMIT = 5;
        this.paramCheck = new LargeParamList(PARAM_LIMIT);
    }

    @Override
    public void visit(MethodDeclaration n, Void arg) {

        paramCheck.checkParamaterList(n.getParameters().size());

        System.out.println("++++++++++++++++++++++++++++++++++");
        System.out.println("MethodDeclaration In MethodVisitor");
        System.out.println(n.toString());
        System.out.println("------------------------------------");
        super.visit(n, arg);
    }
}
