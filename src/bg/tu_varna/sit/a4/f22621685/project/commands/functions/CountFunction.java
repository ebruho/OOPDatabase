package bg.tu_varna.sit.a4.f22621685.project.commands.functions;

import bg.tu_varna.sit.a4.f22621685.project.table.Cell;
import bg.tu_varna.sit.a4.f22621685.project.table.Column;
import bg.tu_varna.sit.a4.f22621685.project.table.Table;

import java.util.List;

/**
 * The CountFunction class provides functionality to count rows with a specific value in a table.
 */
public class CountFunction {

    /**
     * Counts the number of rows in the specified table where the given value exists in the specified column.
     *
     * @param table            the table in which to search for rows
     * @param searchColumnName the name of the column to search for the value
     * @param searchValue      the value to search for within the column
     * @return the number of rows containing the search value in the specified column
     */
    public int countRowsWithGivenValue(Table table, String searchColumnName, Object searchValue) {
        int count = 0;

        List<Column> columns = table.getColumns();
        for (Column column : columns) {
            if (column.getColumnName().equals(searchColumnName)) {
                List<Cell> cells = column.getCells();
                for (Cell cell : cells) {
                    if (String.valueOf(cell.getData()).equals(searchValue)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

}
