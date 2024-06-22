package bg.tu_varna.sit.a4.f22621685.project.commands.functions;

import bg.tu_varna.sit.a4.f22621685.project.database.DatabaseManager;
import bg.tu_varna.sit.a4.f22621685.project.errors.InvalidException;

/**
 * The RenameFunction class provides functionality to rename a table in the database.
 */
public class RenameFunction {

    /**
     * Renames a table in the database from the old name to the new name.
     *
     * @param databaseManager the database manager instance
     * @param oldName         the old name of the table
     * @param newName         the new name of the table
     */
    public void renameTable(DatabaseManager databaseManager, String oldName, String newName) {
        try {
            databaseManager.renameTable(oldName, newName);
            System.out.println("Table renamed successfully from \"" + oldName + "\" to \"" + newName + "\".");
        } catch (InvalidException e) {
            System.out.println(e.getMessage());
        }
    }
}
