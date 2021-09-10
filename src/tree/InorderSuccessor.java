/*
 * Find the in-order successor of a given value “d” in a BST.
 * */

package tree;

import java.util.ArrayList;
import java.util.List;

public class InorderSuccessor {

    /**
     * Cases:
     * 1. d has not null right child, then directly return the child
     * 2. d has null right child
     * 2.1 d is the last element in the in-order traversal, return null
     * 2.2 d is not the last element in the in-order traversal, return the element that is the smallest one larger than d
     *
     * @param root the root of the BST
     * @param d    the input value
     * @return the successor of d
     */
    /*BinaryTreeNode inorderSuccessorBST(BinaryTreeNode root, int d) {
        // corner case
        if (root == null) {
            return null;
        }
        // find the node d
        BinaryTreeNode curr = root;
        BinaryTreeNode target = null;
        while (curr != null) {
            if (curr.data == d) {
                target = curr;
                break;
            } else if (curr.data < d) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        // case 1
        if (target.right != null) {
            return target.right;
        }
        // case 2
        if ()
        return null;
    }*/
    static BinaryTreeNode findMin(BinaryTreeNode root) {
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
    }

    // Test Program.
    public static void main(String[] args) {
        List<Integer> input = new ArrayList<Integer>();
        input.add(100);input.add(50);input.add(200);input.add(25);input.add(75);input.add(125);input.add(350);
        BinaryTree bt = new BinaryTree();
        BinaryTreeNode root = bt.createBST(input);
        System.out.println(InorderSuccessor.inorderSuccessorBST(root, 75).data);
    }
}
