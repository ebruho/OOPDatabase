package bg.tu_varna.sit.a4.f22621685.project.commands.menuComands;

import bg.tu_varna.sit.a4.f22621685.project.Database.DatabaseManager;
import bg.tu_varna.sit.a4.f22621685.project.commands.ImportFunction;
import bg.tu_varna.sit.a4.f22621685.project.contracts.Command;
import bg.tu_varna.sit.a4.f22621685.project.errors.InvalidException;

public class OpenCommand implements Command {
    private final ImportFunction importFunction;

    public OpenCommand(ImportFunction importFunction) {
        this.importFunction = importFunction;
    }

    @Override
    public void execute(String[] data, DatabaseManager databaseManager) throws InvalidException {
        importFunction.importFile(data[1]);
        databaseManager.setFilePath(data[1]);
    }
}
