package bg.tu_varna.sit.a4.f22621685.project.commands.menuComands;

import bg.tu_varna.sit.a4.f22621685.project.database.DatabaseManager;
import bg.tu_varna.sit.a4.f22621685.project.contracts.Command;
import bg.tu_varna.sit.a4.f22621685.project.errors.InvalidException;

/**
 * The HelpCommand class implements the Command interface to display help information
 * about the supported commands in the database management system.
 */
public class HelpCommand implements Command {

    /**
     * Executes the command to display help information about the supported commands.
     *
     * @param data            array of command arguments (not used in this command)
     * @param databaseManager the DatabaseManager instance managing the database
     * @throws InvalidException if an error occurs while executing the command
     */
    @Override
    public void execute(String[] data, DatabaseManager databaseManager) throws InvalidException {
        System.out.println("> help\n" +
                "The following commands are supported:\n" +
                "open <file>        Opens a database file\n" +
                "close              Closes the currently opened file\n" +
                "save               Saves the currently open file\n" +
                "saveas <file>      Saves the currently open file in a new file\n" +
                "help               Prints information about available commands\n" +
                "exit               Exits the program\n\n" +
                "Additional commands:\n" +
                "import <file>      Adds a table to the database from a file\n" +
                "showtables         Shows a list of all loaded table names\n" +
                "describe <name>    Shows column types of a specified table\n" +
                "print <name>       Prints the contents of a table\n" +
                "export <name> <file name> Saves a table into a file\n" +
                "select <column-n> <value> Prints rows from a table based on search criteria\n" +
                "addcolumn <table name> <column name> <column type> Adds a new column with null values\n" +
                "update <table name> <search column n> <search value> <target column n> <target value> Updates rows in a table\n" +
                "delete <table name> <search column n> <search value> Deletes rows from a table based on search criteria\n" +
                "insert <table name> <column 1> … <column n> Inserts a new row with specified values\n" +
                "innerjoin <table 1> <column n1> <table 2> <column n2> Performs an inner join operation between two tables\n" +
                "rename <old name> <new name> Renames a table\n" +
                "count <table name> <search column n> <search value> Counts occurrences of a value in a table column\n" +
                "aggregate <table name> <search column n> <search value> <target column n> <operation> Performs aggregation operations on a table\n");
    }
}
