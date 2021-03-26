package core.game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player {

    private BufferedImage bufferedImage;
    private final String texture;

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
}
