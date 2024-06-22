package bg.tu_varna.sit.a4.f22621685.project.commands.functions;

import bg.tu_varna.sit.a4.f22621685.project.errors.InvalidException;
import bg.tu_varna.sit.a4.f22621685.project.table.Cell;
import bg.tu_varna.sit.a4.f22621685.project.table.Column;
import bg.tu_varna.sit.a4.f22621685.project.table.Table;

import java.util.List;

/**
 * The SelectFunction class provides functionality to select rows from a table based on a column and search value.
 */
public class SelectFunction {

    /**
     * Selects rows from a table based on a column name and search value.
     *
     * @param columnName  the name of the column to search
     * @param searchValue the value to search for in the column
     * @param table       the table from which to select rows
     * @throws InvalidException if the table is invalid (null)
     */
    public void selectRows(String columnName, Object searchValue, Table table) throws InvalidException {
        if (table == null) {
            throw new InvalidException("Error: Invalid table.");
        }

        // Намиране на индекса на търсената колона
        int columnIndex = -1;
        List<Column> columns = table.getColumns();
        for (int i = 0; i < columns.size(); i++) {
            if (columns.get(i).getColumnName().equals(columnName)) {
                columnIndex = i;
                break;
            }
        }

        if (columnIndex == -1) {
            System.out.println("Error: Column '" + columnName + "' not found.");
            return;
        }

        // Извеждане на заглавието
        System.out.println("Selected rows from table '" + table.getTableName() + "' where column '" + columnName + "' has value '" + searchValue + "':");

        // Извеждане на съответните редове
        // Print the matching rows
        Column searchColumn = table.getColumns().get(columnIndex);
        boolean found = false;
        for (int i = 0; i < searchColumn.getCells().size(); i++) {
            Cell cell = searchColumn.getCells().get(i);
            Object data = cell.getData();
            if (data != null && String.valueOf(data).equals(searchValue)) {
                System.out.println("Row " + (i + 1) + ": " + formatRow(table, i));
                found = true;
            }
        }

        if (!found) {
            System.out.println("No rows found with " + columnName + " = " + searchValue);
        }
    }

    /**
     * Formats the row for printing.
     *
     * @param table    the table containing the row
     * @param rowIndex the index of the row to format
     * @return the formatted row as a string
     */
    private String formatRow(Table table, int rowIndex) {
        List<Column> columns = table.getColumns();
        StringBuilder formattedRow = new StringBuilder();
        for (int i = 0; i < columns.size(); i++) {
            Column column = columns.get(i);
            List<Cell> cells = column.getCells();
            if (rowIndex < cells.size()) {
                Object data = cells.get(rowIndex).getData();
                formattedRow.append(column.getColumnName()).append(": ").append(data).append(" | ");
            }
        }
        return formattedRow.toString();
    }
}
