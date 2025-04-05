package src;

public class Application {
    public static void main(String[] args) {
        LinePrinter lp1 = new LinePrinter(
                new BrailleFont(3,
                                2,
                                'o',
                                '.',
                                new BrailleEncoder()),
                20,
                4
        );

        lp1.printString("Hello World");
        lp1.flush();


        LineBuffer lineBuffer = new BrailleLineBuffer(3, 1.5, 0.3);
        AdvancedLinePrinter lp = new AdvancedLinePrinter(
                new BrailleFont(
                        3,
                        2,
                        'o',
                        '.',
                        new BrailleEncoder()),
                4,
                lineBuffer
        );

        System.out.printf("buffer size: %d,  characters in buffer: %d%n", lineBuffer.size(), lineBuffer.count());
        lp.printString("Hello");
        System.out.printf("buffer size: %d,  characters in buffer: %d%n", lineBuffer.size(), lineBuffer.count());

        lp.printString(" World");
        System.out.printf("buffer size: %d,  characters in buffer: %d%n", lineBuffer.size(), lineBuffer.count());

        System.out.println("modifying buffer...");
        lp.deleteCharacter(2);
        lp.insertCharacter(2, 'a');
        lp.deleteCharacter(3);
        lp.insertCharacter(3, 'r');
        lp.deleteCharacter(4);
        lp.deleteCharacter(8);
        lp.insertCharacter(5, 'm');
        lp.insertCharacter(6, 'y');
        lp.insertCharacter(7, ' ');
        System.out.printf("buffer size: %d,  characters in buffer: %d%n", lineBuffer.size(), lineBuffer.count());

        lp.flush();
        System.out.printf("buffer size: %d  characters in buffer: %d%n", lineBuffer.size(), lineBuffer.count());

        lp.printString("OK");
        System.out.printf("buffer size: %d  characters in buffer: %d%n", lineBuffer.size(), lineBuffer.count());

        lp.flush();

    }
}
