package Database.Models;

import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.Parameter;

import java.util.ArrayList;

public class Method {
    private NodeList<Parameter> parameters;
    private ArrayList<String> expressions;
    private String name;
    private int length;

    public Method(String name, int length, NodeList<Parameter> parameters) {
        this.name = name;
        this.length = length;
        this.parameters = parameters;
    }

    public void setExpression(ArrayList expressions) {
        this.expressions = expressions;
    }

    public ArrayList<String> getExpressions() {
        return this.expressions;
    }

    public NodeList<Parameter> getParameters() {
        return this.parameters;
    }

    public String getName() {
        return this.name;
    }

    public int getLength() {
        return this.length;
    }
}