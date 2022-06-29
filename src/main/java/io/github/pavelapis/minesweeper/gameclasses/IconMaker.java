package io.github.pavelapis.minesweeper.gameclasses;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;


public class IconMaker {

    public static void setIcon(final JButton button, final String name) {
        try (InputStream stream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream(name + ".jpg")) {
            final BufferedImage bufferedImage = ImageIO.read(stream);
            button.setIcon(new ImageIcon(bufferedImage));
        } catch (IOException e) {
            final Logger log = Logger.getLogger(IconMaker.class.getName());
            if (log.isLoggable(Level.INFO)) {
                log.info(e.getMessage());
            }
        }
    }
}
