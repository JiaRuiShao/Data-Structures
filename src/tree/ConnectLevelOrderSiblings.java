/*
* Given a binary tree, connect each node with its level order successor.
* The last node of each level should point to a null node.
* */

package tree;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode next;

    TreeNode(int x) {
        val = x;
        left = right = next = null;
    }

    // level order traversal using 'next' pointer
    void printLevelOrder() {
        TreeNode nextLevelRoot = this;
        while (nextLevelRoot != null) {
            TreeNode current = nextLevelRoot;
            nextLevelRoot = null;
            while (current != null) {
                System.out.print(current.val + " ");
                if (nextLevelRoot == null) {
                    if (current.left != null)
                        nextLevelRoot = current.left;
                    else if (current.right != null)
                        nextLevelRoot = current.right;
                }
                current = current.next;
            }
            System.out.println();
        }
    }
};

public class ConnectLevelOrderSiblings {

    /**
     * Time: O(N)
     * Space: O(N/2) = O(N).
     * The max size for the queue is O(N/2 + 1) -- when to store the leaf nodes, the # of leaf nodes is N/2.
     *
     * @param root the root of the given tree
     */
    public void connectLevelOrderSuccessor(TreeNode root) {
        TreeNode curr, prev;
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return;
        }
        queue.offer(root);
        queue.offer(null);
        while(queue.peek() != null) {
            prev = null;
            while(queue.peek() != null) {
                curr = queue.poll();
                if (prev != null) {
                    prev.next = curr;
                }
                prev = curr; // update prev
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            } // terminate this inner while loop when the next element is null
            queue.offer(queue.poll());
        }
    }

    public static void main(String[] args) {
        ConnectLevelOrderSiblings connect = new ConnectLevelOrderSiblings();
        TreeNode root = new TreeNode(100);
        root.left = new TreeNode(55);
        root.right = new TreeNode(200);
        root.left.left = new TreeNode(25);
        root.left.right = new TreeNode(75);
        root.right.right = new TreeNode(350);
        root.left.left.left = new TreeNode(10);
        root.left.left.right = new TreeNode(50);

        connect.connectLevelOrderSuccessor(root);
        System.out.println("Level order traversal using 'next' pointer: ");
        root.printLevelOrder();
    }

}
