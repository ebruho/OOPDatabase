package bg.tu_varna.sit.a4.f22621685.project.table;

import java.util.ArrayList;
import java.util.List;


public class Column {
    private String columnName;
    private List<Cell> cells;

    public Column(String columnName) {
        this.columnName=columnName;
        cells = new ArrayList<>();
    }

    public void addCell(Cell cell) {
        cells.add(cell);
    }

    public void removeCell(Cell cell) {
        cells.remove(cell);
    }

    public List<Cell> getCells() {
        return cells;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public void setCells(List<Cell> cells) {
        this.cells = cells;
    }

    public Class<?> getColumnType(){
        boolean hasString = false;
        boolean hasDouble = false;
        boolean hasInteger = false;

        for (Cell cell:cells) {
            Object data = cell.getData();
            if(data instanceof String){
                hasString = true;
            } else if (data instanceof Double) {
                hasDouble = true;
            }else if(data instanceof Integer){
                hasInteger=true;
            }
        }

        if (hasString){
            return String.class;
        } else if (hasDouble) {
            return Double.class;
        } else if (hasInteger) {
            return Integer.class;
        } else {
            return null;
        }
    }

}
