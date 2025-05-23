package src.AB3;
import src.AB1.Interfaces.Encoder;
import src.AB3.Interfaces.Decoder;
import src.AB3.Provided.BrailleEncoder;
import src.AB3.Provided.TreeNode;

/**
 * The class implements a decoders, which decodes Braille symbols (bitmaps) into ASCII characters.
 * <p>It utilizes a binary search tree, to find ASCII characters corresponding to e letter's Braille
 * binary encoding.</p>
 */
public class BrailleDecoder implements Decoder {
    private static final int BITMAP_HEIGHT=3;
    private static final int BITMAP_WIDTH=2;
    private static final char SPACE_SYMBOL=' ';
    private BrailleSymbolTree decoderTree;

    /**
     * Constructs a BrailleDecoder object that decodes Braille symbols (bitmaps) into their
     * corresponding ASCII characters, utilizing a predefined binary search tree.
     *
     * @param encoder     the Braille encoder that corresponds to this decoder. Required by
     *                    the construction of the binary search tree.
     *                    Precondition: ( encoder != null )
     */
    public BrailleDecoder(BrailleEncoder encoder){
        // TODO: implementation
        this.decoderTree = new BrailleSymbolTree(encoder);
        decoderTree.addNode(SPACE_SYMBOL);
        for (char c = 'a'; c <= 'z'; c++) {
            decoderTree.addNode(c);
        }
    }

    /**
     * Decodes a Braille bitmap into its corresponding ASCII character.
     * The bitmap is represented as a 2D array of characters. The raised dots in the
     * Braille bitmap are identified based on the provided `dotSymbol`. Uses a binary
     * encoding derived from the bitmap to determine the ASCII equivalent via a Braille
     * symbol tree.
     *
     * @param bitMap a 2D character array representing the Braille bitmap.
     *               The array must have dimensions corresponding to the expected
     *               Braille format (height and width). If the input is null or has
     *               incompatible dimensions, a null character (0) is returned.
     * @param dotSymbol the character that represents a raised dot in the Braille bitmap.
     * @return the corresponding ASCII character for the given Braille bitmap.
     *         Returns a space (' ') if the character is unknown or cannot be decoded,
     *         and a null character (0) if the input is invalid.
     */
    public char decodeBitmap(char[][] bitMap, char dotSymbol){
        // TODO: implementation
        if(bitMap == null || bitMap.length < BITMAP_HEIGHT || bitMap[0].length < BITMAP_WIDTH){
            return '0';
        }

        int[][] bitPositions = {
                {0, 3},
                {1, 4},
                {2, 5}
        };

        int result = 0;

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 2; col++) {
                if (bitMap[row][col] == 'o') {
                    result = result | (1 << bitPositions[row][col]);
                }
            }
        }

        byte encoded = (byte)result;
        TreeNode ascii = decoderTree.getNode(encoded);
        //char symbol = ascii.getSymbol();
        return ascii != null ? ascii.getSymbol() : ' ';
    }
}



