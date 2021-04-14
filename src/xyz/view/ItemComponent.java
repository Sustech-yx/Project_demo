package xyz.view;

import javax.swing.*;
import java.awt.*;

public class ItemComponent extends JComponent {

    private Image mask;
    private Image mine;
    private Image flag;

    {
        Toolkit toolkit = this.getToolkit();
        mask = toolkit.getImage("src/xyz/view/pic/maskgrid.png");
        mine = toolkit.getImage("src/xyz/view/pic/gridWithMine.png");
        flag = toolkit.getImage("src/xyz/view/pic/flagmaskgrid.png");
    }
}
