package io.github.pavelapis.minesweeper.gameclasses;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.*;

@Slf4j
public class IconMaker {

    public static ImageIcon makeIcon(final String name) {
        try (InputStream stream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream(name + ".jpg")) {
            return new ImageIcon(ImageIO.read(stream));
        } catch (IOException e) {
            if (log.isErrorEnabled()) {
                log.error("Error occurred during processing jpg: {}", e.getMessage(), e);
            }
            throw new IllegalStateException(e);
        }
    }
}

