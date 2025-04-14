/* DO NOT EDIT */

package src.AB3.Provided;

/**
 * The {@code TreeNode} class represents a node within a binary tree structure.
 * Each node contains a symbol of type {@code char}, and references to its left and right child nodes.
 */
public class TreeNode{
    private char symbol;
    private TreeNode left;
    private TreeNode right;

    /**
     * Constructs a new {@code TreeNode} with default values.
     */
    // create node
    public TreeNode(){
        this.symbol = 0;
        left = null;
        right = null;
    }

    /**
     * Sets the symbol for this {@code TreeNode}.
     *
     * @param symbol the character to be assigned to this node.
     */
    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    /**
     * Sets the left child of this {@code TreeNode}.
     *
     * @param left the {@code TreeNode} to be set as the left child of this node.
     *             It can also be {@code null} if this node should not have a left child.
     */
    public void setLeft(TreeNode left) {
        this.left = left;
    }

    /**
     * Sets the right child of this {@code TreeNode}.
     *
     * @param right the {@code TreeNode} to be set as the right child of this node.
     *              It can also be {@code null} if this node should not have a right child.
     */
    public void setRight(TreeNode right) {
        this.right = right;
    }

    /**
     * Retrieves the symbol stored in this {@code TreeNode}.
     *
     * @return the character representing the symbol of this node.
     */
    public char getSymbol() {
        return symbol;
    }

    /**
     * Retrieves the left child node of this {@code TreeNode}.
     *
     * @return the left child {@code TreeNode}, or {@code null} if this node does not have a left child.
     */
    public TreeNode getLeft() {
        return left;
    }

    /**
     * Retrieves the right child node of this {@code TreeNode}.
     *
     * @return the right child {@code TreeNode}, or {@code null} if this node does not have a right child.
     */
    public TreeNode getRight() {
        return right;
    }
}
