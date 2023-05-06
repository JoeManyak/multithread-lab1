package bounce;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BallCanvas extends JPanel {
    private final Object mutex = new Object();
    private ArrayList<Ball> balls = new ArrayList<>();
    private ArrayList<Pocket> pockets = new ArrayList<>();

    public void add(Ball b) {
        synchronized (mutex) {
            this.balls.add(b);
        }
    }

    public void add(Pocket b) {
        synchronized (mutex) {
            this.pockets.add(b);
        }
    }

    public void delete(Ball b) {
        synchronized (mutex) {
            this.balls.remove(b);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        synchronized (mutex) {
            for (Ball b : this.balls) {
                b.draw(g2);
            }
            for (Pocket b : this.pockets) {
                b.draw(g2);
            }
        }
    }
}
