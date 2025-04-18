package src.AB3;

import src.AB3.Interfaces.List;
import src.AB3.Interfaces.ListBuffer;
import src.AB3.Provided.ListNode;


/**
 * The {@code BrailleListBuffer} class provides a buffer for storing and manipulating a sequence of Braille
 * characters using a linked list. Each Braille character is represented as a bitmap contained within
 * {@code ListNode} objects. The buffer allows common operations such as adding nodes, removing nodes, inserting at
 * specific positions, and rendering the buffer contents as formatted scanlines.
 */
public class BrailleListBuffer implements ListBuffer {
    private static final char SPACE_SYMBOL=' ';
    private List list;    // can store a reference to a BrailleLinkedList


    /**
     * Constructs a new {@code BrailleListBuffer} object using the provided list.
     *
     * @param list the underlying {@code List} object used for storing and manipulating Braille characters.
     *             This list is expected to contain {@code ListNode} objects, where each node represents
     *             a Braille character as a bitmap.
     */
    BrailleListBuffer(List list) {  // Hint: pass your BrailleLinkedList to this constructor
        // TODO: implementation
        this.list = list;
    }

    /**
     * Returns the number of elements in the underlying list buffer.
     *
     * @return the number of elements in the list.
     */
    @Override
    public int size() {
        // TODO: implementation
        return list.size();
    }

    /**
     * Adds a new Braille character, represented as a 2-dimensional character array bitmap,
     * to the end of the underlying list buffer.
     *
     * @param bitmap a 2-dimensional array of characters representing the element to be added.
     *               This bitmap corresponds to a Braille character.
     */
    @Override
    public void push(char[][] bitmap) {
        // TODO: implementation
        list.addLast(new ListNode(bitmap));
    }

    /**
     * Removes and retrieves the last Braille character bitmap from the underlying list.
     * If the list is empty, this method returns {@code null}.
     *
     * @return a 2-dimensional character array representing the Braille bitmap of the removed element,
     * or {@code null} if the list is empty.
     */
    @Override
    public char[][] pop() {
        // TODO: implementation
        if(list.size() > 0){
            return list.removeLast().getBitmap();
        }
        return null;
    }

    /**
     * Inserts a new Braille character bitmap at the specified position in the underlying list buffer.
     * If the provided bitmap is null, the method does not perform any action.
     *
     * @param position the index at which the new Braille character bitmap will be inserted.
     * @param bitmap   a 2-dimensional array of characters representing the Braille character
     *                 to be inserted.
     */
    @Override
    public void insert(int position, char[][] bitmap) {
        // TODO: implementation
        if(bitmap != null){
            list.insert(new ListNode(bitmap), position);
        }
    }

    /**
     * Removes and retrieves the Braille character bitmap stored at the specified position
     * in the underlying list buffer. If the position is invalid or no element exists at the
     * specified index, it returns {@code null}.
     *
     * @param position the index of the element to be removed from the list.
     * @return a 2-dimensional character array representing the Braille bitmap of the removed element,
     *         or {@code null} if the list is empty.
     */
    @Override
    public char[][] delete(int position) {
        // TODO: implementation
        if(list.size() > 0){
            return list.remove(position).getBitmap();
        }
        return null;
    }

    /**
     * Clears the underlying list buffer.
     *
     * <p>This method invokes the {@code clear} method on the underlying list,
     * ensuring the buffer is emptied of all stored Braille character bitmaps.</p>
     */
    @Override
    public void clearBuffer() {
        // TODO: implementation
        list.clear();
    }

    /**
     * Renders the contents of the buffer into an array of strings, each representing a scanline.
     * Characters in the buffer are aligned horizontally with spacing between them.
     *
     * @param spacing the number of spaces (ASCII code 32) to insert between consecutive characters from the buffer
     *                in the rendered output.
     *                Precondition: ( spacing >= 0 )
     * @return an array of strings, where each string represents a scanline of the combined buffered characters.
     * Returns {@code null} if the buffer is empty.
     */
    @Override
    public String[] renderScanlines(int spacing) {
        // TODO: implementation
        if(list.size() > 0){
            int size = list.getFirst().getBitmap().length;
            String[] renderScanLines = new String[size];
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < list.size(); j++) {
                    char[][] line = list.get(j).getBitmap();
                    builder.append(line[i]);
                    if(j != list.size() - 1){
                        builder.append(" ".repeat(spacing));
                    }
                }
                renderScanLines[i] = builder.toString();
                builder.setLength(0);
            }
            return renderScanLines;
        }
        return null;
    }
}
