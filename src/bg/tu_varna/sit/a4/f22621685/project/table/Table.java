package bg.tu_varna.sit.a4.f22621685.project.table;

import bg.tu_varna.sit.a4.f22621685.project.database.DatabaseManager;

import java.util.ArrayList;
import java.util.List;

/**
 * The Table class represents a table in the database.
 * It contains a list of columns, a table name, and a reference to the DatabaseManager.
 */
public class Table {
    private String tableName;
    private List<Column> columns;
    private DatabaseManager databaseManager; // Relation to other tables

    /**
     * Constructs a Table with the specified name and database manager.
     *
     * @param tableName the name of the table
     * @param databaseManager the database manager
     */
    public Table(String tableName, DatabaseManager databaseManager) {
        this.tableName = tableName;
        this.columns = new ArrayList<>();
        this.databaseManager = databaseManager;
    }

    /**
     * Adds a column to the table.
     *
     * @param column the column to be added
     */
    public void addColumn(Column column) {
        columns.add(column);
    }

    /**
     * Removes a column from the table.
     *
     * @param column the column to be removed
     */
    public void removeColumn(Column column) {
        columns.remove(column);
    }

    /**
     * Returns the list of columns in the table.
     *
     * @return the list of columns
     */
    public List<Column> getColumns() {
        return columns;
    }

    /**
     * Returns the name of the table.
     *
     * @return the name of the table
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * Sets the name of the table.
     *
     * @param tableName the name to be set
     */
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    /**
     * Adds a row to the table.
     *
     * @param array the data for the row to be added
     * @throws IllegalArgumentException if the row data length does not match the number of columns
     */
    public void addRow(Object[] array) {
        if (array.length != columns.size()) {
            throw new IllegalArgumentException("Row data length does not match number of columns.");
        }
        for (int i = 0; i < columns.size(); i++) {
            if (checkInteger(array[i]))
                columns.get(i).addCell(new Cell(Integer.parseInt((String) array[i])));
            else if (checkDouble(array[i])) {
                columns.get(i).addCell(new Cell(Double.parseDouble((String) array[i])));
            } else {
                columns.get(i).addCell(new Cell(array[i]));
            }
        }
    }

    /**
     * Checks if the given data can be parsed as a double.
     *
     * @param data the data to check
     * @return true if the data can be parsed as a double, false otherwise
     */
    private boolean checkDouble(Object data) {
        try {
            double v = Double.parseDouble((String) data);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Checks if the given data can be parsed as an integer.
     *
     * @param data the data to check
     * @return true if the data can be parsed as an integer, false otherwise
     */
    private boolean checkInteger(Object data) {
        try {
            int v = Integer.parseInt((String) data);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
