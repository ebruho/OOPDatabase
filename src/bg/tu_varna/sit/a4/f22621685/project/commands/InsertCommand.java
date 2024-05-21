package bg.tu_varna.sit.a4.f22621685.project.commands;

import bg.tu_varna.sit.a4.f22621685.project.errors.InvalidException;
import bg.tu_varna.sit.a4.f22621685.project.table.Cell;
import bg.tu_varna.sit.a4.f22621685.project.table.Column;
import bg.tu_varna.sit.a4.f22621685.project.table.Table;

import java.util.Scanner;

public class InsertCommand {
    public static void addRow(Table table, Scanner scanner) throws InvalidException {
        if (table == null || scanner == null) {
            throw new InvalidException("Error: Invalid table or scanner.");
        }

        // Намиране на максималния брой редове във всички колони (ако е необходимо)
        int maxRows = 0;
        for (Column column : table.getColumns()) {
            int columnSize = column.getCells().size();
            if (columnSize > maxRows) {
                maxRows = columnSize;
            }
        }

        System.out.println("Enter values for each column:");

        // Инициализация на масива за данните на новия ред
        Object[] rowData = new Object[table.getColumns().size()];

        for (int i = 0; i < table.getColumns().size(); i++) {
            Column column = table.getColumns().get(i);
            System.out.println(column.getColumnName() + ": ");
            String input = scanner.next();

            // Проверка за null стойности и празни входове
            if (input.equalsIgnoreCase("null")) {
                rowData[i] = null;
            } else {
                rowData[i] = input;
            }
        }

        // Добавяне на новия ред в таблицата
        table.addRow(rowData);
    }
}
