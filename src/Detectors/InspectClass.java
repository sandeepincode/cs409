package Detectors;

public class InspectClass {

    private int STATEMENT_LIMIT = 100; //CLASS LENGTH

    public int getLengthLimit() {
        return this.STATEMENT_LIMIT;
    }

    public boolean inspectLength(int length) {
        if (length > this.STATEMENT_LIMIT) {
            return false;
        }
        return true;
    }

}