package xyz.model;

public class Board {
    private Square[][] gird;
    private int rowLength;
    private int colLength;

    public Board(int rowLength, int colLength) {
        gird = new Square[rowLength][colLength];
        this.colLength = colLength;
        this.rowLength = rowLength;
    }
}
