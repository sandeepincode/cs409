package Detectors;

import Detectors.Methods.*;
import com.github.javaparser.ast.stmt.Statement;

public class InspectMethod {

    private LargeMethod length;
    private LargeParamList paramCount;
    private SwitchCaseChecker switchCaseChecker;

    private int LENGTH_LIMIT = 9;
    private int PARAM_LIMIT = 2;
    private int STATEMENT_LIMIT = 2;

    public InspectMethod() {
        this.length = new LargeMethod(this.LENGTH_LIMIT);
        this.paramCount = new LargeParamList(this.PARAM_LIMIT);
        this.switchCaseChecker = new SwitchCaseChecker(this.STATEMENT_LIMIT);
    }

    public int getParamLimit() {
        return this.PARAM_LIMIT;
    }

    public int getLengthLimit() {
        return this.LENGTH_LIMIT;
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
