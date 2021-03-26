package core.game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Blocks {

    private BufferedImage bufferedImage;
    private final String texture;

    public Blocks(String texture, BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
        this.texture = texture;
    }

    public void init() {
        try {
            bufferedImage = ImageIO.read(new File("resources\\"+texture+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void drawBlock(Graphics g, int posX, int posY) {
        g.drawImage(bufferedImage,posX,posY,16,16,null);
    }
}
