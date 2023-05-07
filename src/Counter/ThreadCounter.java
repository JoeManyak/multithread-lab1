package Counter;

public class ThreadCounter extends Thread{
    private final Counter counter;
    private final int initialSleep;
    private int changeValue;
    ThreadCounter(Counter counter, int change, int initialSleep){
        this.counter = counter;
        this.changeValue = change;
        this.initialSleep = initialSleep;
    }

    @Override
    public void run(){
        try {
            Thread.sleep(initialSleep);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        while (changeValue!= 0) {
            if (changeValue > 0) {
                counter.increment();
                changeValue--;
            } else {
                counter.decrement();
                changeValue++;
            }
        }
    }
}
