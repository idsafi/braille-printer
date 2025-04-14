/* DO NOT EDIT */
// This file is required for server side submission checks.

package src.AB3.Interfaces;
import src.AB3.Provided.ListNode;

/**
 * Interface for a List of {@code ListNode}.
 */
public interface List {
    int size();

    void addFirst(ListNode newNode);
    ListNode getFirst();
    ListNode removeFirst();

    void addLast(ListNode newNode);
    ListNode getLast();
    ListNode removeLast();

    ListNode get(int index);
    void insert(ListNode newNode, int index);
    ListNode remove(int index);

    void clear();

    ListNode debugGetHead();
    ListNode debugGetTail();
}
