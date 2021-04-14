package xyz;

import xyz.controller.GameController;
import xyz.model.Board;
import xyz.view.BoardComponent;
import xyz.view.GameFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BoardComponent boardComponent = new BoardComponent(10, 10, 800, 800);
            Board board = new Board(10, 10);
            GameController gameController = new GameController(boardComponent, board);

            GameFrame gameFrame = new GameFrame();
            gameFrame.add(boardComponent);
            gameFrame.setVisible(true);
        });
    }
}
