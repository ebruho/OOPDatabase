package bg.tu_varna.sit.a4.f22621685.project.commands.menuComands;

import bg.tu_varna.sit.a4.f22621685.project.database.DatabaseManager;
import bg.tu_varna.sit.a4.f22621685.project.commands.functions.TablePrinter;
import bg.tu_varna.sit.a4.f22621685.project.contracts.Command;
import bg.tu_varna.sit.a4.f22621685.project.errors.InvalidException;
import bg.tu_varna.sit.a4.f22621685.project.table.Table;

/**
 * TablePrinterMenuCommand class implements the Command interface to print a table.
 */
public class TablePrinterMenuCommand implements Command {
    private final TablePrinter tablePrinter;

    /**
     * Constructor to initialize with TablePrinter instance.
     *
     * @param tablePrinter the table printer instance
     */
    public TablePrinterMenuCommand(TablePrinter tablePrinter) {
        this.tablePrinter = tablePrinter;
    }

    /**
     * Executes the print table command.
     *
     * @param data            command arguments (expected format: {"print", "<table_name>"})
     * @param databaseManager the database manager instance
     * @throws InvalidException if an error occurs during execution
     */
    @Override
    public void execute(String[] data, DatabaseManager databaseManager) throws InvalidException {
        if (data.length < 2) {
            throw new InvalidException("Invalid command format. Usage: print <table_name>");
        }

        String tableName = data[1];
        Table table = databaseManager.getTable(tableName);
        tablePrinter.printTable(table);
    }
}
