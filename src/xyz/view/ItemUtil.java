package xyz.view;

import java.awt.*;

public class ItemUtil {
    private final static Image mask;
    private final static Image mine;
    private final static Image flag;

    static {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        mask = toolkit.getImage("src/xyz/view/pic/maskgrid.png");
        mine = toolkit.getImage("src/xyz/view/pic/gridWithMine.png");
        flag = toolkit.getImage("src/xyz/view/pic/flagmaskgrid.png");
    }

    public static Image genItem (int i) {
        switch (i) {
            case 9:
                return mask;
            case 10:
                return mine;
            case 11:
                return flag;
            default:
                return null;
        }
    }
}
