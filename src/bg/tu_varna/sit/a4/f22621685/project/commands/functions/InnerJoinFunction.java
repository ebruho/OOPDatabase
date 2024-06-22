package bg.tu_varna.sit.a4.f22621685.project.commands.functions;

import bg.tu_varna.sit.a4.f22621685.project.database.DatabaseManager;
import bg.tu_varna.sit.a4.f22621685.project.table.Cell;
import bg.tu_varna.sit.a4.f22621685.project.table.Column;
import bg.tu_varna.sit.a4.f22621685.project.table.Table;

import java.util.*;

/**
 * The InnerJoinFunction class provides functionality to perform an inner join operation between two tables.
 */
public class InnerJoinFunction {

    /**
     * Performs an inner join operation between two tables based on the specified columns.
     *
     * @param table1          the first table to join
     * @param column1Name     the name of the column in the first table to join on
     * @param table2          the second table to join
     * @param column2Name     the name of the column in the second table to join on
     * @param resultTableName the name of the resulting table after join
     * @param databaseManager the DatabaseManager instance used to manage tables
     * @return the resulting table after performing the inner join
     */
    public Table innerJoin(Table table1, String column1Name, Table table2, String column2Name, String resultTableName, DatabaseManager databaseManager) {
        Table resultTable = new Table(resultTableName, databaseManager);

        // Add columns from the first table to the result table
        for (Column column : table1.getColumns()) {
            resultTable.addColumn(new Column(column.getColumnName()));
        }

        // Add columns from the second table to the result table (excluding the join column)
        for (Column column : table2.getColumns()) {
            if (!column.getColumnName().equals(column2Name)) {
                resultTable.addColumn(new Column(column.getColumnName()));
            }
        }

        // Create a map for fast access to rows in table2 based on values in column2
        Map<Object, List<Integer>> table2IndexMap = new HashMap<>();
        Column table2JoinColumn = table2.getColumns().stream().filter(col -> col.getColumnName().equals(column2Name)).findFirst().orElse(null);
        if (table2JoinColumn != null) {
            for (int i = 0; i < table2JoinColumn.getCells().size(); i++) {
                Cell cell = table2JoinColumn.getCells().get(i);
                if (cell != null && cell.getData() != null) {
                    table2IndexMap.computeIfAbsent(cell.getData(), k -> new ArrayList<>()).add(i);
                }
            }
        }

        // Perform the Inner Join operation
        Column table1JoinColumn = table1.getColumns().stream().filter(col -> col.getColumnName().equals(column1Name)).findFirst().orElse(null);
        if (table1JoinColumn != null) {
            for (int i = 0; i < table1JoinColumn.getCells().size(); i++) {
                Cell cell1 = table1JoinColumn.getCells().get(i);
                if (cell1 != null && cell1.getData() != null && table2IndexMap.containsKey(cell1.getData())) {
                    for (int rowIndex : table2IndexMap.get(cell1.getData())) {
                        List<Object> rowData = new ArrayList<>();
                        // Add data from table1 to the result row
                        for (Column column : table1.getColumns()) {
                            rowData.add(column.getCells().get(i).getData());
                        }
                        // Add data from table2 to the result row (excluding the join column)
                        for (Column column : table2.getColumns()) {
                            if (!column.getColumnName().equals(column2Name)) {
                                rowData.add(column.getCells().get(rowIndex).getData());
                            }
                        }
                        // Add the constructed row to the result table
                        resultTable.addRow(rowData.toArray());
                    }
                }
            }
        }

        return resultTable;
    }
}
