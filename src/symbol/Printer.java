package symbol;

public class Printer extends Thread {
    private final String symbol;
    private final Object mutex;

    public Printer(String symbol, Object mutex) {
        this.symbol = symbol;
        this.mutex = mutex;
    }

    @Override
    public void run() {
        int times = 100;
        for (var i = 0; i < times; i++) {
                synchronized (mutex) {
                    if (i == 0) {
                        mutex.notifyAll();
                    }

                    try {
                        mutex.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.print(symbol);
                    mutex.notifyAll();
                }
        }
    }
}
