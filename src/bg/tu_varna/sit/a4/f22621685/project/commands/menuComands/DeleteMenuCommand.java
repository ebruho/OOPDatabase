package bg.tu_varna.sit.a4.f22621685.project.commands.menuComands;

import bg.tu_varna.sit.a4.f22621685.project.Database.DatabaseManager;
import bg.tu_varna.sit.a4.f22621685.project.commands.functions.DeleteFunction;
import bg.tu_varna.sit.a4.f22621685.project.contracts.Command;
import bg.tu_varna.sit.a4.f22621685.project.errors.InvalidException;
import bg.tu_varna.sit.a4.f22621685.project.table.Table;

public class DeleteMenuCommand implements Command {
    private final DeleteFunction deleteFunction;

    public DeleteMenuCommand(DeleteFunction deleteFunction) {
        this.deleteFunction = deleteFunction;
    }

    @Override
    public void execute(String[] data, DatabaseManager databaseManager) throws InvalidException {
        String tableName = data[1];
        Table table = databaseManager.getTable(tableName);
        deleteFunction.deleteRows(table, data[2], data[3]);
    }
}
