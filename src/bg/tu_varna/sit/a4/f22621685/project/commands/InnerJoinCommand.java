package bg.tu_varna.sit.a4.f22621685.project.commands;

import bg.tu_varna.sit.a4.f22621685.project.Database.DatabaseManager;
import bg.tu_varna.sit.a4.f22621685.project.table.Cell;
import bg.tu_varna.sit.a4.f22621685.project.table.Column;
import bg.tu_varna.sit.a4.f22621685.project.table.Table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class InnerJoinCommand {
    public Table innerJoin(Table table1, String column1Name, Table table2, String column2Name, String resultTableName, DatabaseManager databaseManager) {
        Table resultTable = new Table(resultTableName, databaseManager);

        // Добавяме колоните от първата таблица
        for (Column column : table1.getColumns()) {
            resultTable.addColumn(new Column(column.getColumnName()));
        }

        // Добавяме колоните от втората таблица (без колоната за сравнение)
        for (Column column : table2.getColumns()) {
            if (!column.getColumnName().equals(column2Name)) {
                resultTable.addColumn(new Column(column.getColumnName()));
            }
        }

        // Създаване на мап за бърз достъп до редовете от table2 на базата на стойностите в column2
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

        // Извършваме операцията Inner Join
        Column table1JoinColumn = table1.getColumns().stream().filter(col -> col.getColumnName().equals(column1Name)).findFirst().orElse(null);
        if (table1JoinColumn != null) {
            for (int i = 0; i < table1JoinColumn.getCells().size(); i++) {
                Cell cell1 = table1JoinColumn.getCells().get(i);
                if (cell1 != null && cell1.getData() != null && table2IndexMap.containsKey(cell1.getData())) {
                    for (int rowIndex : table2IndexMap.get(cell1.getData())) {
                        List<Object> rowData = new ArrayList<>();
                        for (Column column : table1.getColumns()) {
                            rowData.add(column.getCells().get(i).getData());
                        }
                        for (Column column : table2.getColumns()) {
                            if (!column.getColumnName().equals(column2Name)) {
                                rowData.add(column.getCells().get(rowIndex).getData());
                            }
                        }
                        resultTable.addRow(rowData.toArray());
                    }
                }
            }
        }
        return resultTable;
    }
}
