package bg.tu_varna.sit.a4.f22621685.project.commands;

import bg.tu_varna.sit.a4.f22621685.project.errors.InvalidException;
import bg.tu_varna.sit.a4.f22621685.project.table.Cell;
import bg.tu_varna.sit.a4.f22621685.project.table.Column;
import bg.tu_varna.sit.a4.f22621685.project.table.Table;

public class DescribeCommand {

    public void getColumnInfo(Table table) throws InvalidException {
        if (table == null) {
            throw new InvalidException("Error: Invalid table.");
        }

        System.out.println("Description of table: " + table.getTableName());

        System.out.println("Column Name\t|\tData Type");
        System.out.println("---------------------------------");
        for (Column column : table.getColumns()) {
            Class<?> columnType = column.getColumnType();
            String dataType = (columnType != null) ? columnType.getSimpleName() : "Unknown";
            System.out.println(column.getColumnName() + "\t|\t" + dataType);
        }
    }
}
