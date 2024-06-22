package bg.tu_varna.sit.a4.f22621685.project.commands.menuComands;

import bg.tu_varna.sit.a4.f22621685.project.database.DatabaseManager;
import bg.tu_varna.sit.a4.f22621685.project.commands.functions.ShowTablesFunction;
import bg.tu_varna.sit.a4.f22621685.project.contracts.Command;
import bg.tu_varna.sit.a4.f22621685.project.errors.InvalidException;

/**
 * ShowTablesMenuCommand class implements the Command interface to display all tables in the database.
 */
public class ShowTablesMenuCommand implements Command {
    private final ShowTablesFunction showTablesFunction;

    /**
     * Constructor to initialize with ShowTablesFunction instance.
     *
     * @param showTablesFunction the show tables function instance
     */
    public ShowTablesMenuCommand(ShowTablesFunction showTablesFunction) {
        this.showTablesFunction = showTablesFunction;
    }

    /**
     * Executes the show tables command.
     *
     * @param data            command arguments (not used in this command)
     * @param databaseManager the database manager instance
     * @throws InvalidException if an error occurs during execution
     */
    @Override
    public void execute(String[] data, DatabaseManager databaseManager) throws InvalidException {
        showTablesFunction.showTables(databaseManager);
    }
}
