package core.game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player {

    private BufferedImage bufferedImage;
    private final String texture;

    public int playerX,playerY,playerVX,playerVY;

    public Player(String texture, BufferedImage bufferedImage) {
        this.texture = texture;
        this.bufferedImage = bufferedImage;
    }

    public void init() {
        try {
            bufferedImage = ImageIO.read(new File("resources\\"+texture+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void drawPlayer(Graphics g, int posX, int posY) {
        g.drawImage(bufferedImage,posX,posY,16,32,null);
    }

    private class KL implements KeyListener {

        @Override
        public void keyTyped(KeyEvent keyEvent) {

        }

        @Override
        public void keyPressed(KeyEvent keyEvent) {

        }

        @Override
        public void keyReleased(KeyEvent keyEvent) {

        }
    }
}
