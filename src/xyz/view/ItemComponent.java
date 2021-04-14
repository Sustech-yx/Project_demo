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
        ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int spacing = (int) (getWidth() * 0.05);
        Image image = ItemUtil.genItem(num);
        if (image != null) {
            g.drawImage(image, spacing, spacing, getWidth() - 2 * spacing, getHeight() - 2 * spacing, this);
        } else {
            if (num == 0) return;
            g.drawString("" + num, spacing, spacing);
        }
    }
}
