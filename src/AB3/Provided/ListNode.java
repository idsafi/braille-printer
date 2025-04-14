/* DO NOT EDIT */

package src.AB3.Provided;


/**
 * The {@code ListNode} class represents a node in a singly linked list structure.
 * Each node contains a {@code char[][]} bitmap and a reference to the next node in the list.
 */
public class ListNode {
    private final char[][] bitmap;
    private ListNode next;

    /**
     * Constructs a new {@code ListNode} with the specified bitmap.
     *
     * @param bitmap a 2-dimensional array of characters representing the bitmap contained in this node
     */
    public ListNode(char[][] bitmap) {
        this.bitmap = bitmap;
        next = null;
    }

    /**
     * Retrieves the bitmap represented as a 2-dimensional array of characters stored within this node.
     *
     * @return a bitmap ({@code char[][]}).
     */
    public char[][] getBitmap() {
        return bitmap;
    }

    /**
     * Retrieves reference to next node in the singly linked list.
     *
     * @return the next {@code ListNode} in the list. This can also be {@code null} if there is no next node.
     */
    public ListNode getNext() {
        return next;
    }


    /**
     * Sets the reference to the next node in the singly linked list.
     *
     * @param next the {@code ListNode} that will become the next node in the list.
     *             It can also be {@code null} if the current node should not reference any other node.
     */
    public void setNext(ListNode next) {
        this.next = next;
    }
}
