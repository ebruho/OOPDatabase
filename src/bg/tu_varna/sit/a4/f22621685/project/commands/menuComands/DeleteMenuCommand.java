package bg.tu_varna.sit.a4.f22621685.project.commands.menuComands;

import bg.tu_varna.sit.a4.f22621685.project.database.DatabaseManager;
import bg.tu_varna.sit.a4.f22621685.project.commands.functions.DeleteFunction;
import bg.tu_varna.sit.a4.f22621685.project.contracts.Command;
import bg.tu_varna.sit.a4.f22621685.project.errors.InvalidException;
import bg.tu_varna.sit.a4.f22621685.project.table.Table;

/**
 * The DeleteMenuCommand class is responsible for handling the delete command to remove rows
 * from a table based on a specific column value.
 */
public class DeleteMenuCommand implements Command {
    private final DeleteFunction deleteFunction;

    /**
     * Constructs a new DeleteMenuCommand with the specified DeleteFunction.
     *
     * @param deleteFunction the DeleteFunction to use for deleting rows
     */
    public DeleteMenuCommand(DeleteFunction deleteFunction) {
        this.deleteFunction = deleteFunction;
    }

    /**
     * Executes the command to delete rows in the specified table that have a specific value
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
        deleteFunction.deleteRows(table, data[2], data[3]);
    }
}
