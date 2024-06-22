package bg.tu_varna.sit.a4.f22621685.project.commands.menuComands;

import bg.tu_varna.sit.a4.f22621685.project.database.DatabaseManager;
import bg.tu_varna.sit.a4.f22621685.project.commands.functions.RenameFunction;
import bg.tu_varna.sit.a4.f22621685.project.contracts.Command;
import bg.tu_varna.sit.a4.f22621685.project.errors.InvalidException;

/**
 * RenameMenuCommand class implements the Command interface to rename a table in the database.
 */
public class RenameMenuCommand implements Command {
    private final RenameFunction renameFunction;

    /**
     * Constructor to initialize with RenameFunction instance.
     *
     * @param renameFunction the rename function instance
     */
    public RenameMenuCommand(RenameFunction renameFunction) {
        this.renameFunction = renameFunction;
    }

    /**
     * Executes the rename command.
     *
     * @param data            command arguments (expects old name and new name)
     * @param databaseManager the database manager instance
     * @throws InvalidException if an error occurs during execution
     */
    @Override
    public void execute(String[] data, DatabaseManager databaseManager) throws InvalidException {
        renameFunction.renameTable(databaseManager, data[1], data[2]);
    }
}
