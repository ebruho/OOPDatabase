package bg.tu_varna.sit.a4.f22621685.project.commands.functions;

import bg.tu_varna.sit.a4.f22621685.project.Database.DatabaseManager;
import bg.tu_varna.sit.a4.f22621685.project.table.Column;
import bg.tu_varna.sit.a4.f22621685.project.table.Table;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ExportFunctions {
    private final DatabaseManager databaseManager;

    public ExportFunctions(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
    }

    public void export(String tableName, String filePath) {
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            Table table = databaseManager.getTable(tableName);
            if(table==null){
                System.out.println("There is no such table");
                return;
            }
            databaseManager.getCatalogFunction().addTable(filePath,table);
            fileWriter.write(table.getTableName());
            fileWriter.write(System.lineSeparator());
            List<Column> columns = table.getColumns();
            int size = columns.get(0).getCells().size();
            int i = 0;
            writeColumnNames(columns, fileWriter);
            writeValuesOnTheRow(size, columns, fileWriter, i);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeValuesOnTheRow(int size, List<Column> columns, FileWriter fileWriter, int i) throws IOException {
        while (size-- > 0) {
            for (int j = 0; j < columns.size(); j++) {
                if (j != columns.size() - 1) {
                    fileWriter.write(String.valueOf(columns.get(j).getCells().get(i).getData()));
                    fileWriter.write("==");
                } else {
                    fileWriter.write(String.valueOf(columns.get(j).getCells().get(i).getData()));
                }
            }
            fileWriter.write(System.lineSeparator());
            i++;
        }
    }

    private void writeColumnNames(List<Column> columns, FileWriter fileWriter) throws IOException {
        for (int j = 0; j < columns.size(); j++) {
            if (j != columns.size() - 1) {
                fileWriter.write(String.valueOf(columns.get(j).getColumnName()));
                fileWriter.write("==");
            } else {
                fileWriter.write(String.valueOf(columns.get(j).getColumnName()));
            }
        }
        fileWriter.write(System.lineSeparator());
    }
}

