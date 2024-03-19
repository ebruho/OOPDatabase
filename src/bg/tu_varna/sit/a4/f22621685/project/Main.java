package bg.tu_varna.sit.a4.f22621685.project;

import bg.tu_varna.sit.a4.f22621685.project.table.Cell;
import bg.tu_varna.sit.a4.f22621685.project.table.Column;
import bg.tu_varna.sit.a4.f22621685.project.table.Table;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Table table = new Table();

        // Добавяне на колони към таблицата
        Column<Integer> intColumn = new Column<>();
        intColumn.addCell(new Cell(10));
        intColumn.addCell(new Cell(20));
        intColumn.addCell(new Cell(30));

        table.addColumn(intColumn);

        Column<Double> doubleColumn = new Column<>();
        doubleColumn.addCell(new Cell(10.5));
        doubleColumn.addCell(new Cell(20.5));
        doubleColumn.addCell(new Cell(25.5));

        table.addColumn(doubleColumn);

        Column<String> stringColumn = new Column<>();
        stringColumn.addCell(new Cell("Hello"));
        stringColumn.addCell(new Cell("World"));
        stringColumn.addCell(new Cell("Hi"));

        table.addColumn(stringColumn);
/*
        // Извеждане на данните от таблицата
        List<Column<?>> columns = table.getColumns();
        for (Column<?> column : columns) {
            List<Cell> cells = column.getCells();
            for (Cell cell : cells) {
                System.out.print(cell.getData() + "\t");
            }
            System.out.println();
        }*/

        int numRows = table.getColumns().get(0).getCells().size();

        // Отпечатване на данните вертикално
        for (int i = 0; i < numRows; i++) {
            for (Column<?> column : table.getColumns()) {
                System.out.print(column.getCells().get(i).getData() + "\t|\t");
            }
            System.out.println();
        }
    }
}
