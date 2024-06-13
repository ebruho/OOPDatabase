package bg.tu_varna.sit.a4.f22621685.project.commands.menuComands;

import bg.tu_varna.sit.a4.f22621685.project.Database.DatabaseManager;
import bg.tu_varna.sit.a4.f22621685.project.commands.UpdateCommand;
import bg.tu_varna.sit.a4.f22621685.project.contracts.Command;
import bg.tu_varna.sit.a4.f22621685.project.errors.InvalidException;
import bg.tu_varna.sit.a4.f22621685.project.table.Table;

public class UpdateMenuCommand implements Command {
    private final UpdateCommand updateCommand;

    public UpdateMenuCommand(UpdateCommand updateCommand) {
        this.updateCommand = updateCommand;
    }

    @Override
    public void execute(String[] data, DatabaseManager databaseManager) throws InvalidException {
        String tableName = data[1];
//        Table table = databaseManager.getTable(tableName);
        updateCommand.updateRows(databaseManager.getTable(tableName),data[2],data[3],data[4],data[5]);
    }
}
