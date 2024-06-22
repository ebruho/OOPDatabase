package bg.tu_varna.sit.a4.f22621685.project.commands.functions;

import bg.tu_varna.sit.a4.f22621685.project.database.DatabaseManager;
import bg.tu_varna.sit.a4.f22621685.project.errors.InvalidException;

import java.util.List;

/**
 * The ShowTablesFunction class provides functionality to display the names of all tables managed by the DatabaseManager.
 */
public class ShowTablesFunction {

    /**
     * Displays the names of all tables managed by the DatabaseManager.
     *
     * @param databaseManager the DatabaseManager instance
     * @throws InvalidException if the database manager is not initialized (null)
     */
    public void showTables(DatabaseManager databaseManager) throws InvalidException {
        if (databaseManager == null) {
            throw new InvalidException("Error: Database manager is not initialized.");
        }

        int num = 0;
        List<String> tableNames = databaseManager.getTableNames();
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
