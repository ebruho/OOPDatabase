package bg.tu_varna.sit.a4.f22621685.project.commands.menuComands;

import bg.tu_varna.sit.a4.f22621685.project.database.DatabaseManager;
import bg.tu_varna.sit.a4.f22621685.project.commands.functions.AddColumnFunctions;
import bg.tu_varna.sit.a4.f22621685.project.contracts.Command;
import bg.tu_varna.sit.a4.f22621685.project.errors.InvalidException;

/**
 * The AddColumnMenuCommand class is responsible for handling the addition of a column to a table in the database.
 */
public class AddColumnMenuCommand implements Command {
    private final AddColumnFunctions addColumnFunctions;

    /**
     * Constructs an AddColumnMenuCommand with the specified AddColumnFunctions.
     *
     * @param addColumnFunctions the AddColumnFunctions instance to be used for adding a column
     */
    public AddColumnMenuCommand(AddColumnFunctions addColumnFunctions) {
        this.addColumnFunctions = addColumnFunctions;
    }

    /**
     * Executes the command to add a column to a table in the database.
     *
     * @param data            the command data containing the table name, column name, and column type
     * @param databaseManager the DatabaseManager instance managing the database
     * @throws InvalidException if the command data is invalid or the addition of the column fails
     */
    @Override
    public void execute(String[] data, DatabaseManager databaseManager) throws InvalidException {
        addColumnFunctions.addColumn(databaseManager, data[1], data[2], data[3]);
    }
}
