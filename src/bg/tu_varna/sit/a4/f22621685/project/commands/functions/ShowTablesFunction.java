package bg.tu_varna.sit.a4.f22621685.project.commands.functions;

import bg.tu_varna.sit.a4.f22621685.project.Database.DatabaseManager;
import bg.tu_varna.sit.a4.f22621685.project.errors.InvalidException;

public class ShowTablesFunction {
    public void showTables(DatabaseManager databaseManager) throws InvalidException {
        if (databaseManager == null) {
            throw new InvalidException("Error: Database manager is not initialized.");

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
