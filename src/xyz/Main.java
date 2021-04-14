package xyz;

import xyz.view.BoardComponent;
import xyz.view.GameFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BoardComponent boardComponent = new BoardComponent(10, 10, 800, 800);


            GameFrame gameFrame = new GameFrame();
            gameFrame.add(boardComponent);
            gameFrame.setVisible(true);
        });
    }
}
