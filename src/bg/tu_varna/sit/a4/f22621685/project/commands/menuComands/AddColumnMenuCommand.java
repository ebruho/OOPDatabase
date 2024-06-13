package bg.tu_varna.sit.a4.f22621685.project.commands.menuComands;

import bg.tu_varna.sit.a4.f22621685.project.Database.DatabaseManager;
import bg.tu_varna.sit.a4.f22621685.project.commands.AddColumnFunctions;
import bg.tu_varna.sit.a4.f22621685.project.contracts.Command;
import bg.tu_varna.sit.a4.f22621685.project.errors.InvalidException;

public class AddColumnMenuCommand implements Command {
    private final AddColumnFunctions addColumnFunctions;

    public AddColumnMenuCommand(AddColumnFunctions addColumnFunctions) {
        this.addColumnFunctions = addColumnFunctions;
    }

    @Override
    public void execute(String[] data, DatabaseManager databaseManager) throws InvalidException {
        addColumnFunctions.addColumn(databaseManager, data[1], data[2], data[3]);
    }
}
