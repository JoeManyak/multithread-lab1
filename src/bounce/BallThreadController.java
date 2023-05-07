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
            for (var i = 0; i < threads.size(); i++) {
                try {
                    threads.get(i).join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void add (Ball ball){
        balls.add(ball);
    }

    private void createThreads(){
        for (var ball: balls){
            var thread = new BallThread(ball, pockets);
            threads.add(thread);
            thread.start();
        }
    }
}
