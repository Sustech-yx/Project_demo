package xyz.model;

public class Square {
    private BoardLocation location;
    private boolean isOpened;
    private boolean hasLandMine;
    private byte numberOfLandMine;

    public Square(BoardLocation location) {
        this.location = location;
    }

    public BoardLocation getLocation() {
        return location;
    }

    public boolean isOpened() {
        return isOpened;
    }

    public boolean isHasLandMine() {
        return hasLandMine;
    }

    public byte getNumberOfLandMine() {
        return numberOfLandMine;
    }
    public void setOpened(boolean opened) {
        isOpened = opened;
    }

    public void setHasLandMine(boolean hasLandMine) {
        this.hasLandMine = hasLandMine;
    }

    public void setNumberOfLandMine(byte numberOfLandMine) {
        this.numberOfLandMine = numberOfLandMine;
    }

    /*
    Each grid has five states: the first two include a grid that is not open or is marked;
    The last three are lattice is opened, if there are no mines around, do not show;
    The number of mines, if any;
    If it is a mine, draw a mine
     */
}
