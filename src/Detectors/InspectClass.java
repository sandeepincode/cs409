package Detectors;
import Detectors.Class.*;

public class InspectClass {

    private LargeClass length;
    private int LENGTH_LIMIT = 300;

    public InspectClass () {
        this.length = new LargeClass(this.LENGTH_LIMIT);
    }
    public int getLengthLimit() {
        return this.LENGTH_LIMIT;
    }
    public boolean inspectLength (int length) {
        return this.length.validate(length);
    }

}
