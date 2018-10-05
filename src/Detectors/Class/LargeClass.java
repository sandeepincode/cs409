package Detectors.Class;

public class LargeClass {
    private int LIMIT;

    public LargeClass(int LIMIT) {
        this.LIMIT = LIMIT;
    }

    public boolean validate(int length) {
        if (length > this.LIMIT) {
            return false;
        }
        return true;
    }
}
