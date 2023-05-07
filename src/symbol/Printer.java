package symbol;

public class Printer extends Thread{
    private final String symbol;

    public Printer(String symbol){
        this.symbol = symbol;
    }

    @Override
    public void run(){
        int times = 100;
        for (var i = 0; i < times; i++){
            System.out.print(symbol);
        }
    }
}
