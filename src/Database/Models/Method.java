package Database.Models;

import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.Parameter;

import java.util.ArrayList;
import java.util.HashMap;

public class Method {
    private NodeList<Parameter> parameters;
    private HashMap expressions;
    private String name;
    private int length;

    public Method(String name, int length, NodeList<Parameter> parameters) {
        this.name = name;
        this.length = length;
        this.parameters = parameters;
    }

    public void setExpression(HashMap expressions) {
        this.expressions = expressions;
    }

    public HashMap getExpressions() {
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
