package src;

/**
 * The LinePrinter class is designed to render Braille text representations to standard output
 * using a line buffer and a customizable font.
 *
 * <p>This class implements operations for printing individual Braille characters and strings,
 * both specified by corresponding ASCII characters.</p>
 * <p>All print operations are executed into a line buffer, which can at any time be sent to the system's
 * standard output (console) by calling the {@code flush()} method.
 * Calling the {@code flush()} method also clears the line buffer.</p>
 */
public class LinePrinter {
    // TODO: choose appropriate access modifier (public/private)
    private char[][] lineBuffer;    // buffer that holds output (bitmaps of printed braille characters)

    // TODO: choose appropriate access modifier (public/private)
    private final Font font;        // font used to render output

    // TODO: choose appropriate access modifier (public/private)
    private final int spacing;      // spacing between braille characters (measured in output columns)

    // TODO: choose appropriate access modifier (public/private)
    private int cursorPosition;     // position within the lineBuffer where the next braille character will be printed

    /**
     * Constructs a LinePrinter for rendering printable Braille text.
     * <p>The lineBuffer is allocated by calling the {@code createLineBuffer()} method.</p>
     *
     * @param font       the font that defines the printable representation for characters.
     *                   <p>Precondition: font != null</p>
     * @param lineLength the maximum number of Braille characters the line buffer can hold.
     *                   <p>Precondition: lineLength > 0</p>
     * @param spacing    the number of blank screen spaces (ASCII columns) between Braille characters (bitmaps).
     *                   <p>Precondition: spacing > 0 </p>
     */
    // TODO: choose appropriate access modifier (public/private)
    public LinePrinter(Font font, int lineLength, int spacing) {
        // TODO: implementation
        this.font = font;
        this.spacing = spacing;
        createLineBuffer(lineLength, font.getHeight(), font.getWidth());
    }

    /**
     * Creates the line buffer for printing Braille text with specified dimensions and spacing, and
     * resets the cursor position to 0.
     * <p>The line buffer's size is derived from the specified maximum number of Braille characters that can be stored
     * within the buffer, the width of the bitmap of a single Braille character, and the sum of spacing between individual
     * characters. Example: A line buffer that can hold up to 5 Braille characters (bitmap width of 2) with 1 row of
     * spacing requires size 14.</p>
     * <p>The line buffer is filled with the space char ' ' (ASCII code 32) during initialization.</p>
     *
     * @param lineLength the maximum number of Braille characters the line buffer can hold.
     *                   <p>Precondition: lineLength > 0</p>
     * @param cellHeight the height of each Braille character cell in rows. Is provided by {@code Font} object.
     *                   <p>Precondition: cellHeight > 0</p>
     * @param cellWidth  the width of each Braille character cell in columns. Is provided by {@code Font} object.
     *                   <p>Precondition: cellWidth > 0</p>
     */
    // TODO: choose appropriate access modifier (public/private)
    private void createLineBuffer(int lineLength, int cellHeight, int cellWidth) {
        // TODO: implementation
        int bufferSize = lineLength * (cellWidth + spacing) - spacing;
        lineBuffer = new char[cellHeight][bufferSize];
        for (int i = 0; i < cellHeight; i++) {
            for (int j = 0; j < bufferSize; j++) {
                lineBuffer[i][j] = ' ';
            }
        }
        cursorPosition = 0;
    }

    /**
     * Retrieves the ASCII character array representing a specific row in the line buffer.
     *
     * @param index the zero-based index of the row to retrieve.
     *              <p>Precondition: (index >= 0) && (index < lineBuffer.length)</p>
     * @return the ASCII character array of the specified row.
     */
    // TODO: choose appropriate access modifier (public/private)
    private char[] getLineBufferRow(int index) {
        // TODO: implementation
        return lineBuffer[index];
    }


    /**
     * Clears the line buffer by creating a new one and resetting the cursor position.
     */
    // TODO: choose appropriate access modifier (public/private)
    private void clearLine() {
        // TODO: implementation
        int bufferSize = (lineBuffer[0].length + spacing) / (font.getWidth() + spacing);
        createLineBuffer(bufferSize, font.getHeight(), font.getWidth());
    }

    /**
     * Prints a single Braille character into the line buffer at the cursor's position.
     * <p>The method retrieves a printable Braille representation (bitmap) of the given ASCII character from {@code font} and
     * writes it into the line buffer, considering current cursor position and spacing.</p>
     * <p>If the cursor exceeds the line buffer's length (buffer overflow), the method does not write to the
     * line buffer, but simply returns.</p>
     * <p>The cursor position is incremented by 1 after the character is written into the line buffer successfully.</p>
     *
     * @param character an ASCII character to be converted to a printable Braille representation
     *                  and printed into the line buffer.
     */
    // TODO: choose appropriate access modifier (public/private)
    private void printCharacter(char character) {
        // TODO: implementation
        //make sure cursorPosition does not overflow in x-axis
        if(cursorPosition < 0 || cursorPosition >= lineBuffer[0].length){
            return;
        }
        //getting Bitmap of character into char array
        char[][] brailleCharacter = font.getBitmap(character);
        //calculate current cursorPosition to print new character
        int currentPosition = cursorPosition * (font.getWidth() + spacing);
        //print character into lineBuffer
        for (int i = 0; i < font.getHeight(); i++) {
            for (int j = 0; j < font.getWidth(); j++) {
                lineBuffer[i][currentPosition + j] = brailleCharacter[i][j];
            }
        }
        //increment cursor position by 1
        cursorPosition++;
    }

    /**
     * Prints a string starting at the cursor's position by iterating over its characters and passing one by one to the
     * {@code printCharacter} method.
     *
     * @param string the string to be printed.
     */
    // TODO: choose appropriate access modifier (public/private)
    public void printString(String string) {
        // TODO: implementation
        for (char character : string.toCharArray()){
            printCharacter(character);
        }
    }

    /**
     * Flushes the content of the line buffer by printing each row to the standard output,
     * and then clearing the buffer by calling {@code clearLine()}.
     */
    // TODO: choose appropriate access modifier (public/private)
    public void flush() {
        // TODO: implementation
        for (int i = 0; i < lineBuffer.length; i++) {
            System.out.println(getLineBufferRow(i));
        }
        clearLine();
    }
}
