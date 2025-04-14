package src.AB2.Interfaces;

public interface Encoder {

    /**
     * Encoder for ASCII to binary representation of a Braille cell.
     *
     * <p>This method encodes a given ASCII character from range [a-z] to its
     * corresponding Braille binary representation.</p>
     *
     * @param asciiChar an ASCII character from the lower case alphabet ['a','z']
     *                  <p>Precondition: (asciiChar>='a') && (asciiChar<='z')</p>
     */
    byte toBinary(char asciiChar);
}

