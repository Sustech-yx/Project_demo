package xyz.controller;

import xyz.listener.GameListener;
import xyz.model.Board;
import xyz.model.BoardLocation;
import xyz.view.BoardComponent;
import xyz.view.SquareComponent;

public class GameController implements GameListener {
    private BoardComponent view;
    private Board model;
    private int currentPlayer;

    public GameController (BoardComponent component, Board board) {
        this.view = component;
        this.model = board;

        view.registerListener(this);
        initialGameState();
    }

    public void initialGameState () {
        currentPlayer = 0;
        int num;
        BoardLocation location;
        for (int row = 0; row < model.getRow(); row ++) {
            for (int col = 0; col < model.getColumn(); col ++) {
                location = new BoardLocation(row, col);
                num = model.getNumAt(location);
                view.setItemAt(location, num);
            }
        }
        view.repaint();
    }

    public int nextPlayer() {
        return currentPlayer = currentPlayer == 0 ? 1 : 0;
    }







    @Override
    public void onPlayerLeftClick(BoardLocation location, SquareComponent component) {
        printMessage(location, "left");


    }

    @Override
    public void onPlayerRightClick(BoardLocation location, SquareComponent component) {
        printMessage(location, "right");

    }

    @Override
    public void onPlayerMidClick(BoardLocation location, SquareComponent component) {
        printMessage(location, "middle");

    }

    private void printMessage (BoardLocation location, String str) {
        int row_in_message = location.getRow();
        int column_in_message = location.getColumn();
        String format = "On Player %d %s click at (%d, %d).\n";
        System.out.printf(format, currentPlayer, str, row_in_message + 1, column_in_message + 1);
    }
}
