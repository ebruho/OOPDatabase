package bg.tu_varna.sit.a4.f22621685.project.contracts;

import bg.tu_varna.sit.a4.f22621685.project.database.DatabaseManager;
import bg.tu_varna.sit.a4.f22621685.project.errors.InvalidException;

/**
 * The Command interface provides a method for executing commands that interact with the DatabaseManager.
 */
public interface Command {

    /**
     * Executes a command with the given data and database manager.
     *
     * @param data the data required for the command
     * @param databaseManager the database manager to operate on
     * @throws InvalidException if the command execution fails
     */
    void execute(String[] data, DatabaseManager databaseManager) throws InvalidException;
}
