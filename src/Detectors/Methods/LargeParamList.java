package Detectors.Methods;

public class LargeParamList {
    private int LIMIT;

    public LargeParamList(int LIMIT) {
        this.LIMIT = LIMIT;
    }

    public boolean validate(int paramCount) {
        if (paramCount > this.LIMIT) {
            return false;
        }
        return true;
    }
}
