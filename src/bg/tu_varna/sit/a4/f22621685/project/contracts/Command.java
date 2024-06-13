package bg.tu_varna.sit.a4.f22621685.project.contracts;

import bg.tu_varna.sit.a4.f22621685.project.Database.DatabaseManager;
import bg.tu_varna.sit.a4.f22621685.project.errors.InvalidException;
import bg.tu_varna.sit.a4.f22621685.project.table.Table;

public interface Command {
    void execute(String[] data, DatabaseManager databaseManager) throws InvalidException;
}
