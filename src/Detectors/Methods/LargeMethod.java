package Detectors.Methods;

public class LargeMethod {
    private int LIMIT;

    public LargeMethod(int LIMIT) {
        this.LIMIT = LIMIT;
    }

    public boolean validate(int length) {
        if (length > this.LIMIT) {
            return false;
        }
        return true;
    }
}
