package bg.tu_varna.sit.a4.f22621685.project.table;

import bg.tu_varna.sit.a4.f22621685.project.Database.DatabaseManager;
import bg.tu_varna.sit.a4.f22621685.project.errors.InvalidException;

import javax.imageio.IIOException;
import java.util.ArrayList;
import java.util.List;

public class Table {
    private String tableName;
    private List<Column> columns;
    private DatabaseManager databaseManager; //relation to other tables


    public Table(String tableName,DatabaseManager databaseManager) {
        this.tableName=tableName;
        columns = new ArrayList<>();
        this.databaseManager=databaseManager;
    }

    public void addColumn(Column column) {
        columns.add(column);
    }

    public void removeColumn(Column column) {
        columns.remove(column);
    }

    public List<Column> getColumns() {
        return columns;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
        //System.out.println("Table name was changed successfully to \"" + tableName + "\".");
    }

    public void addRow(Object[] array) {
        // Добавяне на нов ред към таблицата

            if (array.length != columns.size()) {
                throw new IllegalArgumentException("Row data length does not match number of columns.");
            }
            for (int i = 0; i < columns.size(); i++) {
                columns.get(i).addCell(new Cell(array[i]));
            }

    }
}