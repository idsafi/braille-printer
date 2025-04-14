package src.AB2.Interfaces;

public interface LineBuffer {
    /**
     * Method retrieves the maximum number of Braille characters the internal buffer can store.
     *
     * @return size of buffer
     */
    int size();

    /**
     * Method retrieves the number of characters stored within the buffer.
     *
     * @return number of Braille characters currently stored within the buffer
     */
    int count();

    /**
     * Method expands the internal buffer to accommodate additional Braille characters
     * when buffer is full. Size of the buffer is increased based on the growth factor specified during the construction
     * of the object.
     *
     * <p>Increasing the buffer preserves the existing Braille characters and ensures that their order remains unchanged.
     * The new buffer size is computed as: {@code newSize = (int)Math.ceil(currentSize * growthFactor)}</p>
     *
     * <p>Preconditions:<br>
     * 1. {@code growthFactor > 1}, as guaranteed by the constructor.</p>
     * <p>Postconditions:<br>
     * 1. The buffer is guaranteed to have enough space to store at least one more character after expansion.<br>
     * 2. The contents of the buffer prior to expansion remain intact in their original indices.<br></p>
     */
    void expandBuffer();

    /**
     * Method reduces the size of the internal buffer in order to preserve memory.
     *
     * <p>Reduction is only done, if the buffer's actual usage ratio is lower than a predefined value,
     * specified at construction time.</p>
     * <p>The new size of the buffer is computed as {@code newSize = Math.ceil(count * growthFactor)}.
     * The method ensures that the buffer's capacity remains greater than or equal to the initial size
     * defined at time of object construction.</p>
     *
     * <p>Preconditions:<br>
     * 1. The actual usage ratio (actual number of characters stored in buffer divided by buffer size) is equal or lower
     * than the reduction ratio provided at construction time.</p>
     *
     * <p>Postconditions:<br>
     * 1. If the computed new buffer size is smaller than its current size but greater than or equal
     * to the initial size, the buffer is resized and its current contents are preserved.
     * 2. If resizing is not feasible due to size constraints, the buffer size remains unchanged.</p>
     */
    void reduceBuffer();

    /**
     * Method pushes (appends) a bitmap representation of a Braille character to the end of the internal buffer.
     *
     * <p>If the buffer is full, it expands its size before appending the new bitmap.</p>
     *
     * @param bitmap the bitmap representation of a Braille character to be appended to the buffer for details).
     *               Precondition: ( bitmap != null )
     */
    void push(char[][] bitmap);

    /**
     * Method retrieves the last bitmap of a Braille character from the internal buffer. If the buffer is empty,
     * {@code null} is returned instead. If a bitmap was found, it is removed from the buffer and the buffer might be shrunk.
     *
     * @return {@code null} if buffer is empty, or the bitmap at the end of the buffer.
     */
    char[][] pop();

    /**
     * Method inserts a bitmap representation of a Braille character into the internal buffer at specified position by
     * shifting all existing characters at and right of the specified position to the right (next index).
     *
     * <p>If the buffer is full, it expands its size before inserting the new bitmap.</p>
     *
     * @param cursorPosition the index at which the character has to be inserted.
     * @param bitmap         the bitmap representation of a Braille character to be appended to the buffer for details).
     *                       Precondition: ( bitmap != null )
     * @return  {@code true} if the character was successfully inserted,
     *          {@code false} otherwise (e.g., invalid position or empty buffer).
     */
    boolean insert(int cursorPosition, char[][] bitmap);

    /**
     * Method deletes a Braille character at the specified position in the buffer.
     * Shifts the characters located after the specified position one step to the left.
     *
     * @param cursorPosition the index of the character to be deleted.
     * @return  {@code true} if the character was successfully deleted,
     *          {@code false} otherwise (e.g., invalid position or empty buffer).
     */
    boolean delete(int cursorPosition);

    /**
     * Method clears the content of the buffer.
     * <p>The buffer is reinitialized with its initial size, while the count of currently stored characters
     * is reset to zero.</p>
     */
    void clearBuffer();

    /**
     * Renders the contents of the buffer into an array of strings, each representing a scanline.
     * Characters in the buffer are aligned horizontally with spacing between them.
     *
     * @param spacing the number of spaces (ASCII code 32) to insert between consecutive characters from the buffer
     *                in the rendered output.
     *                Precondition: (spacing >= 0)
     * @return an array of strings, where each string represents a scanline of the combined buffered characters.
     * Returns {@code null} if the buffer is empty or an error occurs during rendering (e.g. invalid font height).
     */
    String[] renderScanlines(int spacing);
}

