package Detectors.Methods;

public class MessageChain {
    private int LIMIT;

    public MessageChain(int LIMIT) {
        this.LIMIT = LIMIT;
    }

    public boolean validate(int length) {
        if (length > this.LIMIT) {
            return true;
        }
        return false;
    }
}
