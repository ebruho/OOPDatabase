package bg.tu_varna.sit.a4.f22621685.project.commands.menuComands;

import bg.tu_varna.sit.a4.f22621685.project.database.DatabaseManager;
import bg.tu_varna.sit.a4.f22621685.project.contracts.Command;
import bg.tu_varna.sit.a4.f22621685.project.errors.InvalidException;

/**
 * The CatalogCommand class is responsible for handling the catalog command to print the database catalog.
 */
public class CatalogCommand implements Command {

    /**
     * Executes the command to print the database catalog.
     *
     * @param data            the command data (not used in this command)
     * @param databaseManager the DatabaseManager instance managing the database
     * @throws InvalidException if an error occurs while executing the command
     */
    @Override
    public void execute(String[] data, DatabaseManager databaseManager) throws InvalidException {
        databaseManager.getCatalogFunction().print();
    }
}
