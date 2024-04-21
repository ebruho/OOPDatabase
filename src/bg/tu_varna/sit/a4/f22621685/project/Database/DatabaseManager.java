package bg.tu_varna.sit.a4.f22621685.project.Database;

import bg.tu_varna.sit.a4.f22621685.project.table.Table;

import java.util.HashMap;
import java.util.Map;

public class DatabaseManager {
    private Map<String, Table> tables;

    public DatabaseManager() {
        this.tables = new HashMap<>();
    }

    public void addTable(String tableName, Table table) {
        tables.put(tableName, table);
    }

    public void removeTable(String tableName) {
        tables.remove(tableName);
    }

    public boolean isTableNameUnique(String newTableName) {
        return !tables.containsKey(newTableName);
    }

    public Table getTable(String tableName) {
        return tables.get(tableName);
    }
}
