package bg.tu_varna.sit.a4.f22621685.project.commands.menuComands;

import bg.tu_varna.sit.a4.f22621685.project.database.DatabaseManager;
import bg.tu_varna.sit.a4.f22621685.project.commands.functions.DescribeFunction;
import bg.tu_varna.sit.a4.f22621685.project.contracts.Command;
import bg.tu_varna.sit.a4.f22621685.project.errors.InvalidException;
import bg.tu_varna.sit.a4.f22621685.project.table.Table;

/**
 * The DescribeMenuCommand class is responsible for handling the describe command
 * to retrieve information about the columns of a table.
 */
public class DescribeMenuCommand implements Command {
    private final DescribeFunction describeFunction;

    /**
     * Constructs a new DescribeMenuCommand with the specified DescribeFunction.
     *
     * @param describeFunction the DescribeFunction to use for retrieving column information
     */
    public DescribeMenuCommand(DescribeFunction describeFunction) {
        this.describeFunction = describeFunction;
    }

    /**
     * Executes the command to retrieve and display information about the columns of the specified table.
     *
     * @param data            the command data where data[1] is the table name
     * @param databaseManager the DatabaseManager instance managing the database
     * @throws InvalidException if an error occurs while executing the command
     */
    @Override
    public void execute(String[] data, DatabaseManager databaseManager) throws InvalidException {
        String tableName = data[1];
        Table table = databaseManager.getTable(tableName);
        describeFunction.getColumnInfo(table);
    }
}
