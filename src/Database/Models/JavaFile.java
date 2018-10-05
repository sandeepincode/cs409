package Database.Models;
import java.util.ArrayList;
import Database.Log;
import com.github.javaparser.ast.Node;

public class JavaFile {

    private ArrayList<Log> errorLog;
    private ArrayList<Node> methods;
    private String className;
    private boolean isInterface;
    private int classLength;

    public JavaFile() {
        this.isInterface = false;
        this.className = null;
        this.classLength = 0;
        this.errorLog = new ArrayList<>();
        this.methods = new ArrayList<>();
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getClassLength() {
        return classLength;
    }

    public void setClassLength(int classLength) {
        this.classLength = classLength;
    }

    public boolean isInterface() {
        return this.isInterface;
    }

    public void setIsInterface(boolean isInterface) {
        this.isInterface = isInterface;
    }

    public int getMethodCount() {
        return this.methods.size();
    }

    public ArrayList<Log> getErrorLog() {
        return errorLog;
    }

    public void addErrorLog(Log error) {
        this.errorLog.add(error);
    }

    public ArrayList<Node> getMethods() {
        return methods;
    }

    public void addMethods(Node method) {
        this.methods.add(method);
    }

    public String toString() {
        return (
                    ""
                );
    }
}
