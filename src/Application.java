package src;

public class Application {
    public static void main(String[] args) {
        LinePrinter lp = new LinePrinter(
                new BrailleFont(3,
                                2,
                                'o',
                                '.',
                                new BrailleEncoder()),
                20,
                4
        );

        lp.printString("Hello World");
        lp.flush();
    }
}
