package bg.tu_varna.sit.a4.f22621685.project;

import bg.tu_varna.sit.a4.f22621685.project.table.Cell;
import bg.tu_varna.sit.a4.f22621685.project.table.Column;
import bg.tu_varna.sit.a4.f22621685.project.table.Table;
import bg.tu_varna.sit.a4.f22621685.project.table.TablePrinter;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Table table = new Table("Different types data");

        // Добавяне на колони към таблицата
        Column intColumn = new Column("Integer");
        intColumn.addCell(new Cell(10));
        intColumn.addCell(new Cell(20));
        intColumn.addCell(new Cell(30));

        table.addColumn(intColumn);

        Column doubleColumn = new Column("Decimal numbers");
        doubleColumn.addCell(new Cell(10.5));
        doubleColumn.addCell(new Cell(20.5));
        doubleColumn.addCell(new Cell(25.5));



        table.addColumn(doubleColumn);

        Column stringColumn = new Column("Text data");
        stringColumn.addCell(new Cell("Hello"));
        stringColumn.addCell(new Cell("World"));
        stringColumn.addCell(new Cell("Pesho"));

        table.addColumn(stringColumn);

        Table table1 = new Table("Text data");
        table1.addColumn(stringColumn);

        TablePrinter.printTable(table);
        TablePrinter.printTable(table1);
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


    }
}
