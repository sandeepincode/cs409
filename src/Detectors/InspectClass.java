package Detectors;

import java.util.Arrays;

public class InspectClass {

    private int STATEMENT_LIMIT = 100;
    private int PRIMITIVE_LIMIT = 4;

    public int getLengthLimit() {
        return this.STATEMENT_LIMIT;
    }

    public int getPrimitiveLimit() {
        return this.PRIMITIVE_LIMIT;
    }

    public boolean inspectLength(int length) {
        if (length > this.STATEMENT_LIMIT) {
            return false;
        }
        return true;
    }

    public boolean validatePrimitive(int count) {
        if (count > this.PRIMITIVE_LIMIT) {
            return false;
        }
        return true;
    }

}