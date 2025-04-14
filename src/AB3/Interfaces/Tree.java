/* DO NOT EDIT */
// This file is required for server side submission checks.

package src.AB3.Interfaces;
import src.AB3.Provided.TreeNode;

/**
 * Interface of a binary search tree for tree based decoders.
 */
public interface Tree {
    void addNode(char asciiCharacter);
    TreeNode getNode(byte encoded);
    TreeNode getRoot();
}
