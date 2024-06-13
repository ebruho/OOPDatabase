package bg.tu_varna.sit.a4.f22621685.project.commands.menuComands;

import bg.tu_varna.sit.a4.f22621685.project.Database.DatabaseManager;
import bg.tu_varna.sit.a4.f22621685.project.commands.ShowTablesCommand;
import bg.tu_varna.sit.a4.f22621685.project.contracts.Command;
import bg.tu_varna.sit.a4.f22621685.project.errors.InvalidException;
import bg.tu_varna.sit.a4.f22621685.project.table.Table;

public class ShowTablesMenuCommand implements Command {
    private final ShowTablesCommand showTablesCommand;

    public ShowTablesMenuCommand(ShowTablesCommand showTablesCommand) {
        this.showTablesCommand = showTablesCommand;
    }

    @Override
    public void execute(String[] data, DatabaseManager databaseManager) throws InvalidException {
        showTablesCommand.showTables(databaseManager);
    }
}
