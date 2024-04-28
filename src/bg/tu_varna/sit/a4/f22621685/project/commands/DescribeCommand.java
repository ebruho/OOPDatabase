package bg.tu_varna.sit.a4.f22621685.project.commands;

import bg.tu_varna.sit.a4.f22621685.project.table.Cell;
import bg.tu_varna.sit.a4.f22621685.project.table.Column;
import bg.tu_varna.sit.a4.f22621685.project.table.Table;

public class DescribeCommand {

    public static void getColumnInfo(Table table) {
        if (table == null) {
            System.out.println("Error: Invalid table.");
            return;
        }

        System.out.println("Description of table: " + table.getTableName());

        System.out.println("Column Name\t|\tData Type");
        System.out.println("---------------------------------");
        for (Column column : table.getColumns()) {
            System.out.println(column.getColumnName() + "\t|\t" + column.getColumnType().getSimpleName());
        }
    }
}
