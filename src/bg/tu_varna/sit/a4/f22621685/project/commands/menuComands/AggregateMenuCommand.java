package bg.tu_varna.sit.a4.f22621685.project.commands.menuComands;

import bg.tu_varna.sit.a4.f22621685.project.database.DatabaseManager;
import bg.tu_varna.sit.a4.f22621685.project.commands.functions.AggregateFunctions;
import bg.tu_varna.sit.a4.f22621685.project.contracts.Command;
import bg.tu_varna.sit.a4.f22621685.project.errors.InvalidException;
import bg.tu_varna.sit.a4.f22621685.project.table.Table;

/**
 * The AggregateMenuCommand class is responsible for handling aggregate functions on a table in the database.
 */
public class AggregateMenuCommand implements Command {
    private final AggregateFunctions aggregateFunctions;

    /**
     * Constructs an AggregateMenuCommand with the specified AggregateFunctions.
     *
     * @param aggregateFunctions the AggregateFunctions instance to be used for performing aggregate operations
     */
    public AggregateMenuCommand(AggregateFunctions aggregateFunctions) {
        this.aggregateFunctions = aggregateFunctions;
    }

    /**
     * Executes the command to perform an aggregate function on a table in the database.
     *
     * @param data            the command data containing the table name, and aggregate function parameters
     * @param databaseManager the DatabaseManager instance managing the database
     * @throws InvalidException if the command data is invalid or the aggregate operation fails
     */
    @Override
    public void execute(String[] data, DatabaseManager databaseManager) throws InvalidException {
        String tableName = data[1];
        Table table = databaseManager.getTable(tableName);
        aggregateFunctions.aggregate(table, data[2], data[3], data[4], data[5]);
    }
}
