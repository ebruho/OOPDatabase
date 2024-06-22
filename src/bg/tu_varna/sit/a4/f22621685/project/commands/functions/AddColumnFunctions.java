package bg.tu_varna.sit.a4.f22621685.project.commands.functions;

import bg.tu_varna.sit.a4.f22621685.project.database.DatabaseManager;
import bg.tu_varna.sit.a4.f22621685.project.table.Cell;
import bg.tu_varna.sit.a4.f22621685.project.table.Column;

/**
 * The AddColumnFunctions class provides functionality to add a new column to a table in the database.
 */
public class AddColumnFunctions {

    /**
     * Adds a new column to a specified table in the database.
     *
     * @param databaseManager the database manager to operate on
     * @param tableName the name of the table to add the column to
     * @param columnName the name of the new column
     * @param columnType the type of the new column
     */
    public void addColumn(DatabaseManager databaseManager, String tableName, String columnName, String columnType) {
        Column column = new Column(columnName);
        int size = 0;

        // Check if the table has any columns
        if (!databaseManager.getTable(tableName).getColumns().isEmpty()) {
            // Get the size of the first column to match the row count
            size = databaseManager.getTable(tableName).getColumns().get(0).getCells().size();
        }

        // Add empty cells to the new column to match the row count of the table
        for (int i = 0; i < size; i++) {
            column.addCell(new Cell(null));
        }

        // Add the new column to the specified table
        databaseManager.getTable(tableName).addColumn(column);
    }
}
