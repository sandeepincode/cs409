package Detectors;

import java.util.Arrays;

public class InspectClass {

    private int STATEMENT_LIMIT = 100;
    private int PRIMITIVE_LIMIT = 4;
    private int DATA_CLUMP_LIMIT = 5;
    private int MINIMUM_METHOD_COUNT = 2;
    private int MINIMUM_FIELD_COUNT = 1;

    public int getMiniMethodCount() {
        return this.MINIMUM_METHOD_COUNT;
    }

    public int getMiniFieldCount() {
        return this.MINIMUM_FIELD_COUNT;
    }

    public int getLengthLimit() {
        return this.STATEMENT_LIMIT;
    }

    public int getPrimitiveLimit() {
        return this.PRIMITIVE_LIMIT;
    }

    public int getDataClumpLimit() {
        return this.DATA_CLUMP_LIMIT;
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

    public boolean checkDataClump(int variations) {
        if (variations > this.DATA_CLUMP_LIMIT) {
            return false;
        }
        return true;
    }

    public boolean isValid(int methodCount, int fieldCount) {
        if (methodCount < this.MINIMUM_METHOD_COUNT && fieldCount < this.MINIMUM_FIELD_COUNT) {
            return false;
        }
        return true;
    }

    public boolean isDataClass(int methodCount, int getterSetterCount){
        if ((methodCount == getterSetterCount) && methodCount > 0 && getterSetterCount > 0) {
            return true;
        }
        return false;
    }

}