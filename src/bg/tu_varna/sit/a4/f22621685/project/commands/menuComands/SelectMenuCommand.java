package bg.tu_varna.sit.a4.f22621685.project.commands.menuComands;

import bg.tu_varna.sit.a4.f22621685.project.database.DatabaseManager;
import bg.tu_varna.sit.a4.f22621685.project.commands.functions.SelectFunction;
import bg.tu_varna.sit.a4.f22621685.project.contracts.Command;
import bg.tu_varna.sit.a4.f22621685.project.errors.InvalidException;
import bg.tu_varna.sit.a4.f22621685.project.table.Table;
/**
 * SelectMenuCommand class implements the Command interface to select rows from a table.
 */
public class SelectMenuCommand implements Command {
    private final SelectFunction selectFunction;

    /**
     * Constructor to initialize with SelectFunction instance.
     *
     * @param selectFunction the select function instance
     */
    public SelectMenuCommand(SelectFunction selectFunction) {
        this.selectFunction = selectFunction;
    }

    /**
     * Executes the select command.
     *
     * @param data            command arguments (expects column name, value, and table name)
     * @param databaseManager the database manager instance
     * @throws InvalidException if an error occurs during execution
     */
    @Override
    public void execute(String[] data, DatabaseManager databaseManager) throws InvalidException {
        String tableName = data[3];
        Table table = databaseManager.getTable(tableName);
        selectFunction.selectRows(data[1], data[2], table);
    }
}
