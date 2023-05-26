package bounce;

import java.util.ArrayList;

public class BallThread extends Thread {
    private final Ball b;
    private final ArrayList<Pocket> pockets;

    public BallThread(Ball ball, ArrayList<Pocket> pockets){
        this.b = ball;
        this.pockets = pockets;
        this.setPriority(ball.priority);
    }

    @Override
    public void run(){
        try {
            //while(true) {
                for (var pocket : pockets) {
                    if (b.inPocket(pocket)) {
                        System.out.println("Ball in pocket from thread: " + Thread.currentThread().getName());
                        b.deleteSelf();
                        return;
                    }
                }

                b.move();
                Thread.sleep(3);
           // }
        } catch (InterruptedException ex) {
            System.out.println("panic: "+ ex.getMessage());
        }
    }
}
