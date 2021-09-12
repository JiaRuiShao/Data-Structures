package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
};*/

public class LevelAverage {

    /**
     * Time: O(N)
     * Space: O(N/2) = O(N).
     * The max size for the queue is O(N/2 + 1) -- when to store the leaf nodes, the # of leaf nodes is N/2.
     *
     * @param root the root of the given tree
     * @return the average of each level
     */
    public List<Double> getLevelAvg(TreeNode root) {
        List<Double> averages = new LinkedList<>();
        double total;
        int count;
        TreeNode temp;
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return averages;
        }
        queue.offer(root);
        queue.offer(null);
        while (queue.peek() != null) {
            total = 0;
            count = 0;
            while (queue.peek() != null) {
                temp = queue.poll();
                total += temp.val;
                count++;
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
            averages.add(total/count);
            queue.offer(queue.poll()); // indicator to tell the end of a level
            // if queue.peek() is null, then means that we already traversed all the nodes in the tree
        }
        return averages;
    }

    public static void main(String[] args) {
        LevelAverage avg = new LevelAverage();
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<Double> result = avg.getLevelAvg(root);
        System.out.print("Level averages are: " + result);
    }
}
