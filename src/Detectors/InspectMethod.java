package Detectors;

import Detectors.Methods.*;
import com.github.javaparser.ast.stmt.Statement;

public class InspectMethod {

    private LargeMethod length;
    private LargeParamList paramCount;
    private SwitchCaseChecker switchCaseChecker;

    private int STATEMENT_LIMIT = 10; // STATEMENT LIMIT
    private int PARAM_LIMIT = 5;
    private int MIN_CASE_STATEMENTS_LIMIT = 3; // STATEMENT LIMIT PER CASE-STATEMENT

    public InspectMethod() {
        this.length = new LargeMethod(this.STATEMENT_LIMIT);
        this.paramCount = new LargeParamList(this.PARAM_LIMIT);
        this.switchCaseChecker = new SwitchCaseChecker(this.MIN_CASE_STATEMENTS_LIMIT);
    }

    public int getParamLimit() {
        return this.PARAM_LIMIT;
    }

    public int getLengthLimit() {
        return this.STATEMENT_LIMIT;
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

}
