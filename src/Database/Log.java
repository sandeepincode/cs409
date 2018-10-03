package Database;

public class Log {
    private String className;
    private Integer[] lines;
    private String error;

    Log(String className, Integer[] lines, String error) {
        this.className = className;
        this.lines = lines;
        this.error = error;
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

    public String toString() {
        return (
                "Class: " + this.className + "\n" +
                        "On Lines: " + this.lines[0] + " To " + this.lines[1] + "\n" +
                                "Error: " + this.error.toString() + "\n"
        );
    }
}
