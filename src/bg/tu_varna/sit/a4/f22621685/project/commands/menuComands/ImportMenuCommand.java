package bg.tu_varna.sit.a4.f22621685.project.commands.menuComands;

import bg.tu_varna.sit.a4.f22621685.project.database.DatabaseManager;
import bg.tu_varna.sit.a4.f22621685.project.commands.functions.ImportFunction;
import bg.tu_varna.sit.a4.f22621685.project.contracts.Command;
import bg.tu_varna.sit.a4.f22621685.project.errors.InvalidException;

/**
 * ImportMenuCommand class implements the Command interface to execute the import file command.
 */
public class ImportMenuCommand implements Command {
    private final ImportFunction importFunction;

    /**
     * Constructor to initialize with an ImportFunction instance.
     *
     * @param importFunction the import function instance
     */
    public ImportMenuCommand(ImportFunction importFunction) {
        this.importFunction = importFunction;
    }

    /**
     * Executes the import file command.
     *
     * @param data            command arguments (expects file name at index 1)
     * @param databaseManager the database manager instance
     * @throws InvalidException if an error occurs during execution
     */
    @Override
    public void execute(String[] data, DatabaseManager databaseManager) throws InvalidException {
        importFunction.importFile(data[1]);
    }
}
