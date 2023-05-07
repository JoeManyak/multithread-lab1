package Counter;

public class CounterMain {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        ThreadCounter positiveCounter = new ThreadCounter(counter, 10000000, 0);
        ThreadCounter negativeCounter = new ThreadCounter(counter, -10000000, 300);
        positiveCounter.start();
        negativeCounter.start();

        for (int i = 0; i<200; i++){
            System.out.println(counter.getCount());
            Thread.sleep(20);
        }
    }
}
