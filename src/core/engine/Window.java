package core.engine;

import javax.swing.*;
import java.awt.*;

public class Window extends Canvas {

    private final int width,height;
    private final String title;

    public Window(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
    }

    public void init() {
        JFrame frame = new JFrame();
        frame.setSize(width,height);
        frame.add(this);
        frame.setTitle(title);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
