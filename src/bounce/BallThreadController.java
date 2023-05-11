package bounce;

import java.util.ArrayList;

public class BallThreadController extends Thread {
    private ArrayList<BallThread> threads;
    private ArrayList<Ball> balls;
    private ArrayList<Pocket> pockets;

    public BallThreadController(ArrayList<Ball> balls, ArrayList<Pocket> pockets){
        this.balls = balls;
        this.pockets = pockets;
        this.threads = new ArrayList<>();
    }

    @Override
    public void run() {
        while (true) {
            createThreads();
        }
    }

    public void add (Ball ball){
        balls.add(ball);
    }

    private void createThreads() {
        for (var i = 0; i<balls.size(); i++){
            var thread = new BallThread(balls.get(i), pockets);
            threads.add(thread);
            thread.start();
        }
    }
}
