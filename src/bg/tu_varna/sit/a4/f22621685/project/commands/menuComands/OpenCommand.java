package bg.tu_varna.sit.a4.f22621685.project.commands.menuComands;

import bg.tu_varna.sit.a4.f22621685.project.database.DatabaseManager;
import bg.tu_varna.sit.a4.f22621685.project.commands.functions.ImportFunction;
import bg.tu_varna.sit.a4.f22621685.project.contracts.Command;
import bg.tu_varna.sit.a4.f22621685.project.errors.InvalidException;

/**
 * OpenCommand class implements the Command interface to open a database file and set it as the current file.
 */
public class OpenCommand implements Command {
    private final ImportFunction importFunction;

    /**
     * Constructor to initialize with ImportFunction instance.
     *
     * @param importFunction the import function instance
     */
    public OpenCommand(ImportFunction importFunction) {
        this.importFunction = importFunction;
    }

    /**
     * Executes the open command.
     *
     * @param data            command arguments (expects file path)
     * @param databaseManager the database manager instance
     * @throws InvalidException if an error occurs during execution
     */
    @Override
    public void execute(String[] data, DatabaseManager databaseManager) throws InvalidException {
        if (databaseManager.getFilePath() != null) {
            throw new InvalidException("There is already an opened file. Please close it before opening another.");
        }

        importFunction.importFile(data[1]);
        databaseManager.setFilePath(data[1]);

        System.out.println("File '" + data[1] + "' opened successfully.");
    }
}
