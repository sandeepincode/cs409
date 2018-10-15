package Detectors.Methods;

import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.stmt.Statement;
import com.github.javaparser.ast.stmt.SwitchStmt;

import javax.swing.plaf.nimbus.State;

public class SwitchCaseChecker {
    private int STATEMENT_LIMIT;

    public SwitchCaseChecker(int STATEMENT_LIMIT) {
        this.STATEMENT_LIMIT = STATEMENT_LIMIT;
    }

    public boolean validate(Statement s) {
        if (s.isSwitchStmt()) {

            SwitchStmt sw = s.asSwitchStmt();

            // GETS WHAT WE ARE SWITCHING OVER
            // System.out.println(sw.getSelector());

            // Check if there is only 2 statements
            if (sw.getEntries().size() <= this.STATEMENT_LIMIT) {
                System.out.println("Might be worth looking at a if and else");
                return false;
            }

            sw.getEntries().forEach(l -> {

                // GET LINE NUMBERS
                // System.out.println(l.getBegin().get());
                // System.out.println(l.getEnd().get());

                System.out.println(l.getLabel().getClass().getTypeName());
                System.out.println(l.getStatements());
                System.out.println("ENTRY: " + l.toString());

            });


            System.out.println("IS A SWITCH");

            return false; // if switch statement breaks any violations
        }
        return true;
    }
}
