/*
 * Find the in-order successor of a given value “d” in a BST.
 * */

package tree;

import java.util.ArrayList;
import java.util.List;

public class InorderSuccessor {

    private BinaryTreeNode findMinLargeInRightSubTree(BinaryTreeNode curr) {
        while(curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }

    /**
     * Time: O(H)~[logN, N]
     * Space: O(1)
     *
     * Cases:
     * 1. d has not null right child, then the left most child in the right child’s subtree will be the in-order successor
     * 2. d has no right child
     * 2.1 d is the last element in the in-order traversal, return null
     * 2.2 d is not the last element in the in-order traversal, return the element that is the smallest one larger than d
     *
     * @param root the root of the BST
     * @param d    the input value
     * @return the successor of d
     */
    BinaryTreeNode inorderSuccessorBST(BinaryTreeNode root, int d) {
        // corner case
        if (root == null) {
            return null;
        }
        // find the node d
        BinaryTreeNode curr = root;
        BinaryTreeNode successor = null;

        while (curr != null) {
            if (curr.data == d) {
                // case 1
                if (curr.right != null) {
                    successor = findMinLargeInRightSubTree(curr.right);
                }
                break;
            } else if (curr.data < d) {
                curr = curr.right;
            } else {
                // here the curr.data > d, so it's a potential candidate for successor
                successor = curr;
                curr = curr.left;
            }
        }

        return successor;
    }

    /*static BinaryTreeNode findMin(BinaryTreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    static BinaryTreeNode inorderSuccessorBST(BinaryTreeNode root, int d) {

        if (root == null) {
            return null;
        }

        BinaryTreeNode successor = null;
        while (root != null) {

            if (root.data < d) {
                root = root.right;
            } else if (root.data > d) {
                successor = root;
                root = root.left;
            } else {
                if (root.right != null) {
                    successor = findMin(root.right);
                }
                break;
            }
        }
        return successor;
    }*/

    // Test Program.
    public static void main(String[] args) {
        InorderSuccessor successor = new InorderSuccessor();
        List<Integer> input = new ArrayList<Integer>();
        input.add(100);input.add(50);input.add(200);input.add(25);input.add(75);input.add(125);input.add(350);
        BinaryTree bt = new BinaryTree();
        BinaryTreeNode root = bt.createBST(input);
        System.out.println(successor.inorderSuccessorBST(root, 75).data);
    }
}
