package bg.tu_varna.sit.a4.f22621685.project.commands.functions;

import bg.tu_varna.sit.a4.f22621685.project.Database.DatabaseManager;
import bg.tu_varna.sit.a4.f22621685.project.errors.InvalidException;
import bg.tu_varna.sit.a4.f22621685.project.table.Column;
import bg.tu_varna.sit.a4.f22621685.project.table.Table;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ImportFunction {
    private DatabaseManager databaseManager;

    public ImportFunction(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
    }
    public void importFile(String filePath){
        File file = new File(filePath);
        if(!file.exists()){
            throw  new RuntimeException("The file is not current");
        }
        try(FileReader fileReader = new FileReader(file)){
            Scanner scanner = new Scanner(fileReader);
            if(!scanner.hasNext()){
                return;
            }
            String tableName = scanner.nextLine();
            Table table = new Table(tableName,databaseManager);
            String[] columnNames = scanner.nextLine().split("==");
            for (String columnName : columnNames) {
                table.addColumn(new Column(columnName));
            }
            while (scanner.hasNext()){
                String[] columnValues = scanner.nextLine().split("==");
                table.addRow(columnValues);
            }
            databaseManager.addTable(table);
            databaseManager.getCatalogFunction().addTable(filePath,table);//for catalog
            System.out.println("Successfully opened "+filePath);
        } catch (InvalidException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
