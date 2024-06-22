package bg.tu_varna.sit.a4.f22621685.project.commands.menuComands;

import bg.tu_varna.sit.a4.f22621685.project.database.DatabaseManager;
import bg.tu_varna.sit.a4.f22621685.project.commands.functions.ExportFunctions;
import bg.tu_varna.sit.a4.f22621685.project.contracts.Command;
import bg.tu_varna.sit.a4.f22621685.project.errors.InvalidException;

/**
 * SaveCommand class implements the Command interface to save a table to the current file path.
 */
public class SaveCommand implements Command {
    private final ExportFunctions exportFunctions;

    /**
     * Constructor to initialize with ExportFunctions instance.
     *
     * @param exportFunctions the export functions instance
     */
    public SaveCommand(ExportFunctions exportFunctions) {
        this.exportFunctions = exportFunctions;
    }

    /**
     * Executes the save command.
     *
     * @param data            command arguments (expects table name)
     * @param databaseManager the database manager instance
     * @throws InvalidException if an error occurs during execution
     */
    @Override
    public void execute(String[] data, DatabaseManager databaseManager) throws InvalidException {
        if (databaseManager.getFilePath() == null) {
            throw new InvalidException("No file path is currently set.");
        }
        exportFunctions.export(data[1], databaseManager.getFilePath());
        System.out.println("Table '" + data[1] + "' saved to file '" + databaseManager.getFilePath() + "' successfully.");
    }
}
