package bg.tu_varna.sit.a4.f22621685.project.commands.menuComands;

import bg.tu_varna.sit.a4.f22621685.project.database.DatabaseManager;
import bg.tu_varna.sit.a4.f22621685.project.commands.functions.CountFunction;
import bg.tu_varna.sit.a4.f22621685.project.contracts.Command;
import bg.tu_varna.sit.a4.f22621685.project.errors.InvalidException;
import bg.tu_varna.sit.a4.f22621685.project.table.Table;

/**
 * The CountMenuCommand class is responsible for handling the count command to count the rows
 * in a table that have a specific value in a given column.
 */
public class CountMenuCommand implements Command {
    private final CountFunction countFunction;

    /**
     * Constructs a new CountMenuCommand with the specified CountFunction.
     *
     * @param countFunction the CountFunction to use for counting rows
     */
    public CountMenuCommand(CountFunction countFunction) {
        this.countFunction = countFunction;
    }

    /**
     * Executes the command to count the rows in the specified table that have a specific value
     * in the given column.
     *
     * @param data            the command data where data[1] is the table name, data[2] is the column name, and data[3] is the value to search for
     * @param databaseManager the DatabaseManager instance managing the database
     * @throws InvalidException if an error occurs while executing the command
     */
    @Override
    public void execute(String[] data, DatabaseManager databaseManager) throws InvalidException {
        String tableName = data[1];
        Table table = databaseManager.getTable(tableName);
        System.out.println(countFunction.countRowsWithGivenValue(table, data[2], data[3]));
    }
}
