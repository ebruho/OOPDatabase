package bg.tu_varna.sit.a4.f22621685.project.commands.functions;

import bg.tu_varna.sit.a4.f22621685.project.Database.DatabaseManager;
import bg.tu_varna.sit.a4.f22621685.project.errors.InvalidException;

public class RenameFunction {
    public void renameTable(DatabaseManager databaseManager, String oldName, String newName) {
        try {
            databaseManager.renameTable(oldName, newName);
            System.out.println("Table renamed successfully from \"" + oldName + "\" to \"" + newName + "\".");
        } catch (InvalidException e) {
            System.out.println(e.getMessage());
        }
    }
}
