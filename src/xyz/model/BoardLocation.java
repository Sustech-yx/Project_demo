package xyz.model;

public class BoardLocation {
    private int row;
    private int col;

    public BoardLocation (int row, int col) {
        this.col = col;
        this.row = row;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
