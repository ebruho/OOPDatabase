package bg.tu_varna.sit.a4.f22621685.project.commands.menuComands;

import bg.tu_varna.sit.a4.f22621685.project.Database.DatabaseManager;
import bg.tu_varna.sit.a4.f22621685.project.commands.InnerJoinCommand;
import bg.tu_varna.sit.a4.f22621685.project.commands.TablePrinter;
import bg.tu_varna.sit.a4.f22621685.project.contracts.Command;
import bg.tu_varna.sit.a4.f22621685.project.errors.InvalidException;
import bg.tu_varna.sit.a4.f22621685.project.table.Table;

public class InnerJoinMenuCommand implements Command {
    private final InnerJoinCommand innerJoinCommand;
    private final TablePrinter tablePrinter;

    public InnerJoinMenuCommand(InnerJoinCommand innerJoinCommand, TablePrinter tablePrinter) {
        this.innerJoinCommand = innerJoinCommand;
        this.tablePrinter = tablePrinter;
    }

    @Override
    public void execute(String[] data, DatabaseManager databaseManager) throws InvalidException {
        String tableName = data[1];
        Table table = databaseManager.getTable(tableName);
        String tableName2 = data[3];
        Table table2 = databaseManager.getTable(tableName2);
        Table table1 = innerJoinCommand.innerJoin(table, data[2], table2, data[4], data[5], databaseManager);
        tablePrinter.printTable(table1);
    }
}