package Detectors;
import Detectors.Methods.*;

public class InspectMethod {

    private LargeMethod length;
    private LargeParamList paramCount;

    private int LENGTH_LIMIT = 20;
    private int PARAM_LIMIT = 4;

    public InspectMethod () {
        this.length = new LargeMethod(this.LENGTH_LIMIT);
    }

    public int getParamLimit() {
        return this.PARAM_LIMIT;
    }
    public int getLengthLimit() {
        return this.LENGTH_LIMIT;
    }
    public boolean length (int length) {
        return this.length.validate(length);
    }
    public boolean paramCount (int count) {
        return this.paramCount.validate(count);
    }

}
