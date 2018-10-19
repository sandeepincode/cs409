package Database;

public class Log {
    private String inpsecting;
    private String className;
    private String error;
    private String data;

    public Log(String className, String error, String data, String inpsecting) {
        this.className = className;
        this.error = error;
        this.data = data;
        this.inpsecting = inpsecting;
    }

    public String getInspecting() {
        return this.inpsecting;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String toString() {
        return (
                "Class: " + this.className + "\n" +
                        "Inspecting " + this.inpsecting + "\n" +
                        "Error: " + this.error + "\n" +
                        "Data: " + this.data + "\n"
        );
    }
}
