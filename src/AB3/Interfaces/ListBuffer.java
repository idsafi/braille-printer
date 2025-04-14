/* DO NOT EDIT */
// This file is required for server side submission checks.

package src.AB3.Interfaces;

/**
 * The {@code ListBuffer} interface defines a buffer for storing and manipulating a sequence of
 * Braille characters represented as bitmap objects using a singly linked list. The buffer allows for
 * various operations such as appending, inserting, deleting, and rendering characters, enabling efficient management
 * of Braille content.
 */
public interface ListBuffer {
    int size();

    void push(char [][] bitmap);
    char[][] pop();

    void insert(int position, char[][] bitmap);
    char[][] delete(int position);

    void clearBuffer();

    String[] renderScanlines(int spacing);
}
