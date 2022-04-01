import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Function;

public class WelcomeFrame extends JFrame {
    public WelcomeFrame(){
        setResizable(false);
        JPanel introPanel = new JPanel();
        add(introPanel);
        introPanel.setPreferredSize(new Dimension(300, 110));
        introPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        introPanel.setAlignmentY(Component.CENTER_ALIGNMENT);

        JLabel rowInputLabel = new JLabel("Enter number of rows: ");
        JLabel columnInputLabel = new JLabel("Enter number of columns: ");
        JLabel minesInputLabel = new JLabel("Enter number of mines: ");

        JTextField rowInputField = new JTextField(5);
        JTextField columnInputField = new JTextField(5);
        JTextField minesInputField = new JTextField(5);



        JButton start_game = new JButton("Start Game");
        start_game.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Function<JTextField, Integer> getText = x -> Integer.parseInt(x.getText());
                Game game = new Game(getText.apply(rowInputField), getText.apply(columnInputField), getText.apply(minesInputField));
            }
        });

        introPanel.add(rowInputLabel);
        introPanel.add(rowInputField);
        introPanel.add(columnInputLabel);
        introPanel.add(columnInputField);
        introPanel.add(minesInputLabel);
        introPanel.add(minesInputField);
        introPanel.add(start_game, BorderLayout.CENTER);
        pack();
        setTitle("Minesweeper");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
