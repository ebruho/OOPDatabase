package bg.tu_varna.sit.a4.f22621685.project.commands.menuComands;

import bg.tu_varna.sit.a4.f22621685.project.database.DatabaseManager;
import bg.tu_varna.sit.a4.f22621685.project.commands.functions.ExportFunctions;
import bg.tu_varna.sit.a4.f22621685.project.contracts.Command;
import bg.tu_varna.sit.a4.f22621685.project.errors.InvalidException;

/**
 * The ExportMenuCommand class is responsible for handling the export command
 * to export table data to a specified file.
 */
public class ExportMenuCommand implements Command {
    private final ExportFunctions exportFunctions;

    /**
     * Constructs a new ExportMenuCommand with the specified ExportFunctions.
     *
     * @param exportFunctions the ExportFunctions to use for exporting table data
     */
    public ExportMenuCommand(ExportFunctions exportFunctions) {
        this.exportFunctions = exportFunctions;
    }

    /**
     * Executes the command to export table data to a specified file.
     *
     * @param data            the command data where data[1] is the table name and data[2] is the file path
     * @param databaseManager the DatabaseManager instance managing the database
     * @throws InvalidException if an error occurs while executing the command
     */
    @Override
    public void execute(String[] data, DatabaseManager databaseManager) throws InvalidException {
        exportFunctions.export(data[1], data[2]);
    }
}
