package Visitors.Method;
import Database.Database;
import Detectors.Methods.LargeParamList;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class MethodVisitor extends VoidVisitorAdapter<Void> {

    private Database db;
    private LargeParamList paramCheck;

    public MethodVisitor(Database db){
        int PARAM_LIMIT = 5;
        this.paramCheck = new LargeParamList(PARAM_LIMIT);
        this.db = db;
    }

    @Override
    public void visit(MethodDeclaration n, Void arg) {
        paramCheck.checkParamaterList(n.getParameters().size());

        Integer[] array = new Integer[2];
        array[0] = 12;
        array[1] = 23;
        this.db.dbPush("MethodDeclaration", array, "PLZ WORK bbbyyyy");


//        System.out.println("++++++++++++++++++++++++++++++++++");
//        System.out.println("MethodDeclaration In MethodVisitor");
//        System.out.println(n.toString());
//        System.out.println("------------------------------------");
        super.visit(n, arg);
    }
}
