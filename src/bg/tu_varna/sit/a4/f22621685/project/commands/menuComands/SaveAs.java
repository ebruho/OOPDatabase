package bg.tu_varna.sit.a4.f22621685.project.commands.menuComands;

import bg.tu_varna.sit.a4.f22621685.project.database.DatabaseManager;
import bg.tu_varna.sit.a4.f22621685.project.commands.functions.ExportFunctions;
import bg.tu_varna.sit.a4.f22621685.project.contracts.Command;
import bg.tu_varna.sit.a4.f22621685.project.errors.InvalidException;

/**
 * SaveAs class implements the Command interface to save a table as a file.
 */
public class SaveAs implements Command {
    private final ExportFunctions exportFunctions;

    /**
     * Constructor to initialize with ExportFunctions instance.
     *
     * @param exportFunctions the export functions instance
     */
    public SaveAs(ExportFunctions exportFunctions) {
        this.exportFunctions = exportFunctions;
    }

    /**
     * Executes the save as command.
     *
     * @param data            command arguments (expects table name and file name)
     * @param databaseManager the database manager instance
     * @throws InvalidException if an error occurs during execution
     */
    @Override
    public void execute(String[] data, DatabaseManager databaseManager) throws InvalidException {
        exportFunctions.export(data[1], data[2]);
        System.out.println("Table '" + data[1] + "' exported to file '" + data[2] + "' successfully.");
    }
}
