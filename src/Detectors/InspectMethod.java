package Detectors;
public class InspectMethod {

    private int STATEMENT_LIMIT = 10; // STATEMENT LIMIT
    private int PARAM_LIMIT = 5;
    private int MESSAGE_CHAIN_LIMIT = 2;

    public int getParamLimit() {
        return this.PARAM_LIMIT;
    }

    public int getLengthLimit() {
        return this.STATEMENT_LIMIT;
    }

    public int getMessageChainLength() {
        return this.MESSAGE_CHAIN_LIMIT;
    }

    public boolean validateMethodLength(int length) {
        if (length < this.STATEMENT_LIMIT) {
            return true;
        }
        return false;
    }

    public boolean validateParameterCount(int count) {
        if (count < this.PARAM_LIMIT) {
            return true;
        }
        return false;
    }
}