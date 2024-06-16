package bg.tu_varna.sit.a4.f22621685.project.commands.menuComands;

import bg.tu_varna.sit.a4.f22621685.project.Database.DatabaseManager;
import bg.tu_varna.sit.a4.f22621685.project.commands.functions.RenameFunction;
import bg.tu_varna.sit.a4.f22621685.project.contracts.Command;
import bg.tu_varna.sit.a4.f22621685.project.errors.InvalidException;

public class RenameMenuCommand implements Command {
    private final RenameFunction renameFunction;

    public RenameMenuCommand(RenameFunction renameFunction) {
        this.renameFunction = renameFunction;
    }

    @Override
    public void execute(String[] data, DatabaseManager databaseManager) throws InvalidException {
        renameFunction.renameTable(databaseManager, data[1], data[2]);
    }
}
