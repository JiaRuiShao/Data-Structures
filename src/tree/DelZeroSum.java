/*
 * Given the root of a binary tree, delete any subtrees whose nodes sum up to zero.
 */

package tree;

public class DelZeroSum {

    TreeNode root;

    /**
     * Time: O(n)
     * Spaec: O(h)
     * @param curr the tree node this stack is working on
     * @return the sum of a (sub)tree
     */
    private int deleteZeroSumSubtreeRec(TreeNode curr) {
        // base case
        if (curr == null) {
            return 0;
        }
        int left = deleteZeroSumSubtreeRec(curr.left);
        if (left == 0) {
            curr.left = null;
        }
        int right = deleteZeroSumSubtreeRec(curr.right);
        if (right == 0) {
            curr.right = null;
        }
        return left + right + curr.val;
    }


    public void deleteZeroSumSubtree() {
        if (root == null || deleteZeroSumSubtreeRec(root) == 0) {
            root = null;
            return;
        }
    }

    public static void main(String[] args) {
        DelZeroSum tree = new DelZeroSum();

        tree.root = new TreeNode(7);
        tree.root.left = new TreeNode(5);
        tree.root.right = new TreeNode(6);
        tree.root.right.left = new TreeNode(0);
        tree.root.left.left = new TreeNode(-2);
        tree.root.left.right = new TreeNode(-3);

        tree.deleteZeroSumSubtree();
        LevelOrderTraversal traverse = new LevelOrderTraversal();
        System.out.println(traverse.levelOrderTraverse3(tree.root));
    }
}
