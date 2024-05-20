package bg.tu_varna.sit.a4.f22621685.project.commands;

import bg.tu_varna.sit.a4.f22621685.project.table.Cell;
import bg.tu_varna.sit.a4.f22621685.project.table.Column;
import bg.tu_varna.sit.a4.f22621685.project.table.Table;

import java.util.ArrayList;
import java.util.List;

public class SelectCommand {

    public static void selectRows(String columnName, Object searchValue, Table table) {
        if (table == null) {
            System.out.println("Error: Invalid table.");
            return;
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
        Column searchColumn = table.getColumns().get(columnIndex);
        for (int i = 0; i < searchColumn.getCells().size(); i++) {
            Cell cell = searchColumn.getCells().get(i);
            Object data = cell.getData();
            if (data != null && data.equals(searchValue)) {
                System.out.println("Row " + (i + 1) + ": " + formatRow(table, i));
            }
        }
    }

    // Форматиране на реда за отпечатване
    private static String formatRow(Table table, int rowIndex) {
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
