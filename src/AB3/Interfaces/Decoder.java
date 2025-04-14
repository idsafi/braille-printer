/* DO NOT EDIT */
// This file is required for server side submission checks.

package src.AB3.Interfaces;

/**
 * Interface for decoders, which decode Braille symbols (bitmaps) into ASCII characters.
 */
public interface Decoder {
    char decodeBitmap(char[][] bitMap, char dotSymbol);
}
