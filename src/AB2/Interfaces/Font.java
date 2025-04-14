package src.AB2.Interfaces;

public interface Font {

    /**
     * Retrieves a bitmap ({@code char[][]}) of a given ASCII character.
     *
     * @param character the ASCII character for which a printable character will be returned.
     * @return a bitmap ({@code char[][]}) that corresponds to the given ASCII character.
     * For letters, it returns the corresponding lowercase printable character.
     * For non-letters, it returns the representation of a white space.
     */
    char[][] getBitmap(char character);

    /**
     * Returns the font's height.
     *
     * @return the number of rows of a character's bitmap.
     */
    int getHeight();

    /**
     * Returns the font's width (the font is monospaced).
     *
     * @return the number of columns of a character's bitmap.
     */
    int getWidth();
}
