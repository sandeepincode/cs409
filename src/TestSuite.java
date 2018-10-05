import Database.Log;
import Database.Models.JavaFile;
import Detectors.InspectClass;
import Detectors.InspectMethod;

import java.util.ArrayList;

public class TestSuite {

    private InspectClass inspectClass;
    private InspectMethod inspectMethod;

    private JavaFile javaFile;

    public TestSuite(JavaFile javaFile) {
        this.inspectClass = new InspectClass();
        this.inspectMethod = new InspectMethod();
        this.javaFile = javaFile;
    }

    public void runClassTests() {
        String error;
        String inspecting = "Class";
        if (!inspectClass.inspectLength(this.javaFile.getClassLength())) {
            error = "Bad news, looks like this class is the line limit of: " + inspectClass.getLengthLimit();
            this.javaFile.addErrorLog(
                    new Log(
                            this.javaFile.getClassName(),
                            error,
                            "",
                            inspecting
                    )
            );
        }
    }

    public void runMethodTests() {
        String error;
        String inspecting = "Method";

        //////////////////////////////////////////////
        // WE NEED TO DO A FOR EACH FOR EACH METHOD //
        //////////////////////////////////////////////

        if (!inspectMethod.length(this.javaFile.getClassLength())) {
            error = "Bad news, looks like this method is too large, we recommend a limit of: " + inspectMethod.getLengthLimit();
            this.javaFile.addErrorLog(
                    new Log(
                            this.javaFile.getClassName(),
                            error,
                            "",
                            inspecting
                    )
            );
        }
        if (!inspectMethod.paramCount(this.javaFile.getClassLength())) {
            error = "Bad news, looks like this method has too many parameters, we recommend a limit of: " + inspectMethod.getParamLimit();
            this.javaFile.addErrorLog(
                    new Log(
                            this.javaFile.getClassName(),
                            error,
                            "",
                            inspecting
                    )
            );
        }
    }
}
