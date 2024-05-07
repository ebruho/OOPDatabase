package bg.tu_varna.sit.a4.f22621685.project.commands;

import bg.tu_varna.sit.a4.f22621685.project.table.Column;
import bg.tu_varna.sit.a4.f22621685.project.table.Table;

public class DeleteCommand {
    public static void deleteRows(Table table, String searchColumnName, Object searchValue) {
        if (table == null || searchColumnName == null || searchValue == null) {
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
        for (int i = 0; i < searchColumn.getCells().size(); i++) {
            if (searchColumn.getCells().get(i).getData().equals(searchValue)) {
                for (Column column : table.getColumns()) {
                    column.getCells().remove(i);
                }
                i--; // Намаляваме i, за да не пропуснем следващия ред
            }
        }

        System.out.println("Rows deleted successfully.");
    }
}
