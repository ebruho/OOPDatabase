package bg.tu_varna.sit.a4.f22621685.project.commands.functions;

import bg.tu_varna.sit.a4.f22621685.project.database.DatabaseManager;
import bg.tu_varna.sit.a4.f22621685.project.errors.InvalidException;
import bg.tu_varna.sit.a4.f22621685.project.table.Column;
import bg.tu_varna.sit.a4.f22621685.project.table.Table;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * The ImportFunction class provides functionality to import table data from a file.
 */
public class ImportFunction {
    private DatabaseManager databaseManager;

    /**
     * Constructs an ImportFunction object with the specified DatabaseManager.
     *
     * @param databaseManager the DatabaseManager instance used to manage tables
     */
    public ImportFunction(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
    }

    /**
     * Imports table data from the specified file path and adds it to the database.
     *
     * @param filePath the path to the file containing the table data
     * @throws RuntimeException if the file does not exist or if there is an error during file reading
     */
    public void importFile(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new RuntimeException("Error: The file does not exist.");
        }

        try (FileReader fileReader = new FileReader(file)) {
            Scanner scanner = new Scanner(fileReader);

            // Read table name from the first line
            if (!scanner.hasNext()) {
                throw new RuntimeException("Error: Empty file.");
            }
            String tableName = scanner.nextLine();
            Table table = new Table(tableName, databaseManager);

            // Read column names from the second line
            if (!scanner.hasNext()) {
                throw new RuntimeException("Error: Missing column names.");
            }
            String[] columnNames = scanner.nextLine().split("==");
            for (String columnName : columnNames) {
                table.addColumn(new Column(columnName));
            }

            // Read rows and add them to the table
            while (scanner.hasNext()) {
                String[] columnValues = scanner.nextLine().split("==");
                table.addRow(columnValues);
            }

            // Add the table to the database manager
            databaseManager.addTable(table);

            // Add the table to the catalog function for tracking purposes
            databaseManager.getCatalogFunction().addTable(filePath, table);

            System.out.println("Successfully imported data from " + filePath);
        } catch (InvalidException | IOException e) {
            throw new RuntimeException("Error importing data: " + e.getMessage());
        }
    }
}
