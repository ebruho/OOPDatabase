package bg.tu_varna.sit.a4.f22621685.project.commands.functions;

import bg.tu_varna.sit.a4.f22621685.project.table.Cell;
import bg.tu_varna.sit.a4.f22621685.project.table.Column;
import bg.tu_varna.sit.a4.f22621685.project.table.Table;

import java.util.List;

public class CountFunction {
    //public static int countRowsWithGivenValue(Table table,)

    public int countRowsWithGivenValue(Table table, String searchColumnName, Object searchValue) {
        int count = 0;

        List<Column> columns = table.getColumns();
        for (Column column : columns) {
            if (column.getColumnName().equals(searchColumnName)) {
                List<Cell> cells = column.getCells();
                for (Cell cell : cells) {
                    if (cell.getData().equals(searchValue)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

}
