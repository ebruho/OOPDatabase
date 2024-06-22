package bg.tu_varna.sit.a4.f22621685.project.database;

import bg.tu_varna.sit.a4.f22621685.project.commands.functions.CatalogFunction;
import bg.tu_varna.sit.a4.f22621685.project.errors.InvalidException;
import bg.tu_varna.sit.a4.f22621685.project.table.Table;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * The DatabaseManager class is responsible for managing tables within a database.
 * It allows for adding, removing, renaming, and retrieving tables.
 */
public class DatabaseManager {
    private Map<String, Table> tables;
    private String filePath;
    private CatalogFunction catalogFunction;

    /**
     * Constructs a new DatabaseManager.
     */
    public DatabaseManager() {
        this.tables = new HashMap<>();
        this.filePath = null;
        this.catalogFunction = new CatalogFunction();
    }

    /**
     * Adds a new table to the database.
     *
     * @param table the table to add
     * @throws InvalidException if a table with the same name already exists
     */
    public void addTable(Table table) throws InvalidException {
        if (tables.containsKey(table.getTableName())) {
            throw new InvalidException("Error: Table with name \"" + table.getTableName() + "\" already exists.");
        }
        tables.put(table.getTableName(), table);
    }

    /**
     * Removes a table from the database.
     *
     * @param tableName the name of the table to remove
     */
    public void removeTable(String tableName) {
        tables.remove(tableName);
    }

    /**
     * Checks if a table name is unique.
     *
     * @param newTableName the name to check
     * @return true if the name is unique, false otherwise
     */
    public boolean isTableNameUnique(String newTableName) {
        return !tables.containsKey(newTableName);
    }

    /**
     * Gets the file path associated with the database.
     *
     * @return the file path
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * Sets the file path associated with the database.
     *
     * @param filePath the file path to set
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Renames a table in the database.
     *
     * @param oldName the current name of the table
     * @param newName the new name for the table
     * @throws InvalidException if the old table does not exist or the new name is already in use
     */
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

    /**
     * Gets a table by its name.
     *
     * @param tableName the name of the table
     * @return the table, or null if it does not exist
     */
    public Table getTable(String tableName) {
        return tables.get(tableName);
    }

    /**
     * Gets a list of all table names in the database.
     *
     * @return a list of table names
     */
    public List<String> getTableNames() {
        return tables.keySet().stream().collect(Collectors.toList());
    }

    /**
     * Gets the catalog function associated with the database.
     *
     * @return the catalog function
     */
    public CatalogFunction getCatalogFunction() {
        return catalogFunction;
    }

    /**
     * Sets the catalog function associated with the database.
     *
     * @param catalogFunction the catalog function to set
     */
    public void setCatalogFunction(CatalogFunction catalogFunction) {
        this.catalogFunction = catalogFunction;
    }
}
