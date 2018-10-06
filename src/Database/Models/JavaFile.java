package Database.Models;

import java.util.ArrayList;
import Database.Log;


public class JavaFile {

    private ArrayList<Log> errorLog;
    private ArrayList<Method> methods;
    private String className;
    private boolean isInterface;
    private int classLength;
    private String path;

    public JavaFile(String path) {
        this.path = path;
        this.isInterface = false;
        this.className = null;
        this.classLength = 0;
        this.errorLog = new ArrayList<>();
        this.methods = new ArrayList<>();
    }

    public String getPath () {
        return path;
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

    public ArrayList<Method> getMethods() {
        return methods;
    }

    public void addMethods(Method method) {
        this.methods.add(method);
    }

    // FINISH OFF //
    public String toString() {
        return (
                ""
        );
    }
}
