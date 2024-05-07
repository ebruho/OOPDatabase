package bg.tu_varna.sit.a4.f22621685.project.commands;

import bg.tu_varna.sit.a4.f22621685.project.errors.InvalidException;
import bg.tu_varna.sit.a4.f22621685.project.table.Cell;
import bg.tu_varna.sit.a4.f22621685.project.table.Column;
import bg.tu_varna.sit.a4.f22621685.project.table.Table;

import java.util.Scanner;

public class InsertCommand {
    public static void addRow(Table table, Scanner scanner) throws InvalidException {
        if(table==null||scanner==null){
            throw new InvalidException("Error: Invalid table or scanner.");
        }

        int maxRows = 0;

        // Намиране на максималния брой редове във всички колони
        for (Column column : table.getColumns()) {
            int columnSize = column.getCells().size();
            if (columnSize > maxRows) {
                maxRows = columnSize;
            }
        }

        System.out.println("Enter values for each column:");

        for (Column column: table.getColumns()){
            System.out.println(column.getColumnName()+": ");
            Object value = scanner.next();
            column.addCell(new Cell(value));

        }


    }

}
