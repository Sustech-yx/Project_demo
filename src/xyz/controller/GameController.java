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








    @Override
    public void onPlayerLeftClick(BoardLocation location, SquareComponent component) {

    }

    @Override
    public void onPlayerRightClick(BoardLocation location, SquareComponent component) {

    }

    @Override
    public void onPlayerMidClick(BoardLocation location, SquareComponent component) {

    }
}
