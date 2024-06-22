package bg.tu_varna.sit.a4.f22621685.project.commands.functions;

import bg.tu_varna.sit.a4.f22621685.project.errors.InvalidException;
import bg.tu_varna.sit.a4.f22621685.project.table.Column;
import bg.tu_varna.sit.a4.f22621685.project.table.Table;

/**
 * The DescribeFunction class provides functionality to retrieve and print column information for a given table.
 */
public class DescribeFunction {

    /**
     * Retrieves and prints column information (column name and data type) for the specified table.
     *
     * @param table the table whose columns information is to be retrieved
     * @throws InvalidException if the provided table is null
     */
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
