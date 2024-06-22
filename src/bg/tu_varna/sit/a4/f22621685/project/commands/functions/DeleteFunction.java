package bg.tu_varna.sit.a4.f22621685.project.commands.functions;

import bg.tu_varna.sit.a4.f22621685.project.table.Cell;
import bg.tu_varna.sit.a4.f22621685.project.table.Column;
import bg.tu_varna.sit.a4.f22621685.project.table.Table;

import java.util.List;

/**
 * The DeleteFunction class provides functionality to delete rows from a table based on a column and search value.
 */
public class DeleteFunction {

    /**
     * Deletes rows from a table based on a column name and search value.
     *
     * @param table           the table from which to delete rows
     * @param searchColumnName the name of the column to search
     * @param searchValue     the value to search for in the column
     */
    public void deleteRows(Table table, String searchColumnName, Object searchValue) {
        if (table == null || searchColumnName == null) {
            System.out.println("Error: Invalid input.");
            return;
        }

        // Find the index of the search column
        int columnIndex = -1;
        for (int i = 0; i < table.getColumns().size(); i++) {
            if (table.getColumns().get(i).getColumnName().equalsIgnoreCase(searchColumnName)) {
                columnIndex = i;
                break;
            }
        }

        // Check if the column was found
        if (columnIndex == -1) {
            System.out.println("Error: Column " + searchColumnName + " not found.");
            return;
        }

        // Delete rows with the corresponding value in the search column
        boolean found = false;
        Column searchColumn = table.getColumns().get(columnIndex);
        List<Cell> cells = searchColumn.getCells();
        for (int i = 0; i < cells.size(); i++) {
            if (String.valueOf(cells.get(i).getData()).equals(searchValue)) {
                removeRow(table, i);
                i--;
                found=true;
            }
        }
        if(!found){
            System.out.println("That value doesn't exist ");
        }
        else
            System.out.println("Rows deleted successfully.");
    }

    /**
     * Removes a row from the table at the specified index.
     *
     * @param table    the table from which to remove the row
     * @param rowIndex the index of the row to remove
     */
    private void removeRow(Table table, int rowIndex) {
        for (Column column : table.getColumns()) {
            if (rowIndex < column.getCells().size()) {
                column.getCells().remove(rowIndex);
            }
        }
    }
}
