package bg.tu_varna.sit.a4.f22621685.project.commands;

import bg.tu_varna.sit.a4.f22621685.project.Database.DatabaseManager;

public class ShowTablesCommand {
    public static void showTables(DatabaseManager databaseManager) {
        if (databaseManager == null) {
            System.out.println("Error: Database manager is not initialized.");
            return;
        }

        int num = 0;
        var tableNames = databaseManager.getTableNames();
        if (tableNames.isEmpty()) {
            System.out.println("No tables found.");
        } else {
            System.out.println("Tables:");
            for (String tableName : tableNames) {

                System.out.println(++num + ". " + tableName);

            }
        }
    }
}
