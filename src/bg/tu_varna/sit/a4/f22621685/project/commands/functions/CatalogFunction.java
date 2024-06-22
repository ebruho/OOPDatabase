package bg.tu_varna.sit.a4.f22621685.project.commands.functions;

import bg.tu_varna.sit.a4.f22621685.project.table.Table;

import java.util.HashMap;
import java.util.Map;

/**
 * The CatalogFunction class manages a catalog of tables, allowing adding and printing table information.
 */
public class CatalogFunction {
    private Map<String, Table> catalog;

    /**
     * Initializes a new instance of the CatalogFunction class with an empty catalog.
     */
    public CatalogFunction() {
        this.catalog = new HashMap<>();
    }

    /**
     * Adds a table to the catalog.
     *
     * @param filePath the file path associated with the table
     * @param table    the table to add to the catalog
     */
    public void addTable(String filePath, Table table) {
        catalog.put(filePath, table);
    }

    /**
     * Prints the catalog of tables, displaying the file path and table name for each entry.
     */
    public void print() {
        for (Map.Entry<String, Table> stringTableEntry : catalog.entrySet()) {
            System.out.printf("File Path: %s - Table Name: %s%n"
                    , stringTableEntry.getKey(), stringTableEntry.getValue().getTableName());
        }
    }
}
