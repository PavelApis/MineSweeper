package io.github.pavelapis.minesweeper.frames;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import javax.swing.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SuppressWarnings("PMD.BeanMembersShouldSerialize")
class WelcomeFrameTest {

    private WelcomeFrame welcomeFrame;
    private Component[] components;

    @BeforeEach
    void createFrameAndGetComponents() {
        welcomeFrame = new WelcomeFrame();
        final Component introPanelComp =  welcomeFrame.getContentPane().getComponent(0);
        assertThat(introPanelComp).isInstanceOf(JPanel.class);
        final JPanel introPanel = (JPanel) introPanelComp;
        components = introPanel.getComponents();
    }

    @Test
    void testWelcomeFrameComponents() {
        assertThat(components).hasSize(7);

        assertThat(components[0]).isInstanceOf(JLabel.class);
        assertThat(components[1]).isInstanceOf(JTextField.class);

        assertThat(components[2]).isInstanceOf(JLabel.class);
        assertThat(components[3]).isInstanceOf(JTextField.class);

        assertThat(components[4]).isInstanceOf(JLabel.class);
        assertThat(components[5]).isInstanceOf(JTextField.class);

        assertThat(components[6]).isInstanceOf(JButton.class);
    }

    @Test
    void testComponentsTexts() {
        final JLabel rowInputLabel = (JLabel) components[0];
        assertThat(rowInputLabel.getText()).isEqualTo("Enter number of rows: ");
        final JLabel columnInputLabel = (JLabel) components[2];
        assertThat(columnInputLabel.getText()).isEqualTo("Enter number of columns: ");
        final JLabel minesInputLabel = (JLabel) components[4];
        assertThat(minesInputLabel.getText()).isEqualTo("Enter number of mines: ");
        final JButton startGame = (JButton) components[6];
        assertThat(startGame.getText()).isEqualTo("Start Game");
    }

    @Test
    void testWrongStartParameters() {
        final JTextField rowInputField = (JTextField) components[1];
        final JTextField columnInputField = (JTextField) components[3];
        final JTextField minesInputField = (JTextField) components[5];
        final JButton startGame = (JButton) components[6];
        rowInputField.setText("10");
        columnInputField.setText("-20");
        minesInputField.setText("-3");
        assertThatThrownBy(startGame::doClick).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Number of columns must be more than 0.");
    }

    @Test
    void testCorrectStartParameters() {
        final JTextField rowInputField = (JTextField) components[1];
        final JTextField columnInputField = (JTextField) components[3];
        final JTextField minesInputField = (JTextField) components[5];
        final JButton startGame = (JButton) components[6];
        rowInputField.setText("10");
        columnInputField.setText("10");
        minesInputField.setText("20");

        assertThat(welcomeFrame.isDisplayable()).isTrue();
        startGame.doClick();
        assertThat(welcomeFrame.isDisplayable()).isFalse();
    }
}
