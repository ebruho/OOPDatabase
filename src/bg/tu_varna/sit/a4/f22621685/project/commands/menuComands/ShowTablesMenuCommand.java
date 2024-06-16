package bg.tu_varna.sit.a4.f22621685.project.commands.menuComands;

import bg.tu_varna.sit.a4.f22621685.project.Database.DatabaseManager;
import bg.tu_varna.sit.a4.f22621685.project.commands.functions.ShowTablesFunction;
import bg.tu_varna.sit.a4.f22621685.project.contracts.Command;
import bg.tu_varna.sit.a4.f22621685.project.errors.InvalidException;

public class ShowTablesMenuCommand implements Command {
    private final ShowTablesFunction showTablesFunction;

    public ShowTablesMenuCommand(ShowTablesFunction showTablesFunction) {
        this.showTablesFunction = showTablesFunction;
    }

    @Override
    public void execute(String[] data, DatabaseManager databaseManager) throws InvalidException {
        showTablesFunction.showTables(databaseManager);
    }
}
