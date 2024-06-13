package bg.tu_varna.sit.a4.f22621685.project.commands.menuComands;

import bg.tu_varna.sit.a4.f22621685.project.Database.DatabaseManager;
import bg.tu_varna.sit.a4.f22621685.project.commands.SelectCommand;
import bg.tu_varna.sit.a4.f22621685.project.contracts.Command;
import bg.tu_varna.sit.a4.f22621685.project.errors.InvalidException;
import bg.tu_varna.sit.a4.f22621685.project.table.Table;

public class SelectMenuCommand implements Command {
    private final SelectCommand selectCommand;

    public SelectMenuCommand(SelectCommand selectCommand) {
        this.selectCommand = selectCommand;
    }

    @Override
    public void execute(String[] data, DatabaseManager databaseManager) throws InvalidException {
        String tableName = data[3];
        Table table = databaseManager.getTable(tableName);
        selectCommand.selectRows(data[1], data[2], table);
    }
}
