package bg.tu_varna.sit.a4.f22621685.project.commands;

import bg.tu_varna.sit.a4.f22621685.project.Database.DatabaseManager;
import bg.tu_varna.sit.a4.f22621685.project.table.Cell;
import bg.tu_varna.sit.a4.f22621685.project.table.Column;

public class AddColumnFunctions {
    /**
     *
     *
     * @param databaseManager
     * @param tableName
     * @param columnName
     * @param columnType
     */
    public void addColumn(DatabaseManager databaseManager,String tableName, String columnName,String columnType){
        Column column = new Column(columnName);
        int size=0;
        if(!databaseManager.getTable(tableName).getColumns().isEmpty()) {
            size = databaseManager.getTable(tableName).getColumns().get(0).getCells().size();
        }
        for (int i = 0; i < size; i++) {
            column.addCell(new Cell(null));
        }
        databaseManager.getTable(tableName).addColumn(column);
    }
}
