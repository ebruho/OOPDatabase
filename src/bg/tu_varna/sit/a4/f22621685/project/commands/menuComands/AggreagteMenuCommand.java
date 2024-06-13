package bg.tu_varna.sit.a4.f22621685.project.commands.menuComands;

import bg.tu_varna.sit.a4.f22621685.project.Database.DatabaseManager;
import bg.tu_varna.sit.a4.f22621685.project.commands.AggregateCommand;
import bg.tu_varna.sit.a4.f22621685.project.contracts.Command;
import bg.tu_varna.sit.a4.f22621685.project.errors.InvalidException;
import bg.tu_varna.sit.a4.f22621685.project.table.Table;

public class AggreagteMenuCommand implements Command {
    private  final AggregateCommand aggregateCommand;

    public AggreagteMenuCommand(AggregateCommand aggregateCommand) {
        this.aggregateCommand = aggregateCommand;
    }

    @Override
    public void execute(String[] data, DatabaseManager databaseManager) throws InvalidException {
        String tableName = data[1];
        Table table = databaseManager.getTable(tableName);
        aggregateCommand.aggregate(table,data[2],data[3],data[4],data[5]);

    }
}
