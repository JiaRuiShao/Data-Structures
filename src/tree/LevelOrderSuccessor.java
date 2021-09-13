package tree;

import java.util.LinkedList;
import java.util.Queue;/*class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
};*/

class LevelOrderSuccessor {

    /**
     * Time: O(N)
     * Space: O(N/2) = O(N).
     * The max size for the queue is O(N/2 + 1) -- when to store the leaf nodes, the # of leaf nodes is N/2.
     *
     * @param root the root of the given tree
     * @param key the given target
     * @return the next level node of the target
     */
    public TreeNode findSuccessor(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode temp, prev = null;
        queue.offer(root);
        queue.offer(null);
        while (queue.peek() != null) {
            while (queue.peek() != null) {
                temp = queue.poll();
                if (prev!= null && prev.val == key) {
                    return temp;
                }
                prev = temp; // update prev
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
            queue.offer(queue.poll());
        }
        return null; // didn't find the key
    }

    /**
     * Didn't use the prev TreeNode in this method.
     * Time: O(N)
     * Space: O(N/2) = O(N).
     * The max size for the queue is O(N/2 + 1) -- when to store the leaf nodes, the # of leaf nodes is N/2.
     *
     * @param root the root of the given tree
     * @param key the given target
     * @return the next level node of the target
     */
    public TreeNode findSuccessorImproved(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode temp;
        queue.offer(root);
        queue.offer(null);
        while (queue.peek() != null) {
            while (queue.peek() != null) {
                temp = queue.poll();
                if (temp.val == key) {
                    return queue.peek();
                }
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
            queue.offer(queue.poll());
        }
        return null; // didn't find the key
    }

    public static void main(String[] args) {
        LevelOrderSuccessor successor = new LevelOrderSuccessor();
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        TreeNode result = successor.findSuccessor(root, 12);
        if (result != null) System.out.println(result.val + " ");
        result = successor.findSuccessor(root, 9);
        if (result != null) System.out.println(result.val + " ");
    }
}

