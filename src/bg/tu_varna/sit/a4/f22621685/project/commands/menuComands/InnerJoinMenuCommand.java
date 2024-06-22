package bg.tu_varna.sit.a4.f22621685.project.commands.menuComands;

import bg.tu_varna.sit.a4.f22621685.project.database.DatabaseManager;
import bg.tu_varna.sit.a4.f22621685.project.commands.functions.InnerJoinFunction;
import bg.tu_varna.sit.a4.f22621685.project.commands.functions.TablePrinter;
import bg.tu_varna.sit.a4.f22621685.project.contracts.Command;
import bg.tu_varna.sit.a4.f22621685.project.errors.InvalidException;
import bg.tu_varna.sit.a4.f22621685.project.table.Table;

/**
 * InnerJoinMenuCommand class implements the Command interface to execute the inner join operation between two tables.
 */
public class InnerJoinMenuCommand implements Command {
    private final InnerJoinFunction innerJoinFunction;
    private final TablePrinter tablePrinter;

    /**
     * Constructor to initialize with InnerJoinFunction and TablePrinter instances.
     *
     * @param innerJoinFunction the inner join function instance
     * @param tablePrinter      the table printer instance
     */
    public InnerJoinMenuCommand(InnerJoinFunction innerJoinFunction, TablePrinter tablePrinter) {
        this.innerJoinFunction = innerJoinFunction;
        this.tablePrinter = tablePrinter;
    }

    /**
     * Executes the inner join command.
     *
     * @param data            command arguments (expects table names and join column names)
     * @param databaseManager the database manager instance
     * @throws InvalidException if an error occurs during execution
     */
    @Override
    public void execute(String[] data, DatabaseManager databaseManager) throws InvalidException {
        // Retrieve the first table and its name
        String tableName1 = data[1];
        Table table1 = databaseManager.getTable(tableName1);

        // Retrieve the second table and its name
        String tableName2 = data[3];
        Table table2 = databaseManager.getTable(tableName2);

        // Define the new name for the joined table
        String newNameTable = tableName1 + "to" + tableName2;

        // Perform the inner join operation
        Table joinedTable = innerJoinFunction.innerJoin(table1, data[2], table2, data[4], newNameTable, databaseManager);

        // Print the joined table
        tablePrinter.printTable(joinedTable);
    }
}
