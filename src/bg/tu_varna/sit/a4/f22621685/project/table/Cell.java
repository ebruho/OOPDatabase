package bg.tu_varna.sit.a4.f22621685.project.table;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The Cell class represents a single cell in a table.
 * It holds data of any type.
 */
public class Cell {
    private Object data;

    /**
     * Constructs a Cell with the specified data.
     *
     * @param data the data to be stored in the cell
     */
    public Cell(Object data) {
        this.data = data;
    }

    /**
     * Returns the data stored in the cell.
     *
     * @return the data stored in the cell
     */
    public Object getData() {
        return data;
    }

    /**
     * Sets the data stored in the cell.
     *
     * @param data the data to be stored in the cell
     */
    public void setData(Object data) {
        this.data = data;
    }

    /**
     * Returns a string representation of the cell.
     *
     * @return a string representation of the cell
     */
    @Override
    public String toString() {
        return String.valueOf(data);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return Objects.equals(data, cell.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}
