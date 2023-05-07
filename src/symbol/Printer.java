package symbol;

public class Printer extends Thread {
    private final String symbol;
    private final Object mutex;
    private final static int sleepTime = 3;

    public Printer(String symbol, Object mutex) {
        this.symbol = symbol;
        this.mutex = mutex;
    }

    @Override
    public void run() {
        int times = 100;
        for (var i = 0; i < times; i++) {
            try {
                synchronized (mutex) {
                    System.out.print(symbol);
                    Thread.sleep(sleepTime);
                }
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
