package bg.tu_varna.sit.a4.f22621685.project.menu;

import bg.tu_varna.sit.a4.f22621685.project.Database.DatabaseManager;
import bg.tu_varna.sit.a4.f22621685.project.commands.*;
import bg.tu_varna.sit.a4.f22621685.project.commands.menuComands.*;
import bg.tu_varna.sit.a4.f22621685.project.contracts.Command;
import bg.tu_varna.sit.a4.f22621685.project.errors.InvalidException;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MenuInvoker {
    private DatabaseManager databaseManager;
    private Map<String, Command> commandMap;

    public MenuInvoker() {
        this.databaseManager = new DatabaseManager();
        this.commandMap = new HashMap<>();
    }
    private void fillMap(){
        commandMap.put("import",new ImportMenuCommand(new ImportFunction(databaseManager)));
        commandMap.put("rename",new RenameMenuCommand(new RenameCommand()));
        commandMap.put("aggregate",new AggreagteMenuCommand(new AggregateCommand()));
        commandMap.put("count",new CountMenuCommand(new CountCommand()));
        commandMap.put("delete",new DeleteMenuCommand(new DeleteCommand()));
        commandMap.put("insert",new InsertMenuCommand(new InsertCommand()));
        commandMap.put("describe",new DescribeMenuCommand(new DescribeCommand()));
        commandMap.put("print", new TablePrinterMenuCommand(new TablePrinter()));
        commandMap.put("showtables",new ShowTablesMenuCommand(new ShowTablesCommand()));
        commandMap.put("select",new SelectMenuCommand(new SelectCommand()));
        commandMap.put("update",new UpdateMenuCommand(new UpdateCommand()));
        commandMap.put("innerjoin", new InnerJoinMenuCommand(new InnerJoinCommand(),new TablePrinter()));
        commandMap.put("export",new ExportMenuCommand(new ExportFunctions(databaseManager)));
        commandMap.put("addcolumn", new AddColumnMenuCommand(new AddColumnFunctions()));
        commandMap.put("saveas",new SaveAs(new ExportFunctions(databaseManager)));
        commandMap.put("save",new SaveCommand(new ExportFunctions(databaseManager)));
        commandMap.put("open",new OpenCommand(new ImportFunction(databaseManager)));
        commandMap.put("close",new CloseCommand());
        commandMap.put("help",new HelpCommand());
    }
    public void run() throws InvalidException {
        fillMap();
        Scanner scanner = new Scanner(System.in);
        while (true){
            String[] tokens = scanner.nextLine().split("\\s+");
            if(commandMap.containsKey(tokens[0])){
                commandMap.get(tokens[0]).execute(tokens,databaseManager);
            }
        }
    }
}
