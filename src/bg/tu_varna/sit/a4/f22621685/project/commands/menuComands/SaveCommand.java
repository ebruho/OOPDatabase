package bg.tu_varna.sit.a4.f22621685.project.commands.menuComands;

import bg.tu_varna.sit.a4.f22621685.project.Database.DatabaseManager;
import bg.tu_varna.sit.a4.f22621685.project.commands.functions.AddColumnFunctions;
import bg.tu_varna.sit.a4.f22621685.project.contracts.Command;
import bg.tu_varna.sit.a4.f22621685.project.errors.InvalidException;

public class SaveCommand implements Command {
    private final AddColumnFunctions.ExportFunctions exportFunctions;

    public SaveCommand(AddColumnFunctions.ExportFunctions exportFunctions) {
        this.exportFunctions = exportFunctions;
    }

    @Override
    public void execute(String[] data, DatabaseManager databaseManager) throws InvalidException {
        if(databaseManager.getFilePath()==null){
            throw new InvalidException("There is not current path");
        }
        exportFunctions.export(data[1], databaseManager.getFilePath());
    }
}
