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
    public KL keylistener;

    public Rectangle hitbox = new Rectangle(0,0,16,32);

    public Player(String texture, BufferedImage bufferedImage) {
        this.texture = texture;
        this.bufferedImage = bufferedImage;
        this.keylistener = new KL();
        playerX = 200;
        playerY = 200;
    }

    public void init() {
        try {
            bufferedImage = ImageIO.read(new File("resources\\"+texture+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void movement() {
        playerX += playerVX;
        playerY += playerVY;
    }

    public void drawPlayer(Graphics g, int posX, int posY) {
        g.drawImage(bufferedImage,posX,posY,16,32,null);
    }

    public class KL implements KeyListener {

        @Override
        public void keyTyped(KeyEvent keyEvent) {
            if (keyEvent.getKeyChar() == 'a') {
                playerVX = -1;
            }
            if (keyEvent.getKeyChar() == 'd') {
                playerVX = 1;
            }
        }

        @Override
        public void keyPressed(KeyEvent keyEvent) {

        }

        @Override
        public void keyReleased(KeyEvent keyEvent) {
            if (keyEvent.getKeyChar() == 'a') {
                playerVX = 0;
            }
            if (keyEvent.getKeyChar() == 'd') {
                playerVX = 0;
            }
        }
    }
}
