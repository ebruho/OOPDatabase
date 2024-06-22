package bg.tu_varna.sit.a4.f22621685.project.commands.functions;

import bg.tu_varna.sit.a4.f22621685.project.table.Cell;
import bg.tu_varna.sit.a4.f22621685.project.table.Column;
import bg.tu_varna.sit.a4.f22621685.project.table.Table;

import java.util.ArrayList;
import java.util.List;

public class TablePrinter {

    public void printTable(Table table){
        int maxRows = 0;

        // Намиране на максималния брой редове във всички колони
        if(table==null){
            System.out.println("There is no such table!");
            return;
        }
        for (Column column : table.getColumns()) {
            int columnSize = column.getCells().size();
            if (columnSize > maxRows) {
                maxRows = columnSize;
            }
        }

        // Намиране на максималната дължина на данните във всяка колона
        List<Integer> maxColumnWidths = new ArrayList<>();
        for (Column column : table.getColumns()) {
            int maxCellWidth = column.getColumnName().length();
            for (Cell cell : column.getCells()) {
                int cellWidth=0;
                if(cell.getData()==null){
                    cellWidth=4;
                }else {
                    cellWidth = cell.getData().toString().length();
                }
                if (cellWidth > maxCellWidth) {
                    maxCellWidth = cellWidth;
                }
            }
            maxColumnWidths.add(maxCellWidth);
        }

        // Отпечатване на името на таблицата
        System.out.println("Table: " + table.getTableName());

        // Отпечатване на заглавията на колоните
        for (int i = 0; i < table.getColumns().size(); i++) {
            String columnName = table.getColumns().get(i).getColumnName();
            int columnWidth = maxColumnWidths.get(i);
            System.out.print(padRight(columnName, columnWidth) + "\t|\t");
        }
        System.out.println();

        // Отпечатване на разделителна линия
        for (int columnWidth : maxColumnWidths) {
            for (int i = 0; i < columnWidth; i++) {
                System.out.print("-");
            }
            System.out.print("\t|\t");
        }
        System.out.println();

        // Отпечатване на данните
        for (int i = 0; i < maxRows; i++) {
            for (int j = 0; j < table.getColumns().size(); j++) {
                Column column = table.getColumns().get(j);
                if (i < column.getCells().size()) {
                    String cellData="";
                    if(column.getCells().get(i).getData()==null){
                        cellData = "NULL";
                    }else {
                        cellData = column.getCells().get(i).getData().toString();
                    }
                    int columnWidth = maxColumnWidths.get(j);
                    System.out.print(padRight(cellData, columnWidth) + "\t|\t");
                } else {
                    int columnWidth = maxColumnWidths.get(j);
                    System.out.print(padRight("NULL", columnWidth) + "\t|\t");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    // Функция за добавяне на празно пространство до дадена дължина
    private String padRight(String s, int n) {
        return String.format("%-" + n + "s", s);
    }
}
