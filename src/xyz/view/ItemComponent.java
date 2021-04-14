package xyz.view;

import javax.swing.*;
import java.awt.*;

public class ItemComponent extends JComponent {

    private Image image;
    public ItemComponent (int num) {
        image = ItemUtil.genItem(num);
    }

    @Override
    public void paintComponent (Graphics g) {

    }

    private void painting (Graphics g) {

    }

}
