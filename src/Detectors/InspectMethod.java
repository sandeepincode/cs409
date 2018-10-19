package Detectors;

import Detectors.Methods.*;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.stmt.Statement;

public class InspectMethod {

    private LargeMethod length;
    private LargeParamList paramCount;
    private SwitchCaseChecker switchCaseChecker;
    private MessageChain messageChain;

    private int STATEMENT_LIMIT = 10; // STATEMENT LIMIT
    private int PARAM_LIMIT = 5;
    private int MIN_CASE_STATEMENTS_LIMIT = 3; // STATEMENT LIMIT PER CASE-STATEMENT
    private int MESSAGE_CHAIN_LIMIT = 3;

    public InspectMethod() {
        this.length = new LargeMethod(this.STATEMENT_LIMIT);
        this.paramCount = new LargeParamList(this.PARAM_LIMIT);
        this.messageChain = new MessageChain(this.MESSAGE_CHAIN_LIMIT);
        this.switchCaseChecker = new SwitchCaseChecker(this.MIN_CASE_STATEMENTS_LIMIT);
    }

    public int getParamLimit() {
        return this.PARAM_LIMIT;
    }

    public int getLengthLimit() {
        return this.STATEMENT_LIMIT;
    }

    public int getMessageChainLength(){
        return this.MESSAGE_CHAIN_LIMIT;
    }

    public boolean length(int length) {
        return this.length.validate(length);
    }

    public boolean paramCount(int count) {
        return this.paramCount.validate(count);
    }

    public boolean switchStatement(Statement s) {
        return this.switchCaseChecker.validate(s);
    }

    public boolean checkMessageChain(int count) {
        return this.messageChain.validate(count);
    }

}
