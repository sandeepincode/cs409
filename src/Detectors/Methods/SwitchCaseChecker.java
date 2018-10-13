package Detectors.Methods;

import com.github.javaparser.ast.stmt.Statement;
import com.github.javaparser.ast.stmt.SwitchStmt;

import javax.swing.plaf.nimbus.State;

public class SwitchCaseChecker {
    public boolean validate (Statement s){
        if (s.isSwitchStmt()) {

            SwitchStmt sw = s.asSwitchStmt();

            System.out.println(sw.getSelector());

            sw.getEntries().forEach(l->{
                System.out.println("ENTRY: " + l.toString());
            });



//
//            System.out.println(sw);
            System.out.println("IS A SWITCH");

            return false; // if switch statement breaks any violations
        }
        return true;
    }
}
