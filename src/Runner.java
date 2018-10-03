import Visitors.Method.MethodVisitor;
import Visitors.Class.ClassVisitor;
import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;

import java.io.FileInputStream;

public class Runner {
    public static void main(String[] args) throws Exception {

        FileInputStream in = new FileInputStream("src/Mock/test.java");
        CompilationUnit cu = JavaParser.parse(in);

//        cu.findAll(FieldDeclaration.class).stream()
//                .filter(f -> f.isPublic() && !f.isStatic())
//                .forEach(f -> System.out.println("Check field at line " +
//                        f.getRange().map(r -> r.begin.line).orElse(-1)));

        cu.accept(new ClassVisitor(), null);
        cu.accept(new MethodVisitor(), null);

    }
}
