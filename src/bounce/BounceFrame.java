package bounce;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BounceFrame extends JFrame {
    private BallCanvas canvas;
    public static final int WIDTH = 450;
    public static final int HEIGHT = 350;
    private static final int lowPriorityCount = 200;
    private BallThreadController ballThreadController;

    public BounceFrame() {
        this.setSize(WIDTH, HEIGHT);
        this.setTitle("Bounce Program");

        this.canvas = new BallCanvas();
        System.out.println(this.canvas);
        Container content = this.getContentPane();

        content.add(this.canvas, BorderLayout.CENTER);
        canvas.setBackground(new Color(13, 131, 9));

        var pockets = new ArrayList<Pocket>();
        // Let's comment pockets adding for now
        // addDefaultPockets(pockets);
        this.ballThreadController = new BallThreadController(new ArrayList<>(), pockets);
        this.ballThreadController.start();

        priorityTest(pockets);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.lightGray);

        JButton startButton = new JButton("Start");
        JButton stopButton = new JButton("Stop");

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createBall(pockets, Color.RED, Thread.MIN_PRIORITY, true);
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);

        content.add(buttonPanel, BorderLayout.SOUTH);
    }

    public void addDefaultPockets(ArrayList<Pocket> pockets) {
        pockets.add(new Pocket(0, 0));
        pockets.add(new Pocket(WIDTH / 2 - ((int) (Pocket.getWidth() * 0.705f)), 0));
        pockets.add(new Pocket(WIDTH - ((int) (Pocket.getWidth() * 1.5f)), 0));
        pockets.add(new Pocket(0, HEIGHT - ((int) (Pocket.getHeight() * 3.5f))));
        pockets.add(new Pocket(WIDTH / 2 - ((int) (Pocket.getWidth() * 0.705f)), HEIGHT - ((int) (Pocket.getHeight() * 3.5f))));
        pockets.add(new Pocket(WIDTH - ((int) (Pocket.getWidth() * 1.5f)), HEIGHT - ((int) (Pocket.getHeight() * 3.5f))));

        for (var pocket : pockets) {
            canvas.add(pocket);
        }
    }

    public void createBall(ArrayList<Pocket> pockets, Color color, int priority, boolean randomSpawn) {
        Ball b = new Ball(canvas, color, randomSpawn, priority);
        canvas.add(b);
        ballThreadController.add(b);
        BallThread thread = new BallThread(b, pockets);
        thread.start();
        System.out.println("Thread name: " + thread.getName());
    }


    public void priorityTest(ArrayList<Pocket> pockets) {
        createBall(pockets, Color.RED, Thread.MAX_PRIORITY, false);
        for (var i = 0; i < lowPriorityCount; i++) {
            createBall(pockets, Color.BLUE, Thread.MIN_PRIORITY, false);
        }
    }
}
