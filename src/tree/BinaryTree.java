package tree;
import java.util.List;

class BinaryTreeNode {
    Integer data;
    BinaryTreeNode left;
    BinaryTreeNode right;

    BinaryTreeNode(Integer data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class BinaryTree {
    private BinaryTreeNode root;

    BinaryTree() {
        root = null;
    }

    public void insert(Integer key) {
        BinaryTreeNode newNode = new BinaryTreeNode(key);
        // empty tree
        if (root == null) {
            root = newNode;
            return;
        }

        BinaryTreeNode parent = root;
        BinaryTreeNode curr = root;
        while (true) {
            // no duplicates allowed
            if (curr.data == key) {
                return;
            }
            parent = curr;
            if (curr.data < key) {
                // go right
                curr = curr.right;
                if (curr == null) {
                    // found a spot
                    parent.right = newNode;
                    return;
                }
            } else {
                // go left
                curr = curr.left;
                if (curr == null) {
                    // found a spot
                    parent.left = newNode;
                    return;
                }
            } // end of if-else to go right or left
        } // end of while
    } // end of insert method

    public BinaryTreeNode createBST(List<Integer> ll) {
        if (ll == null || ll.size() == 0) {
            return null;
        }
        for (Integer num : ll) {
            insert(num);
        }
        return root;
    }

    public void traverse() {
        System.out.println();
        traverseHelper(root);
    }

    /**
     * A recursive traverse function.
     * Time Complexity: O(n)
     *  - in-order
     *  - pre-order
     *  - post-order
     */
    private void traverseHelper(BinaryTreeNode toVisit) {
        if (toVisit != null) {
            // 1) in-order traversal: left child < parent < right child
            traverseHelper(toVisit.left);
            System.out.printf("%d ", toVisit.data);
            traverseHelper(toVisit.right);

            // 2) pre-order traversal: parent < left child < right child
            /*System.out.println(toVisit);
            traverseHelper(toVisit.left);
            traverseHelper(toVisit.right);*/

            // 2) post-order traversal: left child < right child < parent
            /*System.out.println(toVisit);
            traverseHelper(toVisit.left);
            traverseHelper(toVisit.right);*/
        }
    }
}
