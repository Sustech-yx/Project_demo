package xyz.model;

public class Board {
    private Square[][] grid;
    private int row;
    private int column;

    public Board(int row, int col) {
        grid = new Square[row][col];
        this.column = col;
        this.row = row;

        iniGrid();
        iniItem();
    }

    public void iniGrid () {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                grid[i][j] = new Square(new BoardLocation(i, j));
            }
        }
    }

    public void iniItem () {
        // TODO: This is only a demo implementation.
        for (int i = 0; i < column; i++) {
            grid[0][i].setHasLandMine(true);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j].hasLandMine()) continue;
                grid[i][j].setNumberOfLandMine(calculateNum(i, j));
            }
        }
    }

    static int[][] direction = new int[][]{
            {1, 1}, {1, -1}, {1, 0}, {0, 1}, {0, -1}, {-1, 1}, {-1, -1}, {-1, 0}
    };
    public byte calculateNum (int i, int j) {
        // TODO: This is just the simplest solution and can cause the game to fail in some cases. Please update in a reasonable manner.
        byte num = 0;
        int x, y;
        for (int k = 0; k < 8; k ++) {
            x = i + direction[k][0];
            y = j + direction[k][1];
            if (x >= 0 && x < row && y >= 0 && y < column) {
                if (grid[x][y].hasLandMine()) num ++;
            }
        }
        return num;
    }

    public Square getGridAt(BoardLocation location) {
        return grid[location.getRow()][location.getColumn()];
    }

    public int getNumAt(BoardLocation location) {
        return getGridAt(location).getNum();
    }

    public void open (BoardLocation location) {
        getGridAt(location).setOpened(true);
    }

    public void flag (BoardLocation location) {
        getGridAt(location).setFlag(true);
    }

    // click type == 1 means that is left click
    // click type == 2 means that is middle click
    // click type == 3 means that is right click
    public boolean isValidClick (BoardLocation location, int clickType) {
        switch (clickType) {
            case 1:
            case 2:
                if (!getGridAt(location).isOpened() && !getGridAt(location).isFlag()) return true;
                else return false;
            default:
                return true;
        }
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
