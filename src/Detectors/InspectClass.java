package Detectors;
import Detectors.Class.*;

public class InspectClass {

    private LargeClass length;
    private int STATEMENT_LIMIT = 100; //CLASS LENGTH

    public InspectClass () {
        this.length = new LargeClass(this.STATEMENT_LIMIT);
    }
    public int getLengthLimit() {
        return this.STATEMENT_LIMIT;
    }
    public boolean inspectLength (int length) {
        return this.length.validate(length);
    }

}
