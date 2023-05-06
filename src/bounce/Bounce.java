package bounce;

public class Bounce {
    public static void main(String[] args) {
        BounceFrame frame = new BounceFrame();
        frame.setDefaultCloseOperation(BounceFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
        System.out.println("Thread name: " + Thread.currentThread().getName());
    }
}
