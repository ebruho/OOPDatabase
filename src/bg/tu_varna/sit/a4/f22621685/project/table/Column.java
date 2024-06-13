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
            if(checkInteger(data)){
                hasInteger = true;
            } else if (checkDouble(data)) {
                hasDouble = true;
            }else {
                hasString=true;
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
    private boolean checkDouble(Object data){
        try{
            double v = Double.parseDouble((String) data);
            return true;
        }catch (Exception e){
            return false;
        }
    }private boolean checkInteger(Object data){
        try{
            double v = Integer.parseInt((String) data);
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
