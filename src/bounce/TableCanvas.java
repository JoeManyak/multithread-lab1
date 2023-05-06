package bounce;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TableCanvas extends JPanel {
    private ArrayList<Pocket> pockets = new ArrayList<>();

    public void add(Pocket b){
        this.pockets.add(b);
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        for (Pocket b : this.pockets) {
            b.draw(g2);
        }
    }
}
