/**
 * Given a binary tree and a number sequence, find
 * if the sequence is present as a root-to-leaf path in the given tree.
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

import java.util.Arrays;

public class PathWithGivenSequence {

    /**
     * DFS to find the given sequence.
     * Time: O(n)
     * Space: O(h)
     *
     * @param curr the curr node in stack
     * @param sequence the given sequence to find
     * @param idx the helper sequence index
     * @return true if the sequence present as a root-to-leaf path in the given tree; false if not
     */
    private boolean findPathRec(TreeNode curr, int[] sequence, int idx) {
        if (curr == null) {
            return false;
        }
        if (idx < sequence.length && curr.val == sequence[idx]) {
            ++idx;
            if (curr.left == null && curr.right == null && idx == sequence.length) {
                return true;
            }
            return findPathRec(curr.left, sequence, idx) || findPathRec(curr.right, sequence, idx);
        } else {
            return false;
        }
    }

    public boolean findPath(TreeNode root, int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return findPathRec(root, sequence, 0);
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

        PathWithGivenSequence bt = new PathWithGivenSequence();
        int[] seq = new int[]{};
        System.out.printf("For path %s: %b%n", Arrays.toString(seq), bt.findPath(root, seq));
        seq = new int[]{100, 55, 25, 50};
        System.out.printf("For path %s: %b%n", Arrays.toString(seq), bt.findPath(root, seq));
        seq = new int[]{100, 200, 150};
        System.out.printf("For path %s: %b%n", Arrays.toString(seq), bt.findPath(root, seq));
        seq = new int[]{100, 200, 350};
        System.out.printf("For path %s: %b%n", Arrays.toString(seq), bt.findPath(root, seq));
    }
}
