package bg.tu_varna.sit.a4.f22621685.project.commands.functions;

import bg.tu_varna.sit.a4.f22621685.project.errors.InvalidException;
import bg.tu_varna.sit.a4.f22621685.project.table.Cell;
import bg.tu_varna.sit.a4.f22621685.project.table.Column;
import bg.tu_varna.sit.a4.f22621685.project.table.Table;

public class UpdateFunction {

    /**
     * Updates rows in a table based on specified search and target criteria.
     *
     * @param table            The table in which rows are to be updated. Must not be null.
     * @param searchColumnName The name of the column used for searching rows to update. Must not be null.
     * @param searchValue      The value to search for in the search column. Must not be null.
     * @param targetColumnName The name of the column where values will be updated. Must not be null.
     * @param targetValue      The new value to set in the target column for matched rows.
     * @throws InvalidException If any of the input parameters are null or if search or target columns are not found.
     */
    public void updateRows(Table table, String searchColumnName, Object searchValue,
                           String targetColumnName, Object targetValue) throws InvalidException {
        // Validate input parameters
        if (table == null || searchColumnName == null || searchValue == null || targetColumnName == null) {
            throw new InvalidException("Error: Invalid input.");
        }

        // Find the index of the search column
        int searchColumnIndex = -1;
        for (int i = 0; i < table.getColumns().size(); i++) {
            if (table.getColumns().get(i).getColumnName().equalsIgnoreCase(searchColumnName)) {
                searchColumnIndex = i;
                break;
            }
        }

        // Check if the search column is found
        if (searchColumnIndex == -1) {
            System.out.println("Error: Search column " + searchColumnName + " not found.");
            return;
        }

        // Find the index of the target column
        int targetColumnIndex = -1;
        for (int i = 0; i < table.getColumns().size(); i++) {
            if (table.getColumns().get(i).getColumnName().equalsIgnoreCase(targetColumnName)) {
                targetColumnIndex = i;
                break;
            }
        }

        // Check if the target column is found
        if (targetColumnIndex == -1) {
            System.out.println("Error: Target column " + targetColumnName + " not found.");
            return;
        }


        // Update values in the target column for rows matching the search criteria
        Column searchColumn = table.getColumns().get(searchColumnIndex);
        Column targetColumn = table.getColumns().get(targetColumnIndex);
        for (int i = 0; i < searchColumn.getCells().size(); i++) {
            Cell cell = searchColumn.getCells().get(i);
            if (cell != null && cell.getData() != null && String.valueOf(cell.getData()).equals(searchValue)) {
                // Update the value in the target column
                if (i < targetColumn.getCells().size()) {
                    targetColumn.getCells().get(i).setData(targetValue);
                } else {
                    // If the row index exceeds the number of cells in the target column, add a new cell
                    targetColumn.addCell(new Cell(targetValue));
                }
            }
        }

        System.out.println("Rows updated successfully.");
    }
}
