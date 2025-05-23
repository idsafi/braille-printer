package src.AB3;
import src.AB3.Interfaces.Decoder;

/**
 * The BrailleReader class provides functionality to translate Braille text lines represented as
 * scan lines into ASCII text. It uses a Decoder to decode Braille character bitmaps into corresponding
 * ASCII characters.
 */
public class BrailleReader {
    private final int WIDTH=2;
    private final int HEIGHT=3;

    private Decoder decoder;    // can store a reference to a BrailleDecoder

    /**
     * Constructs a BrailleReader instance.
     */
    public BrailleReader(Decoder decoder){ // Hint: pass your BrailleDecoder to this constructor
        // TODO: implementation
        this.decoder = decoder;
    }

    /**
     * Extracts a Braille character represented as a 2D array from the given Braille scanlines.
     *
     * @param position the zero-based number of the Braille character in the given line data.
     * @param spacing the number of characters used as spacing between Braille characters in the line data.
     * @param brailleLine an array of strings (scanlines) representing the Braille line data.
     * @return the bitmap of a single Braille character extracted from the provided
     *         line data, or null if the {@code brailleLine} is invalid or {@code null},
     *         or the specified position is out of bounds.
     */
    private char[][] getBrailleChar(int position, int spacing, String[] brailleLine){
        // TODO: implementation
        if(brailleLine == null){
            return null;
        }
        char[][] bitmap = new char[HEIGHT][WIDTH];
        for (int i = 0; i < WIDTH; i++, position++) {
            for (int j = 0; j < HEIGHT; j++) {
                bitmap[j][i] = brailleLine[j].charAt(position);
            }
        }
        return bitmap;
    }

    /**
     * Translates the given Braille text lines into an ASCII representation.
     *
     * @param brailleLine an array of strings representing scanlines of Braille text.
     * @param dotSymbol the character used to represent raised Braille dots in the bitmap.
     * @param spacing the number of spaces between individual Braille characters within the input.
     * @return a string representing the ASCII translation of the Braille text. Returns an
     *         empty string if the input is invalid or no Braille characters are detected.
     */
    public String translate(String[] brailleLine, char dotSymbol, int spacing){
        // TODO: implementation
        if(brailleLine == null){
            return "";
        }
        StringBuilder builder = new StringBuilder();
        int curserPos = 0;
        char[][] bitmap = new char[HEIGHT][WIDTH];
        int elements = brailleLine[0].length() / (WIDTH + spacing);
        for (int e = 0; e <= elements; ++e) {
            for (int i = 0; i < WIDTH; i++, curserPos++) {
                for (int j = 0; j < HEIGHT; j++) {
                    bitmap[j][i] = brailleLine[j].charAt(curserPos);
                }
            }
            builder.append(decoder.decodeBitmap(bitmap, dotSymbol));
            curserPos += spacing;
        }
        return builder.toString();
    }
}
