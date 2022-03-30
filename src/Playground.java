import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Playground extends JFrame {

    JPanel pnlButton = new JPanel();

    public Playground() {
        for(int i = 0; i < 9; i++){
            JButton but = new JButton();
            but.setPreferredSize(new Dimension(30, 30));
            pnlButton.add(but);
        }
        add(pnlButton);
        setSize(120, 150);
        setBackground(Color.BLACK);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Playground();
    }
}
