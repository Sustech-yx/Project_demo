package xyz.controller;

import xyz.listener.GameListener;
import xyz.model.Board;
import xyz.model.BoardLocation;
import xyz.view.BoardComponent;
import xyz.view.ScoreBoard;
import xyz.view.SquareComponent;

public class GameController implements GameListener {
    private final BoardComponent view1;
    private final ScoreBoard view2;
    private final Board model;
    private int currentPlayer;

    public GameController (BoardComponent component, Board board, ScoreBoard scoreBoard) {
        this.view1 = component;
        this.view2 = scoreBoard;
        this.model = board;

        view1.registerListener(this);
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
                view1.setItemAt(location, num);
            }
        }
        view1.repaint();
    }

    public void nextPlayer() {
        currentPlayer = currentPlayer == 0 ? 1 : 0;
    }

    @Override
    public void onPlayerLeftClick(BoardLocation location, SquareComponent component) {
        printMessage(location, "left");
        if (model.isValidClick(location, 1)) {
            model.openGrid(location);
            view1.setItemAt(location, model.getNumAt(location));
            if (model.getGridAt(location).hasLandMine()) {
                Lose();
            }
            nextPlayer();
            view1.repaint();
        } else {
            System.out.print("But is not a valid click.");
        }
    }

    @Override
    public void onPlayerRightClick(BoardLocation location, SquareComponent component) {
        printMessage(location, "right");
        if (model.isValidClick(location, 2)) {
            if (model.getGridAt(location).hasLandMine()) {
                Goal();
                model.flagGrid(location);
            } else {
                Lose();
                model.openGrid(location);
            }
            view1.setItemAt(location, model.getNumAt(location));
            nextPlayer();
        } else {
            System.out.print("But is not a valid click.");
        }
    }

    @Override
    public void onPlayerMidClick(BoardLocation location, SquareComponent component) {
        printMessage(location, "middle");

    }

    private void printMessage (BoardLocation location, String str) {
        int row_in_message = location.getRow();
        int column_in_message = location.getColumn();
        String format = "\nOn Player %d %s click at (%d, %d). ";
        System.out.printf(format, currentPlayer, str, row_in_message + 1, column_in_message + 1);
    }

    private void Goal () {
        view2.Goal(currentPlayer);
        view2.repaint();
    }

    private void Lose () {
        view2.Lose(currentPlayer);
        view2.repaint();
    }
}
