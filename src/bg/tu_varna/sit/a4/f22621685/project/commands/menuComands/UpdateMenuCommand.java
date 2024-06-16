package bg.tu_varna.sit.a4.f22621685.project.commands.menuComands;

import bg.tu_varna.sit.a4.f22621685.project.Database.DatabaseManager;
import bg.tu_varna.sit.a4.f22621685.project.commands.functions.UpdateFunction;
import bg.tu_varna.sit.a4.f22621685.project.contracts.Command;
import bg.tu_varna.sit.a4.f22621685.project.errors.InvalidException;

public class UpdateMenuCommand implements Command {
    private final UpdateFunction updateFunction;

    public UpdateMenuCommand(UpdateFunction updateFunction) {
        this.updateFunction = updateFunction;
    }

    @Override
    public void execute(String[] data, DatabaseManager databaseManager) throws InvalidException {
        String tableName = data[1];
//        Table table = databaseManager.getTable(tableName);
        updateFunction.updateRows(databaseManager.getTable(tableName),data[2],data[3],data[4],data[5]);
    }
}
