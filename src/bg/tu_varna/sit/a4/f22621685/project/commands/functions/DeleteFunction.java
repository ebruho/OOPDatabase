package bg.tu_varna.sit.a4.f22621685.project.commands.functions;

import bg.tu_varna.sit.a4.f22621685.project.table.Cell;
import bg.tu_varna.sit.a4.f22621685.project.table.Column;
import bg.tu_varna.sit.a4.f22621685.project.table.Table;

import java.util.List;

public class DeleteFunction {

    public void deleteRows(Table table, String searchColumnName, Object searchValue) {
        if (table == null || searchColumnName == null) {
            System.out.println("Error: Invalid input.");
            return;
        }

        // Намиране на индекса на търсената колона
        int columnIndex = -1;
        for (int i = 0; i < table.getColumns().size(); i++) {
            if (table.getColumns().get(i).getColumnName().equalsIgnoreCase(searchColumnName)) {
                columnIndex = i;
                break;
            }
        }

        // Проверка дали колоната е намерена
        if (columnIndex == -1) {
            System.out.println("Error: Column " + searchColumnName + " not found.");
            return;
        }

        // Изтриване на редовете със съответната стойност в търсената колона
        Column searchColumn = table.getColumns().get(columnIndex);
        List<Cell> cells = searchColumn.getCells();
        for (int i = 0; i < cells.size(); i++) {
            if(cells.get(i).getData().equals(searchValue)){
               removeRow(table,i);
               i--;
            }
        }
        System.out.println("Rows deleted successfully.");
    }

    private void removeRow(Table table, int rowIndex) {
        for (Column column : table.getColumns()) {
            if (rowIndex < column.getCells().size()) {
                column.getCells().remove(rowIndex);
            }
        }
    }
}
