/* DO NOT EDIT */
package src.AB3.Provided;

/**
 * This class implements an encoder from ASCII character to Braille binary representation.
 * In Braille binary representation a 2D Braille cell is represented by one byte,
 * where each dot is mapped to one specific bit.
 *
 * <p> The encoder utilizes a lookup table ({@code brailleLUT}) of predefined binary values
 * corresponding to ASCII characters </p>
 */
public class BrailleEncoder {

    /**
     * Lookup table (LUT) for Braille character encoding.
     *
     * <p>This array holds the Braille cells binary representation for all lower case ASCII letters ('a' to 'z').
     * Index 0 corresponds to letter 'a', index 1 to letter 'b', index 2 to letter 'c' and so on.
     * The binary representation of each letter specifies which dots are set within the letter's Braille cell,
     * a 2x3 dot matrix configuration of specific dots set (1 or 0).</p>
     * <p>
     * The LUT must be used by method {@code toBinary}.
     */
    private static final byte[] brailleLUT = {
            0b000001, 0b000011, 0b001001, 0b011001, 0b010001,   // a-e
            0b001011, 0b011011, 0b010011, 0b001010, 0b011010,   // f-j
            0b000101, 0b000111, 0b001101, 0b011101, 0b010101,   // k-o
            0b001111, 0b011111, 0b010111, 0b001110, 0b011110,   // p-t
            0b100101, 0b100111, 0b111010, 0b101101, 0b111101,   // u-y
            0b110101                                            // z
    };

    /**
     * This method encodes a given ASCII character from range [a-z] to its
     * corresponding Braille binary representation.</p>
     *
     * @param asciiChar an ASCII character from the lower case alphabet ['a','z']
     *                  <p>Precondition: (asciiChar>='a') && (asciiChar<='z')</p>
     */
    public byte toBinary(char asciiChar) {
        return brailleLUT[asciiChar - 'a'];
    }
}
