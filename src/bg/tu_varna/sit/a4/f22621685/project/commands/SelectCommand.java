package bg.tu_varna.sit.a4.f22621685.project.commands;

import bg.tu_varna.sit.a4.f22621685.project.table.Table;
import bg.tu_varna.sit.a4.f22621685.project.table.Column;
import bg.tu_varna.sit.a4.f22621685.project.table.Cell;

import java.util.List;

public class SelectCommand {

    public static void selectRows(String columnName, Object value, Table table, int pageNumber, int pageSize) {
        if (table == null) {
            System.out.println("Error: Invalid table.");
            return;
        }

        Column selectedColumn = null;
        for (Column column : table.getColumns()) {
            if (column.getColumnName().equalsIgnoreCase(columnName)) {
                selectedColumn = column;
                break;
            }
        }

        if (selectedColumn == null) {
            System.out.println("Error: Column '" + columnName + "' not found.");
            return;
        }

        List<Cell> cells = selectedColumn.getCells();
        System.out.println("Selected rows from table '" + table.getTableName() + "' where column '" + columnName + "' has value '" + value + "':");
        int count = 0;
        for (int i = 0; i < cells.size(); i++) {
            Cell cell = cells.get(i);
            if (cell.getData() != null && cell.getData().equals(value)) {
                if (count >= (pageNumber - 1) * pageSize && count < pageNumber * pageSize) {
                    System.out.print("Row " + (i + 1) + ": ");
                    for (Column column : table.getColumns()) {
                        System.out.print(column.getColumnName() + ": " + column.getCells().get(i).getData() + " | ");
                    }
                    System.out.println();
                }
                count++;
            }
        }

        if (count == 0) {
            System.out.println("No rows found with the specified value in the selected column.");
        }
    }
}
