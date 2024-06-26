package bg.tu_varna.sit.a4.f22621685.project.menu;

import bg.tu_varna.sit.a4.f22621685.project.database.DatabaseManager;
import bg.tu_varna.sit.a4.f22621685.project.commands.functions.*;
import bg.tu_varna.sit.a4.f22621685.project.commands.menuComands.*;
import bg.tu_varna.sit.a4.f22621685.project.contracts.Command;
import bg.tu_varna.sit.a4.f22621685.project.errors.InvalidException;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * MenuInvoker handles user commands and executes corresponding actions.
 */
public class MenuInvoker {
    private DatabaseManager databaseManager;
    private Map<String, Command> commandMap;

    /**
     * Constructor initializes the MenuInvoker with a new DatabaseManager and an empty command map.
     */
    public MenuInvoker() {
        this.databaseManager = new DatabaseManager();
        this.commandMap = new HashMap<>();
    }

    /**
     * Fills the command map with commands and their corresponding implementations.
     */
    private void fillMap() {
        commandMap.put("import", new ImportMenuCommand(new ImportFunction(databaseManager)));
        commandMap.put("rename", new RenameMenuCommand(new RenameFunction()));
        commandMap.put("aggregate", new AggregateMenuCommand(new AggregateFunctions()));
        commandMap.put("count", new CountMenuCommand(new CountFunction()));
        commandMap.put("delete", new DeleteMenuCommand(new DeleteFunction()));
        commandMap.put("insert", new InsertMenuCommand(new InsertFunction()));
        commandMap.put("describe", new DescribeMenuCommand(new DescribeFunction()));
        commandMap.put("print", new TablePrinterMenuCommand(new TablePrinter()));
        commandMap.put("showtables", new ShowTablesMenuCommand(new ShowTablesFunction()));
        commandMap.put("select", new SelectMenuCommand(new SelectFunction()));
        commandMap.put("update", new UpdateMenuCommand(new UpdateFunction()));
        commandMap.put("innerjoin", new InnerJoinMenuCommand(new InnerJoinFunction(), new TablePrinter()));
        commandMap.put("export", new ExportMenuCommand(new ExportFunctions(databaseManager)));
        commandMap.put("addcolumn", new AddColumnMenuCommand(new AddColumnFunctions()));
        commandMap.put("saveas", new SaveAs(new ExportFunctions(databaseManager)));
        commandMap.put("save", new SaveCommand(new ExportFunctions(databaseManager)));
        commandMap.put("open", new OpenCommand(new ImportFunction(databaseManager)));
        commandMap.put("close", new CloseCommand());
        commandMap.put("help", new HelpCommand());
        commandMap.put("catalog", new CatalogCommand());
    }

    /**
     * Starts the menu execution.
     *
     * @throws InvalidException if an error occurs during command execution
     */
    public void run() throws InvalidException {
        fillMap();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter a new command:");
            String[] tokens = scanner.nextLine().split("\\s+");
            if (tokens[0].equals("exit")) {
                break;
            }
            if (commandMap.containsKey(tokens[0])) {
                commandMap.get(tokens[0]).execute(tokens, databaseManager);
            } else {
                System.out.println("Invalid command. Type 'help' to see available commands.");
            }
        }
        scanner.close();
        System.out.println("Exiting...");
    }
}
