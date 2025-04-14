package src.AB1;

/**
 * The Application class serves as the entry point to the program.
 * <p>This class is used to test and demonstrate the functionality of printing text in Braille format
 * using the LinePrinter, configured with a BrailleFont and a BrailleEncoder.</p>
 * <p>Any implementation is not subject to examination and assessment by the EP2-Team, but serves as
 * free test hub for students.</p>
 */
public class Application {
    public static void main(String[] args) {

        // example from documentation
        LinePrinter lp=new  LinePrinter(
                new BrailleFont(
                        3,
                        2,
                        'o',
                        '.',
                        new BrailleEncoder()),
                20,
                4
        );
        lp.printString("Hello World");
        lp.flush();

        // TODO: implementation of any developer specific tests (optional)

    }
}
