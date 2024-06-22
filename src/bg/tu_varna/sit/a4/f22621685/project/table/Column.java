package bg.tu_varna.sit.a4.f22621685.project.table;

import java.util.ArrayList;
import java.util.List;

/**
 * The Column class represents a column in a table.
 * It contains a list of cells and a column name.
 */
public class Column {
    private String columnName;
    private List<Cell> cells;

    /**
     * Constructs a Column with the specified name.
     *
     * @param columnName the name of the column
     */
    public Column(String columnName) {
        this.columnName=columnName;
        cells = new ArrayList<>();
    }

    /**
     * Adds a cell to the column.
     *
     * @param cell the cell to be added
     */
    public void addCell(Cell cell) {
        cells.add(cell);
    }

    /**
     * Removes a cell from the column.
     *
     * @param cell the cell to be removed
     */
    public void removeCell(Cell cell) {
        cells.remove(cell);
    }

    /**
     * Returns the list of cells in the column.
     *
     * @return the list of cells
     */
    public List<Cell> getCells() {
        return cells;
    }

    /**
     * Returns the name of the column.
     *
     * @return the name of the column
     */
    public String getColumnName() {
        return columnName;
    }


    /**
     * Sets the name of the column.
     *
     * @param columnName the name to be set
     */
    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    /**
     * Sets the list of cells in the column.
     *
     * @param cells the list of cells to be set
     */
    public void setCells(List<Cell> cells) {
        this.cells = cells;
    }

    /**
     * Returns the type of data stored in the column.
     *
     * @return the class of the data type, or null if the column is empty
     */
    public Class<?> getColumnType(){
        boolean hasString = false;
        boolean hasDouble = false;
        boolean hasInteger = false;

        for (Cell cell:cells) {
            Object data = cell.getData();
            /*
            if(checkInteger(data)){
                hasInteger = true;
            } else if (checkDouble(data)) {
                hasDouble = true;
            }else {
                hasString=true;
            }

             */

            //That is an alternative method

            if (data instanceof Integer) {
                hasInteger = true;
            } else if (data instanceof Double) {
                hasDouble = true;
            } else if (data instanceof String) {
                hasString = true;
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

    /*
     /**
     * Checks if the given data can be parsed as a double.
     *
     * @param data the data to check
     * @return true if the data can be parsed as a double, false otherwise
     *
    private boolean checkDouble(Object data){
        try{
            double v = Double.parseDouble((String) data);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    /**
     * Checks if the given data can be parsed as an integer.
     *
     * @param data the data to check
     * @return true if the data can be parsed as an integer, false otherwise
     *
    private boolean checkInteger(Object data){

        try{
            double v = Integer.parseInt((String) data);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    */
}
