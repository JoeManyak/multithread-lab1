package symbol;

public class PrintController {
    private Object mutex = new Object();
    private Printer printer1;
    private Printer printer2;

    public PrintController(){
        printer1 = new Printer("-", mutex);
        printer2 = new Printer("|", mutex);

        printer1.start();
        printer2.start();
    }
}
