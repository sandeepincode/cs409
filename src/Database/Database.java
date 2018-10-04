package Database;

import java.util.ArrayList;

public class Database {
    private ArrayList<Log> Db;

    public Database() {
        Db = new ArrayList<Log>();
    }

    public boolean dbPush(String className, Integer[] lines, String error, String data) {
        if (!className.isEmpty() && lines.length == 2 && !error.isEmpty() && !data.isEmpty()) {
            Db.add(new Log(
                    className,
                    lines,
                    error,
                    data
            ));
            return true;
        }
        return false;
    }

    public ArrayList<Log> dbPull() {
        return Db;
    }
}
