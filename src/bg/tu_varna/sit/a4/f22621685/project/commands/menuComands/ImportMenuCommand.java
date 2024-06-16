package bg.tu_varna.sit.a4.f22621685.project.commands.menuComands;

import bg.tu_varna.sit.a4.f22621685.project.Database.DatabaseManager;
import bg.tu_varna.sit.a4.f22621685.project.commands.functions.ImportFunction;
import bg.tu_varna.sit.a4.f22621685.project.contracts.Command;
import bg.tu_varna.sit.a4.f22621685.project.errors.InvalidException;

public class ImportMenuCommand implements Command {
    private final ImportFunction importFunction;

    public ImportMenuCommand(ImportFunction importFunction) {
        this.importFunction = importFunction;
    }

    @Override
    public void execute(String[] data, DatabaseManager databaseManager) throws InvalidException {
        importFunction.importFile(data[1]);
    }
}
