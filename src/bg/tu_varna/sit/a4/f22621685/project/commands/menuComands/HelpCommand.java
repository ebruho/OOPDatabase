package bg.tu_varna.sit.a4.f22621685.project.commands.menuComands;

import bg.tu_varna.sit.a4.f22621685.project.Database.DatabaseManager;
import bg.tu_varna.sit.a4.f22621685.project.contracts.Command;
import bg.tu_varna.sit.a4.f22621685.project.errors.InvalidException;

public class HelpCommand implements Command {
    @Override
    public void execute(String[] data, DatabaseManager databaseManager) throws InvalidException {
        System.out.println("> help\n"+
                "The following commands are supported:\n" +
                "open <file> opens <file>\n" +
                "close closes currently opened file\n" +
                "save saves the currently open file\n" +
                "saveas <file> saves the currently open file in <file>\n" +
                "help prints this information\n" +
                "exit exists the program\n"+
                "commands"
        );
        System.out.println("import <file> adds a table to database from a file"+
                "showtables shows a list with all the loaded table names\n "+
                "describe <name> shows the types of the table columns\n"+
                "print <name> prints the table\n"+
                "export <name> <file name> saves a table in a file\n"+
                "select <column-n> <value>\n" +
                "addcolumn <table name> <column name> <column type> adds a new column with null values\n" +
                "update <table name> <search column n> <search value> <target column n> <target value> changes search value to target value\n" +
                "delete <table name> <search column n> <search value> deletes all the rows with search value\n" +
                "insert <table name> <column 1> … <column n> inserts a new row with concrete values\n" +
                "innerjoin <table 1> <column n1> <table 2> <column n2> executes the inner join operation\n" +
                "rename <old name> <new name> renames the table\n" +
                "count <table name> <search column n> <search value> finds the number of the search value in a column\n" +
                "aggregate <table name> <search column n> <search value> <target column n> <operation> performs aggregation according the operation\n"
                );

    }
}
