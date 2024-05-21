package bg.tu_varna.sit.a4.f22621685.project.Database;

import bg.tu_varna.sit.a4.f22621685.project.errors.InvalidException;
import bg.tu_varna.sit.a4.f22621685.project.table.Table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DatabaseManager {
    private Map<String, Table> tables;

    public DatabaseManager() {
        this.tables = new HashMap<>();
    }

    public void addTable(Table table) throws InvalidException {
        if (tables.containsKey(table.getTableName())) {
            throw new InvalidException("Error: Table with name \"" + table.getTableName() + "\" already exists.");
        }
        tables.put(table.getTableName(), table);
    }

    public void removeTable(String tableName) {
        tables.remove(tableName);
    }

    public boolean isTableNameUnique(String newTableName) {
        return !tables.containsKey(newTableName);
    }

    public void renameTable(String oldName, String newName) throws InvalidException {
        if (!tables.containsKey(oldName)) {
            throw new InvalidException("Error: Table with name \"" + oldName + "\" does not exist.");
        }

        if (tables.containsKey(newName)) {
            throw new InvalidException("Error: Table with name \"" + newName + "\" already exists.");
        }

        Table table = tables.get(oldName);
        tables.remove(oldName);
        table.setTableName(newName);
        tables.put(newName, table);
    }



    public Table getTable(String tableName) {
        return tables.get(tableName);
    }

    public List<String> getTableNames() {
        return tables.keySet().stream().collect(Collectors.toList());
    }
}
