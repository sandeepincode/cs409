package Util;

import Database.Log;
import java.util.ArrayList;

public class Printer {
    public void prettyPrint(ArrayList<Log> logs) {
        for (Log E : logs) {
            System.out.println(E.toString());
        }
    }
}
