
import bg.tu_varna.sit.a4.f22621685.project.Database.DatabaseManager;
import bg.tu_varna.sit.a4.f22621685.project.commands.*;
import bg.tu_varna.sit.a4.f22621685.project.errors.InvalidException;
import bg.tu_varna.sit.a4.f22621685.project.table.Cell;
import bg.tu_varna.sit.a4.f22621685.project.table.Column;
import bg.tu_varna.sit.a4.f22621685.project.table.Table;

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
        //nullColumn.addCell(new Cell("Pesho"));

        Table table1 = new Table("Text data",databaseManager);
        table1.addColumn(stringColumn);
        table1.addColumn(nullColumn);

        TablePrinter.printTable(table);
        TablePrinter.printTable(table1);

        System.out.println(CountCommand.countRowsWithGivenValue(table1,"Text data","Pesho"));



        Scanner scanner = new Scanner(System.in);
/*
        try {
            InsertCommand.addRow(table,scanner);
            //InsertCommand.addRow(table1,scanner);
        } catch (InvalidException e) {
            throw new RuntimeException(e);
        }
*/

        DeleteCommand.deleteRows(table,"Text data","Pesho");

        //SelectCommand.selectRows("Text data", "Pesho", table, 1, 2);

        TablePrinter.printTable(table);

        TablePrinter.printTable(table1);


        DescribeCommand.getColumnInfo(table1);
        //System.out.println(table1.getColumns().get(1));

        Table table2 = new Table("Sample Table",databaseManager);
        table2.addColumn(new Column("ID"));
        table2.addColumn(new Column("Name"));
        table2.addColumn(new Column("Age"));

        // Добавяне на данни в таблицата
        table2.getColumns().get(0).addCell(new Cell(1));
        table2.getColumns().get(1).addCell(new Cell("Alice"));
        table2.getColumns().get(2).addCell(new Cell(25));

        table2.getColumns().get(0).addCell(new Cell(2));
        table2.getColumns().get(1).addCell(new Cell("Bob"));
        table2.getColumns().get(2).addCell(new Cell(30));

        table2.getColumns().get(0).addCell(new Cell(3));
        table2.getColumns().get(1).addCell(new Cell("Charlie"));
        table2.getColumns().get(2).addCell(new Cell(35));

        // Отпечатване на таблицата преди актуализация
        System.out.println("Table before update:");
        TablePrinter.printTable(table2);

        // Актуализация на стойностите в таблицата
        UpdateCommand.updateRows(table2, "ID", 2, "Age", 40);

        // Отпечатване на таблицата след актуализация
        System.out.println("Table after update:");
        TablePrinter.printTable(table2);

        DescribeCommand.getColumnInfo(table2);
        System.out.println(CountCommand.countRowsWithGivenValue(table2,"Name","Bob"));

        //DeleteCommand.deleteRows(table2,"ID",3);
        TablePrinter.printTable(table2);

        //table2.addColumn(new Column("address"));

        TablePrinter.printTable(table2);

        Table table3 = new Table("Employees",databaseManager);
        table3.addColumn(new Column("ID"));
        table3.addColumn(new Column("Name"));
        table3.addColumn(new Column("Age"));

        // Добавяне на редове към таблицата
        Object[] row1 = {1, "John", 30};
        Object[] row2 = {2, "Alice", 25};
        Object[] row3 = {3, "Bob", 35};

        table3.addRow(row1);
        table3.addRow(row2);
        table3.addRow(row3);

        TablePrinter.printTable(table3);

        String resultTable = "Inner join";
        Table table4 = InnerJoinCommand.innerJoin(table2,"ID",table3,"ID",resultTable,databaseManager);
        TablePrinter.printTable(table4);


        System.out.println(CountCommand.countRowsWithGivenValue(table4,"Age",35));

        DescribeCommand.getColumnInfo(table1);
        DescribeCommand.getColumnInfo(table4);

        SelectCommand.selectRows("Age",35,table4);


        UpdateCommand.updateRows(table4,"ID",1,"Age",28);
        TablePrinter.printTable(table4);
    }

}
