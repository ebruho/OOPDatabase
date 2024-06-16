package bg.tu_varna.sit.a4.f22621685.project.commands.menuComands;

import bg.tu_varna.sit.a4.f22621685.project.Database.DatabaseManager;
import bg.tu_varna.sit.a4.f22621685.project.commands.functions.SelectFunction;
import bg.tu_varna.sit.a4.f22621685.project.contracts.Command;
import bg.tu_varna.sit.a4.f22621685.project.errors.InvalidException;
import bg.tu_varna.sit.a4.f22621685.project.table.Table;

public class SelectMenuCommand implements Command {
    private final SelectFunction selectFunction;

    public SelectMenuCommand(SelectFunction selectFunction) {
        this.selectFunction = selectFunction;
    }

    @Override
    public void execute(String[] data, DatabaseManager databaseManager) throws InvalidException {
        String tableName = data[3];
        Table table = databaseManager.getTable(tableName);
        selectFunction.selectRows(data[1], data[2], table);
    }
}
