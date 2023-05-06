package bounce;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Pocket {
    private static final int WIDTH = 30;
    private static final int HEIGHT = 30;
    private final int x;
    private final int y;

    public Pocket(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics2D g2) {
        g2.setColor(new Color(26,51,25));
        g2.fill(new Ellipse2D.Double(x, y, WIDTH, HEIGHT));
    }

    public boolean contains(int x, int y) {
        final Ellipse2D pocketEllipse = new Ellipse2D.Double(this.x, this.y, WIDTH, HEIGHT);
        return pocketEllipse.contains(x, y);
    }

    public static int getWidth() {
        return WIDTH;
    }

    public static int getHeight() {
        return HEIGHT;
    }
}