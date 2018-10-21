package Database;
import Database.Models.JavaFile;

import java.util.ArrayList;

public class Database {
    private ArrayList<JavaFile> Db;

    public Database() {
        Db = new ArrayList<>();
    }

    public boolean dbPush(JavaFile c) {
        if (c != null) {
            Db.add(c);
            return true;
        }
        return false;
    }

    public ArrayList<JavaFile> dbPull() {
        return Db;
    }
}
