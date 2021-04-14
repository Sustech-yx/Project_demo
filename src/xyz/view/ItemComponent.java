package xyz.view;

import javax.swing.*;
import java.awt.*;

public class ItemComponent extends JComponent {

    private int num;
    public ItemComponent (int num) {
        this.num = num;
    }

    @Override
    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        painting(g);
    }

    private void painting (Graphics g) {

    }

}
