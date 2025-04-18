package src.AB3;
import src.AB3.Interfaces.Tree;
import src.AB3.Provided.BrailleEncoder;
import src.AB3.Provided.TreeNode;

/**
 * The BrailleSymbolTree class represents a binary search tree structure for Braille symbol encoding and decoding.
 * It utilizes a binary representation of Braille characters to navigate the tree by using the binary encoding as path
 * descriptor. The class supports adding and retrieving leaf nodes within the tree, which represent ASCII characters
 * corresponding to their Braille binary format.
 */
public class BrailleSymbolTree implements Tree {
    private TreeNode root;
    private BrailleEncoder encoder = null;


    /**
     * Constructs a new {@code BrailleSymbolTree} instance utilizing the given encoder.
     * <p>To build the search tree, all ASCII characters for the letters 'a' to 'z' and the ASCII character
     * for the white space (' '), having a binary encoding of {@code 0b000000} are inserted into the tree via {@code addNode()}.</p>
     * @param encoder     the {@code BrailleEncoder} used to convert ASCII characters into their Braille binary representation.
     *                    <p>Precondition: ( encoder != null )</p>
     */
    public BrailleSymbolTree(BrailleEncoder encoder) {
        // TODO: implementation
        root = new TreeNode();
        this.encoder = encoder;
    }

    /**
     * Inserts a new node into the BrailleSymbolTree based on the given ASCII character. The BrailleSymbolTree
     * has a constant depth of 7 ( 6 intermediate layers + leaves ). Symbols are stored in leave nodes only,
     * as all intermediate nodes are navigation nodes.
     * <p>A character's binary encoding is used as navigation aid, to traverse the binary tree. It is processed
     * from LSB to MSB, where each bit denotes a traversal to the left, if not set ({@code 0}), or a traversal to the
     * right, if set ({@code 1}), at the tree's corresponding layer.
     * A set LSB, for example, denotes a traversal to {@code right} at the tree's root node.</p>
     * <p>If a leave node is reached, the {@code asciiCharacter} is stored within the node's {@code symbol variable}</p>
     * <p>If the character is a white space (' '), a binary encoding of (0b000000) is assumed, otherwise
     * the encoder is used to calculate the binary encoding.</p>
     *
     * @param asciiCharacter the ASCII character to be inserted as a symbol into the tree.
     */
    @Override
    public void addNode(char asciiCharacter) {
        // TODO: implementation
        byte brailleToBinary;
        if(asciiCharacter == ' '){
            brailleToBinary = 0b000000;
        } else {
            brailleToBinary = encoder.toBinary(asciiCharacter);
        }
        add(brailleToBinary, root, asciiCharacter, 0);
    }

    //helper method for initializing the path and adding the ascii to the path end rekursive
    private void add(byte encoded, TreeNode node, char ascii, int index){
        if(index > 6){
            TreeNode setLeaf = new TreeNode();
            setLeaf.setSymbol(ascii);
            node.setLeft(setLeaf);
            return;
        }
        int bit = (encoded & (1 << index)) != 0 ? 1 : 0;
        if(bit == 0){
            if(node.getLeft() != null){
                add(encoded, node.getLeft(), ascii, ++index);
            } else {
                node.setLeft(new TreeNode());
                add(encoded, node.getLeft(), ascii, ++index);
            }
        } else {
            if(node.getRight() != null){
                add(encoded, node.getRight(), ascii, ++index);
            } else {
                TreeNode nodeRight = new TreeNode();
                nodeRight.setSymbol('1');
                node.setRight(nodeRight);
                add(encoded, node.getRight(), ascii, ++index);
            }
        }
    }


    /**
     * Traverses the binary tree based on the given encoded Braille representation of a ASCII character and
     * retrieves the corresponding leaf node, or returns {@code null} if the given binary encoding is not found
     * within the tree.
     * <b>The traversal is performed bit by bit, starting from the least significant bit.
     * A bit value of {@code 0} traverses left, and a bit value of {@code 1} traverses right.</b>
     *
     * @param encoded the byte encoding used to navigate the binary tree. Each bit represents a direction in the tree,
     *                where {@code 0} navigates to the left child and {@code 1} navigates to the right child.
     * @return the {@code TreeNode} at the leaf corresponding to the encoded path, or {@code null} if the path
     *         is invalid or the encoded value does not lead to a complete traversal of the tree.
     */
    @Override
    public TreeNode getNode(byte encoded){
        // TODO: implementation
        return search(encoded, root, 0);
    }

    private TreeNode search(byte encoded, TreeNode node, int index){
        if(index > 6){
            return node.getLeft();
        }

        if(node != null){

            int bit = (encoded & (1 << index)) != 0 ? 1 : 0;

            if(bit == 0){
                return search(encoded, node.getLeft(), ++index);
            } else {
                return search(encoded, node.getRight(), ++index);
            }

        }

        return null;
    }


    /**
     *   Method is required for submission testing.
     *   DO NOT EDIT.
     */
    @Override
    public TreeNode getRoot() {
        return root;
    }
}
