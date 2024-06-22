package bg.tu_varna.sit.a4.f22621685.project.commands.functions;

import bg.tu_varna.sit.a4.f22621685.project.errors.InvalidException;
import bg.tu_varna.sit.a4.f22621685.project.table.Cell;
import bg.tu_varna.sit.a4.f22621685.project.table.Column;
import bg.tu_varna.sit.a4.f22621685.project.table.Table;

/**
 * The AggregateFunctions class provides methods to perform various aggregate operations on table data.
 */
public class AggregateFunctions {

    /**
     * Performs an aggregate operation (sum, product, maximum, minimum) on the target column of a table
     * where the search column matches the specified search value.
     *
     * @param table           the table on which to perform the aggregation
     * @param searchColumnName the name of the column to search
     * @param searchValue     the value to search for in the search column
     * @param targetColumnName the name of the column to aggregate
     * @param operation       the aggregation operation to perform ("sum", "product", "maximum", "minimum")
     * @throws InvalidException if any input is invalid or if the operation is invalid
     */
    public void aggregate(Table table, String searchColumnName, Object searchValue, String targetColumnName, String operation) throws InvalidException {
        if (table == null || searchColumnName == null || searchValue == null || targetColumnName == null || operation == null) {
            throw new InvalidException("Error: Invalid input.");
        }

        // Find the indexes of the search and target columns
        int searchColumnIndex = -1;
        int targetColumnIndex = -1;

        for (int i = 0; i < table.getColumns().size(); i++) {
            if (table.getColumns().get(i).getColumnName().equalsIgnoreCase(searchColumnName)) {
                searchColumnIndex = i;
            }
            if (table.getColumns().get(i).getColumnName().equalsIgnoreCase(targetColumnName)) {
                targetColumnIndex = i;
            }
        }

        if (searchColumnIndex == -1) {
            throw new InvalidException("Error: Search column " + searchColumnName + " not found.");
        }
        if (targetColumnIndex == -1) {
            throw new InvalidException("Error: Target column " + targetColumnName + " not found.");
        }

        Column searchColumn = table.getColumns().get(searchColumnIndex);
        Column targetColumn = table.getColumns().get(targetColumnIndex);

        // Check if the target column is numeric
        if (!isNumericColumn(targetColumn)) {
            throw new InvalidException("Error: Target column " + targetColumnName + " is not numeric.");
        }

        double result = 0;
        boolean first = true;
        int validRowsCount = 0;

        for (int i = 0; i < searchColumn.getCells().size(); i++) {
            Cell searchCell = searchColumn.getCells().get(i);
            Cell targetCell = targetColumn.getCells().get(i);

            if (searchCell != null && searchCell.getData() != null && (searchCell.getData()).equals(searchValue) &&
                    targetCell != null && targetCell.getData() != null) {

                validRowsCount++;
                double value = ((Number) targetCell.getData()).doubleValue();

                switch (operation.toLowerCase()) {
                    case "sum":
                        result += value;
                        break;
                    case "product":
                        if (first) {
                            result = value;
                            first = false;
                        } else {
                            result *= value;
                        }
                        break;
                    case "maximum":
                        if (first) {
                            result = value;
                            first = false;
                        } else {
                            result = Math.max(result, value);
                        }
                        break;
                    case "minimum":
                        if (first) {
                            result = value;
                            first = false;
                        } else {
                            result = Math.min(result, value);
                        }
                        break;
                    default:
                        throw new InvalidException("Error: Invalid operation " + operation + ".");
                }
            }
        }

        if (validRowsCount == 0) { // If no valid rows are found for aggregation
            throw new InvalidException("Error: No valid rows found for aggregation.");
        }

        System.out.println("Result of " + operation + " operation: " + result);
    }

    /**
     * Checks if a column contains only numeric values.
     *
     * @param column the column to check
     * @return true if the column is numeric, false otherwise
     */
    private boolean isNumericColumn(Column column) {
        for (Cell cell : column.getCells()) {
            if (cell != null && cell.getData() != null && !(cell.getData() instanceof Number)) {
                return false;
            }
        }
        return true;
    }
}
