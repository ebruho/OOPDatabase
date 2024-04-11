package bg.tu_varna.sit.a4.f22621685.project.Database;

import bg.tu_varna.sit.a4.f22621685.project.table.Table;

import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    List<Table> tables;

    public DatabaseManager() {
        this.tables = new ArrayList<>();
    }

    void addTable(Table table){
        tables.add(table);
    }

    void removeTable(Table table){
        tables.remove(table);
    }

    public List<Table> getTables() {
        return tables;
    }

    // Метод за проверка на уникалността на името на таблицата
    public boolean isTableNameUnique(String newTableName) {
        for (Table existingTable : tables) {
            if (existingTable.getTableName().equals(newTableName)) {
                return false; // Името не е уникално
            }
        }
        return true; // Името е уникално
    }
}
