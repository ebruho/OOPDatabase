package bg.tu_varna.sit.a4.f22621685.project.commands.functions;

import bg.tu_varna.sit.a4.f22621685.project.errors.InvalidException;
import bg.tu_varna.sit.a4.f22621685.project.table.Column;
import bg.tu_varna.sit.a4.f22621685.project.table.Table;

import java.util.Scanner;

/**
 * The InsertFunction class provides functionality to add a new row to a table.
 */
public class InsertFunction {

    /**
     * Adds a new row to the specified table by taking input values from the user.
     *
     * @param table the table to which the new row will be added
     * @throws InvalidException if the table or scanner is invalid
     */
    public void addRow(Table table) throws InvalidException {
        Scanner scanner = new Scanner(System.in);
        if (table == null || scanner == null) {
            throw new InvalidException("Error: Invalid table or scanner.");
        }

        // Finding the maximum number of rows in all columns (if necessary)
        int maxRows = 0;
        for (Column column : table.getColumns()) {
            int columnSize = column.getCells().size();
            if (columnSize > maxRows) {
                maxRows = columnSize;
            }
        }

        System.out.println("Enter values for each column:");

        // Initializing an array for the new row data
        Object[] rowData = new Object[table.getColumns().size()];

        for (int i = 0; i < table.getColumns().size(); i++) {
            Column column = table.getColumns().get(i);
            System.out.print(column.getColumnName() + ": ");
            String input = scanner.next();

            // Checking for null values and empty inputs
            if (input.equalsIgnoreCase("null")) {
                rowData[i] = null;
            } else {
                rowData[i] = input;
            }
        }

        // Adding the new row to the table
        table.addRow(rowData);
    }
}
