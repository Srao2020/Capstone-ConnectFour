/**
 * Represents a position in a two-dimensional grid.
 * @author Srao2020
 * @version 05/25/2023
 */

public class Position {
    private int row, col;

    /**
     * Constructs a new Position object with the specified row and column values.
     * @param row the row index
     * @param col the column index
     */
    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    /**
     * Retrieves the column index of this position.
     * @return the column index
     */
    //col getter/setter
    public int getColumn() { return col; }

    /**
     * Sets the column index of this position.
     * @param col the new column index
     */
    public void setCol(int col) { this.col = col; }

    /**
     * Retrieves the row index of this position.
     * @return the row index
     */
    //row getter/setter
    public int getRow() { return row; }

    /**
     * Sets the row index of this position.
     * @param row the new row index
     */
    public void setRow(int row) { this.row = row; }

    /**
     * Checks if this position is equal to the specified object.
     * @param other the object to compare for equality
     * @return true if the object is a Position with the same row and column values, false otherwise
     */
    public boolean equals(Object other) {
        if (other instanceof Position){
            Position temp = (Position) other;
            return this.row == temp.row && this.col == temp.col;
        }
        return false;
    }
}

