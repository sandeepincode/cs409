package Database.Models;

import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.Parameter;

public class Method {
    private NodeList<Parameter> parameters;
    private String name;
    private int length;

    public Method(String name, int length, NodeList<Parameter> parameters) {
        this.name = name;
        this.length = length;
        this.parameters = parameters;
    }

    public NodeList<Parameter> getParamaters() {
        return this.parameters;
    }

    public String getName() {
        return this.name;
    }

    public int getLength() {
        return this.length;
    }
}
