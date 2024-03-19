package bg.tu_varna.sit.a4.f22621685.project.table;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private List<Column<?>> columns;

    public Table() {
        columns = new ArrayList<>();
    }

    public void addColumn(Column<?> column) {
        columns.add(column);
    }

    public void removeColumn(Column<?> column) {
        columns.remove(column);
    }

    public List<Column<?>> getColumns() {
        return columns;
    }
}