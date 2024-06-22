package bg.tu_varna.sit.a4.f22621685.project.commands.menuComands;

import bg.tu_varna.sit.a4.f22621685.project.database.DatabaseManager;
import bg.tu_varna.sit.a4.f22621685.project.commands.functions.UpdateFunction;
import bg.tu_varna.sit.a4.f22621685.project.contracts.Command;
import bg.tu_varna.sit.a4.f22621685.project.errors.InvalidException;
import bg.tu_varna.sit.a4.f22621685.project.table.Table;

/**
 * UpdateMenuCommand class implements the Command interface to update rows in a table.
 */
public class UpdateMenuCommand implements Command {
    private final UpdateFunction updateFunction;

    /**
     * Constructor to initialize with UpdateFunction instance.
     *
     * @param updateFunction the update function instance
     */
    public UpdateMenuCommand(UpdateFunction updateFunction) {
        this.updateFunction = updateFunction;
    }

    /**
     * Executes the update rows command.
     *
     * @param data            command arguments (expected format: {"update", "<table_name>", "<search_column>", "<search_value>", "<target_column>", "<target_value>"})
     * @param databaseManager the database manager instance
     * @throws InvalidException if an error occurs during execution
     */
    @Override
    public void execute(String[] data, DatabaseManager databaseManager) throws InvalidException {
        if (data.length < 6) {
            throw new InvalidException("Invalid command format. Usage: update <table_name> <search_column> <search_value> <target_column> <target_value>");
        }

        String tableName = data[1];
        Table table = databaseManager.getTable(tableName);

        updateFunction.updateRows(table, data[2], data[3], data[4], data[5]);
    }
}
