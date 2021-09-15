/*
 * Find the min depth of a binary tree, e.g. the tree below has minDepth of 3.
 *
 * 			    100
 * 			/   	   \
 * 		  55		   200
 * 	     /	\		   / \
 * 	    25	75		 150 350
 * 	   /  \   \            \
 * 	  10  50  80           400

 */

package tree;

import java.util.LinkedList;
import java.util.Queue;

public class MinDepth {

    /**
     * Use DFS recursively find min depth.
     *
     * @param curr the node this stack is working on
     * @return the min depth
     */
    public int findMinDepth(TreeNode curr) {
        // base case
        if (curr == null) {
            return 0;
        }
        // recursive rule
        return Math.min(findMinDepth(curr.left), findMinDepth(curr.right)) + 1;
    }

    /**
     * We could also use BFS to find the min depth.
     *
     * @param root the root of the given binary tree
     * @return the min depth
     */
    public int findMinDepthItr(TreeNode root) {
        if (root == null) {
            return  0;
        }
        int depth = 0;
        TreeNode curr;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        queue.offer(null); // as separator of levels

        while (queue.peek() != null) {
            depth++;
            while(queue.peek() != null) {
                curr = queue.poll();
                if (curr.left == null && curr.right == null) {
                    return depth;
                }
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            // end of a level
            queue.offer(queue.poll());
        }
        return depth;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(100);
        root.left = new TreeNode(55);
        root.right = new TreeNode(200);
        root.right.left = new TreeNode(150);
        root.left.left = new TreeNode(25);
        root.left.right = new TreeNode(75);
        root.right.right = new TreeNode(350);
        root.left.right.right = new TreeNode(80);
        root.left.left.left = new TreeNode(10);
        root.left.left.right = new TreeNode(50);
        root.right.right.right = new TreeNode(400);

        MinDepth bt = new MinDepth();
        System.out.printf("The min depth of this binary tree: %d%n", bt.findMinDepth(root));
        System.out.printf("The min depth of this binary tree: %d%n", bt.findMinDepthItr(root));

        LevelOrderTraversal traverse = new LevelOrderTraversal();
        System.out.println(traverse.levelOrderTraverse3(root));
    }
}
