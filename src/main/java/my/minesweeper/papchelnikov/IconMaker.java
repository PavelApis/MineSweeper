package my.minesweeper.papchelnikov;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Image;

public class IconMaker{
    JButton button;
    public IconMaker(JButton button){
        this.button = button;
    }
    public void setIcon(String path){
        try {
            Image mine_img = ImageIO.read(button.getClass().getResource(path));
            button.setIcon(new ImageIcon(mine_img.getScaledInstance(button.getWidth(), button.getHeight(), java.awt.Image.SCALE_SMOOTH)));
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}