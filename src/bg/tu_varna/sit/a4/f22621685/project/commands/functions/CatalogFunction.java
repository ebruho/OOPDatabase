package bg.tu_varna.sit.a4.f22621685.project.commands.functions;

import bg.tu_varna.sit.a4.f22621685.project.table.Table;

import java.util.HashMap;
import java.util.Map;

public class CatalogFunction {
    private Map<String, Table> catalog;

    public CatalogFunction() {
        this.catalog = new HashMap<>();
    }
    public void addTable(String filePath,Table table){
        catalog.put(filePath,table);
    }

    public void print() {
        for (Map.Entry<String, Table> stringTableEntry : catalog.entrySet()) {
            System.out.printf("File Path: %s - Table Name: %s%n"
                    ,stringTableEntry.getKey(),stringTableEntry.getValue().getTableName());
        }
    }
}
