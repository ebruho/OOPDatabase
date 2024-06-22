package bg.tu_varna.sit.a4.f22621685.project.commands.menuComands;

import bg.tu_varna.sit.a4.f22621685.project.database.DatabaseManager;
import bg.tu_varna.sit.a4.f22621685.project.contracts.Command;
import bg.tu_varna.sit.a4.f22621685.project.errors.InvalidException;

/**
 * The CloseCommand class is responsible for handling the close command to close the currently open database file.
 */
public class CloseCommand implements Command {

    /**
     * Executes the command to close the currently open database file by setting the file path to null.
     *
     * @param data            the command data (not used in this command)
     * @param databaseManager the DatabaseManager instance managing the database
     * @throws InvalidException if an error occurs while executing the command
     */
    @Override
    public void execute(String[] data, DatabaseManager databaseManager) throws InvalidException {
        databaseManager.setFilePath(null);
    }
}
