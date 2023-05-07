package Counter;

public class Counter {
    private int count = 0;
    private final Object mutex = new Object();

    public void increment() {
        synchronized (mutex) {
            count++;
        }
    }

    public void decrement() {
        synchronized (mutex) {
            count--;
        }
    }

    public int getCount() {
        synchronized (mutex) {
            return count;
        }
    }
}
