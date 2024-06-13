package bg.tu_varna.sit.a4.f22621685.project.commands.menuComands;

import bg.tu_varna.sit.a4.f22621685.project.Database.DatabaseManager;
import bg.tu_varna.sit.a4.f22621685.project.commands.RenameCommand;
import bg.tu_varna.sit.a4.f22621685.project.contracts.Command;
import bg.tu_varna.sit.a4.f22621685.project.errors.InvalidException;
import bg.tu_varna.sit.a4.f22621685.project.table.Table;

public class RenameMenuCommand implements Command {
    private final RenameCommand renameCommand;

    public RenameMenuCommand(RenameCommand renameCommand) {
        this.renameCommand = renameCommand;
    }

    @Override
    public void execute(String[] data, DatabaseManager databaseManager) throws InvalidException {
        renameCommand.renameTable(databaseManager, data[1], data[2]);
    }
}
