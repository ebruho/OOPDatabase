package bg.tu_varna.sit.a4.f22621685.project.commands.functions;

import bg.tu_varna.sit.a4.f22621685.project.database.DatabaseManager;
import bg.tu_varna.sit.a4.f22621685.project.table.Column;
import bg.tu_varna.sit.a4.f22621685.project.table.Table;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * The ExportFunctions class provides functionality to export table data to a file.
 */
public class ExportFunctions {
    private final DatabaseManager databaseManager;

    /**
     * Constructs an ExportFunctions object with the specified DatabaseManager.
     *
     * @param databaseManager the DatabaseManager instance used to access tables
     */
    public ExportFunctions(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
    }

    /**
     * Exports the data from the specified table to the specified file path.
     *
     * @param tableName the name of the table to export
     * @param filePath  the file path where the data will be exported
     * @throws RuntimeException if there is an error during file writing
     */
    public void export(String tableName, String filePath) {
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            Table table = databaseManager.getTable(tableName);
            if (table == null) {
                System.out.println("Error: Table " + tableName + " does not exist.");
                return;
            }

            // Add the table to the catalog function for tracking purposes
            databaseManager.getCatalogFunction().addTable(filePath, table);

            // Write table name to the file
            fileWriter.write(table.getTableName());
            fileWriter.write(System.lineSeparator());

            // Write column names to the file
            writeColumnNames(table.getColumns(), fileWriter);

            // Write data rows to the file
            writeValues(table.getColumns(), fileWriter);

        } catch (IOException e) {
            throw new RuntimeException("Error writing to file: " + e.getMessage());
        }
    }

    /**
     * Writes the column names of the table to the specified file writer.
     *
     * @param columns    the list of columns in the table
     * @param fileWriter the FileWriter object to write to
     * @throws IOException if there is an error during file writing
     */
    private void writeColumnNames(List<Column> columns, FileWriter fileWriter) throws IOException {
        for (int j = 0; j < columns.size(); j++) {
            if (j != columns.size() - 1) {
                fileWriter.write(String.valueOf(columns.get(j).getColumnName()));
                fileWriter.write("=="); // Separator between column names
            } else {
                fileWriter.write(String.valueOf(columns.get(j).getColumnName()));
            }
        }
        fileWriter.write(System.lineSeparator());
    }

    /**
     * Writes the data rows of the table to the specified file writer.
     *
     * @param columns    the list of columns in the table
     * @param fileWriter the FileWriter object to write to
     * @throws IOException if there is an error during file writing
     */
    private void writeValues(List<Column> columns, FileWriter fileWriter) throws IOException {
        int numRows = columns.isEmpty() ? 0 : columns.get(0).getCells().size();

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < columns.size(); j++) {
                if (j != columns.size() - 1) {
                    fileWriter.write(String.valueOf(columns.get(j).getCells().get(i).getData()));
                    fileWriter.write("=="); // Separator between cell values
                } else {
                    fileWriter.write(String.valueOf(columns.get(j).getCells().get(i).getData()));
                }
            }
            fileWriter.write(System.lineSeparator()); // New line for each row
        }
    }
}
