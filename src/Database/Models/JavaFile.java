package Database.Models;

import Database.Log;

import java.util.ArrayList;
import java.util.HashMap;

import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;

public class JavaFile {

    private HashMap<String, Integer> fields;
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
        this.fields = new HashMap<>();
    }

    public HashMap<String, Integer> getFields() {
        return fields;
    }

    public void addField(String field) {
        Integer previousValue = this.fields.get(field);
        this.fields.put(field, previousValue == null ? 1 : previousValue + 1);
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
