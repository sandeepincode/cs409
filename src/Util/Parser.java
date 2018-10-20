package Util;

import java.io.File;
import java.util.ArrayList;

public class Parser {
    private ArrayList<String> files = new ArrayList<>();

    public void parse(File folder) {
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                this.parse(fileEntry);
            } else {
                files.add(fileEntry.getPath());
            }
        }
    }
    public ArrayList<String> getPaths(){
        return this.files;
    }
}