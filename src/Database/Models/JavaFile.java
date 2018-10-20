package Database.Models;

import java.util.ArrayList;

import Database.Log;


public class JavaFile {

    private ArrayList<Log> errorLog;
    private ArrayList<Method> methods;
    private String className;
    private int classLength;
    private String path;

    public JavaFile(String path) {
        this.path = path;
        this.className = null;
        this.classLength = 0;
        this.errorLog = new ArrayList<>();
        this.methods = new ArrayList<>();
    }

    public String getPath() {
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

    public ArrayList<Log> getErrorLog() {
        return errorLog;
    }

    public void addErrorLog(Log error) {
        this.errorLog.add(error);
    }

    public ArrayList<Method> getMethods() {
        return this.methods;
    }

    public void addMethod(Method method) {
        this.methods.add(method);
    }
}
