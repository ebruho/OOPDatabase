package bg.tu_varna.sit.a4.f22621685.project.commands.menuComands;

import bg.tu_varna.sit.a4.f22621685.project.database.DatabaseManager;
import bg.tu_varna.sit.a4.f22621685.project.commands.functions.InsertFunction;
import bg.tu_varna.sit.a4.f22621685.project.contracts.Command;
import bg.tu_varna.sit.a4.f22621685.project.errors.InvalidException;
import bg.tu_varna.sit.a4.f22621685.project.table.Table;

/**
 * InsertMenuCommand class implements the Command interface to execute the insertion of a new row into a table.
 */
public class InsertMenuCommand implements Command {
    private  final InsertFunction insertFunction;

    /**
     * Constructor to initialize with InsertFunction instance.
     *
     * @param insertFunction the insert function instance
     */

    public InsertMenuCommand(InsertFunction insertFunction) {
        this.insertFunction = insertFunction;
    }

    /**
     * Executes the insert command.
     *
     * @param data            command arguments (expects table name and row data)
     * @param databaseManager the database manager instance
     * @throws InvalidException if an error occurs during execution
     */
    @Override
    public void execute(String[] data, DatabaseManager databaseManager) throws InvalidException {
        String tableName = data[1];
        Table table = databaseManager.getTable(tableName);
        insertFunction.addRow(table);
    }
}
