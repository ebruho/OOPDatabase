
import bg.tu_varna.sit.a4.f22621685.project.Database.DatabaseManager;
import bg.tu_varna.sit.a4.f22621685.project.commands.CountCommand;
import bg.tu_varna.sit.a4.f22621685.project.commands.DescribeCommand;
import bg.tu_varna.sit.a4.f22621685.project.commands.InsertCommand;
import bg.tu_varna.sit.a4.f22621685.project.errors.InvalidException;
import bg.tu_varna.sit.a4.f22621685.project.table.Cell;
import bg.tu_varna.sit.a4.f22621685.project.table.Column;
import bg.tu_varna.sit.a4.f22621685.project.table.Table;
import bg.tu_varna.sit.a4.f22621685.project.commands.TablePrinter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DatabaseManager databaseManager = new DatabaseManager();
        Table table = new Table("Different types data",databaseManager);

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
        stringColumn.addCell(new Cell("Pesho"));



        table.addColumn(stringColumn);

        Column nullColumn = new Column("Null data");
        nullColumn.addCell(new Cell("Pesho"));

        Table table1 = new Table("Text data",databaseManager);
        table1.addColumn(stringColumn);
        table1.addColumn(nullColumn);

        TablePrinter.printTable(table);
        TablePrinter.printTable(table1);

        System.out.println(CountCommand.countRowsWithGivenValue(table1,"Text data","Pesho"));



        Scanner scanner = new Scanner(System.in);

        try {
            InsertCommand.addRow(table,scanner);
        } catch (InvalidException e) {
            throw new RuntimeException(e);
        }
        TablePrinter.printTable(table);


        DescribeCommand.getColumnInfo(table);

    }
}
