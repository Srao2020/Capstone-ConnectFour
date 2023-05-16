public class Position {
    private int row, col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }
    //col getter/setter
    public int getColumn() { return col; }
    public void setCol(int col) { this.col = col; }

    //row getter/setter
    public int getRow() { return row; }
    public void setRow(int row) { this.row = row; }

    public boolean equals(Object other) {
        if (other instanceof Position){
            Position temp = (Position) other;
            return this.row == temp.row && this.col == temp.col;
        }
        return false;
    }
}

