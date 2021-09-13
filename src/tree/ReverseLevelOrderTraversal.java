package tree;

import java.util.*;

/*class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
};*/

public class ReverseLevelOrderTraversal {

    /**
     * Time: O(N)
     * Space: O(N/2) = O(N).
     * The max size for the queue is O(N/2 + 1) -- when to store the leaf nodes, the # of leaf nodes is N/2.
     *
     * @param root the root of the given tree
     * @return reversed BFS as List
     */
    public List<List<Integer>> levelTraverseReversed(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        List<Integer> level;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode temp;

        if (root == null) {
            return result;
        }

        queue.offer(root);
        queue.offer(null);

        while (queue.peek() != null) {
            level = new LinkedList<>();
            while (queue.peek() != null) {
                temp = queue.poll();
                level.add(temp.val);
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
            result.add(0, level); // addFirst
            queue.offer(queue.poll());
        }
        return result;
    }

    public static void main(String[] args) {
        ReverseLevelOrderTraversal reversedLevelOrder = new ReverseLevelOrderTraversal();
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<List<Integer>> result = reversedLevelOrder.levelTraverseReversed(root);
        System.out.println("Reverse level order traversal: " + result);
    }

}
