package io.github.pavelapis.minesweeper.gameclasses;

import lombok.extern.slf4j.Slf4j;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.*;

@Slf4j
public class IconMaker {

    public static void setIcon(final JButton button, final String name) {
        try (InputStream stream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream(name + ".jpg")) {
            final BufferedImage bufferedImage = ImageIO.read(stream);
            button.setIcon(new ImageIcon(bufferedImage));
        } catch (IOException e) {
            if (log.isInfoEnabled()) {
                log.info(e.getMessage());
            }
        }
    }
}
