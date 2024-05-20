package bg.tu_varna.sit.a4.f22621685.project.commands;

import bg.tu_varna.sit.a4.f22621685.project.table.Cell;
import bg.tu_varna.sit.a4.f22621685.project.table.Column;
import bg.tu_varna.sit.a4.f22621685.project.table.Table;

import java.util.Iterator;

public class DeleteCommand {

    public static void deleteRows(Table table, String searchColumnName, Object searchValue) {
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
        Iterator<Cell> searchColumnIterator = searchColumn.getCells().iterator();
        int rowIndex = 0;

        while (searchColumnIterator.hasNext()) {
            Cell cell = searchColumnIterator.next();
            if (cell != null && cell.getData() != null) {
                if (searchValue == null && cell.getData() == null) {
                    // Ако търсената стойност и стойността на клетката са null
                    removeRow(table, rowIndex);
                    rowIndex--; // Намаляваме rowIndex, за да не пропуснем следващия ред
                } else if (searchValue != null && searchValue.equals(cell.getData())) {
                    // Ако стойностите съвпадат
                    removeRow(table, rowIndex);
                    rowIndex--; // Намаляваме rowIndex, за да не пропуснем следващия ред
                }
            }
            rowIndex++;
        }

        System.out.println("Rows deleted successfully.");
    }

    private static void removeRow(Table table, int rowIndex) {
        for (Column column : table.getColumns()) {
            if (rowIndex < column.getCells().size()) {
                column.getCells().remove(rowIndex);
            }
        }
    }
}
