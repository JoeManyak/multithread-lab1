package bounce;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Random;

public class Ball {
    private BallCanvas canvas;
    private static final int XSIZE = 20;
    private static final int YSIZE = 20;

    private int x = 0;
    private int y = 0;
    private int dx = 1;
    private int dy = 1;

    public Ball (BallCanvas c) {
        this.canvas = c;
        var rand = new Random();
        if (Math.random() < 0.5) {
            x = rand.nextInt(this.canvas.getWidth()-60)+30;
            y = 30;
        } else {
            x = 30;
            y = rand.nextInt(this.canvas.getHeight()-60)+30;
        }
    }

    public void draw(Graphics2D g2) {
        g2.setColor(Color.RED);
        g2.fill(new Ellipse2D.Double(x, y, XSIZE, YSIZE));
    }

    public void move() {
        x += dx;
        y += dy;
        if (x < 0) {
            x = 0;
            dx = -dx;
        }
        if (x + XSIZE >= this.canvas.getWidth()) {
            x = this.canvas.getWidth() - XSIZE;
            dx = -dx;
        }
        if (y < 0) {
            y = 0;
            dy = -dy;
        }
        if (y + YSIZE >= this.canvas.getHeight()) {
            y = this.canvas.getHeight() - YSIZE;
            dy = -dy;
        }
        this.canvas.repaint();
    }

    public boolean inPocket(Pocket pocket) {
        return pocket.contains(x,y);
    }

    public void deleteSelf(){
        this.canvas.delete(this);
    }
}