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

    public String toString() {
        return (
                "Class: " + this.className + "\n" +
                        "Inspecting " + this.inpsecting + "\n" +
                        "Error: " + this.error + "\n" +
                        "Data: " + this.data + "\n"
        );
    }
}