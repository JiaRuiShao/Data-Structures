/*
 * In the following tree, the expected output would be (-> represents next):
 * 100 -> 55 -> 200 -> 25 -> 75 -> 150 -> 350 -> 10 -> 50 -> 80 -> 400
 *
 * 			    100
 * 			/   	   \
 * 		  55		   200
 * 	     /	\		   / \
 * 	    25	75		 150 350
 * 	   /  \   \            \
 * 	  10  50  80           400
 *
 */

package tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

    /**
     * Naive Solution to do the BFS.
     * 1) Find the height H of the tree (= height of the root node)
     * 2) for level h from 0...H-1, get the nodes whose level is h recursively
     *
     * Time: O(N)+O(1+2^1+...2^(H-1)) = O(N) + O(2^H) = O(N) + O(2^H - 1)
     * Space: O(N)
     *
     * @param root the root of the given tree
     * @return the BFS
     */
    public String levelOrderTraverse1(TreeNode root) {
        int height = getHeight(root);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < height; i++) {
            getResult(root, sb, i);
            sb.append("\n");
        }
        return sb.toString();
    }

    private int getHeight(TreeNode curr) {
        // base case
        if (curr == null) {
            return -1; // make sure the leaf node's height is 0
        }
        // recursive rule
        return Math.max(getHeight(curr.left), getHeight(curr.right)) + 1;
    }

    private void getResult(TreeNode curr, StringBuilder sb, int height) {
        if (curr == null || height < 0) {
            return; // base case
        } else if (height == 0) {
            sb.append(curr.val).append(" ");
        } else { // recursive rules
            getResult(curr.left, sb, height - 1);
            getResult(curr.right, sb, height - 1);
        }
    }

    /**
     * Use two queues to store the temp nodes. For queue1, we are polling all elements
     * and offering their children to the queue2 if not null.
     * Then we let queue1 point to queue2, and continue to teh next level,
     * until there's no more not null children stored in the queue2.
     *
     * Time:  O(N)
     * Space: O(2^H) where H is the height of the tree
     *        because the max size for both queues are the max# nodes at each level
     *        the worst case would be a perfect binary tree.
     *        So the max# of nodes is the leaf#, which is 2^height.
     *        If the tree is also a balanced tree, then the height is logN,
     *        and space complexity is 2^(log_2(N)) = N.
     *
     * @param root the root of the given tree
     * @return the level-order BFS result
     */
    public String levelOrderTraverse2(TreeNode root) {
        StringBuilder sb = new StringBuilder();

        if (root == null) {
            return sb.toString();
        }
        TreeNode temp = null;
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(root);
        while (!queue1.isEmpty()) {
            while (!queue1.isEmpty()) {
                temp = queue1.poll();
                sb.append(temp.val).append(" ");
                if (temp.left != null) {
                    queue2.offer(temp.left);
                }
                if (temp.right != null) {
                    queue2.offer(temp.right);
                }
            }
            sb.append("\n");
            queue1 = queue2;
            queue2 = new LinkedList<>();
        }
        return sb.toString();
    }

    /**
     * In this method, we are only using one queue to store the nodes with the help of null as the sign of next level.
     * Time: O(N)
     * Space: O(N)
     *
     * @param root the root of the given tree
     * @return the level-order BFS result
     */
    public String levelOrderTraverse3(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        // corner case
        if (root == null) {
            return sb.toString();
        }
        TreeNode temp = null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);

        while(queue.peek() != null) {
            while (queue.peek() != null) {
                temp = queue.poll();
                sb.append(temp.val).append(" ");
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            } //terminate the while loop when a level end
            sb.append("\n");
            queue.offer(queue.poll()); // poll the null and offer it back into the end of queue
        } // terminate when queue.peek() is null, means that there's only null stored in the queue
        return sb.toString();
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

        LevelOrderTraversal traverse = new LevelOrderTraversal();
        System.out.println("Level Order Traversal (naive):");
        System.out.println(traverse.levelOrderTraverse1(root));
        System.out.println();
        System.out.println("Level Order Traversal (improved):");
        System.out.println(traverse.levelOrderTraverse2(root));
        System.out.println();
        System.out.println("Level Order Traversal (improved plus):");
        System.out.println(traverse.levelOrderTraverse3(root));
    }
}
