package bg.tu_varna.sit.a4.f22621685.project.commands.menuComands;

import bg.tu_varna.sit.a4.f22621685.project.Database.DatabaseManager;
import bg.tu_varna.sit.a4.f22621685.project.contracts.Command;
import bg.tu_varna.sit.a4.f22621685.project.errors.InvalidException;

public class CloseCommand implements Command {
    @Override
    public void execute(String[] data, DatabaseManager databaseManager) throws InvalidException {
        databaseManager.setFilePath(null);
    }
}
