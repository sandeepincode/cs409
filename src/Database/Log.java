package Database;

public class Log {
    private String className;
    private Integer[] lines;
    private String error;
    private String data;

    Log(String className, Integer[] lines, String error, String data) {
        this.className = className;
        this.lines = lines;
        this.error = error;
        this.data = data;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer[] getLines() {
        return lines;
    }

    public void setLines(Integer[] lines) {
        this.lines = lines;
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
                        "On Lines: " + this.lines[0] + " To " + this.lines[1] + "\n" +
                            "Error: " + this.error.toString() + "\n" +
                                "Data: " + this.data.toString() + "\n"
        );
    }
}
