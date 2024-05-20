package bg.tu_varna.sit.a4.f22621685.project.commands;

import bg.tu_varna.sit.a4.f22621685.project.table.Cell;
import bg.tu_varna.sit.a4.f22621685.project.table.Column;
import bg.tu_varna.sit.a4.f22621685.project.table.Table;

public class UpdateCommand {
    public static void updateRows(Table table, String searchColumnName, Object searchValue,
                                  String targetColumnName, Object targetValue) {
        if (table == null || searchColumnName == null || searchValue == null || targetColumnName == null) {
            System.out.println("Error: Invalid input.");
            return;
        }

        // Намиране на индекса на търсената колона
        int searchColumnIndex = -1;
        for (int i = 0; i < table.getColumns().size(); i++) {
            if (table.getColumns().get(i).getColumnName().equalsIgnoreCase(searchColumnName)) {
                searchColumnIndex = i;
                break;
            }
        }

        // Проверка дали търсената колона е намерена
        if (searchColumnIndex == -1) {
            System.out.println("Error: Search column " + searchColumnName + " not found.");
            return;
        }

        // Намиране на индекса на целевата колона
        int targetColumnIndex = -1;
        for (int i = 0; i < table.getColumns().size(); i++) {
            if (table.getColumns().get(i).getColumnName().equalsIgnoreCase(targetColumnName)) {
                targetColumnIndex = i;
                break;
            }
        }

        // Проверка дали целевата колона е намерена
        if (targetColumnIndex == -1) {
            System.out.println("Error: Target column " + targetColumnName + " not found.");
            return;
        }

        // Промяна на стойностите на редовете, които отговарят на търсените критерии
        Column searchColumn = table.getColumns().get(searchColumnIndex);
        Column targetColumn = table.getColumns().get(targetColumnIndex);
        for (int i = 0; i < searchColumn.getCells().size(); i++) {
            Cell cell = searchColumn.getCells().get(i);
            if (cell != null && cell.getData() != null && cell.getData().equals(searchValue)) {
                // Промяна на стойността на целевата колона
                if (i < targetColumn.getCells().size()) {
                    targetColumn.getCells().get(i).setData(targetValue);
                } else {
                    // Ако индексът на реда надвишава броя на клетките в целевата колона, добавяме нова клетка
                    targetColumn.addCell(new Cell(targetValue));
                }
            }
        }

        System.out.println("Rows updated successfully.");
    }
}
