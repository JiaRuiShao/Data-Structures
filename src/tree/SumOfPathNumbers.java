/*
 * Given a binary tree where each node can only have a digit (0-9) value,
 * each root-to-leaf path will represent a number.
 * Find the total sum of all the numbers represented by all paths.
 */

package tree;

public class SumOfPathNumbers {

    private int getSumRec(TreeNode curr, int sum) {
        // base case
        if (curr == null) {
            return 0;
        }
        // recursive rule
        sum = sum * 10 + curr.val;
        if (curr.left == null && curr.right == null) {
            return sum;
        }
        return getSumRec(curr.left, sum) + getSumRec(curr.right, sum);
    }

    public int getSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getSumRec(root, 0);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        SumOfPathNumbers bt = new SumOfPathNumbers();
        System.out.println("Total Sum of Path Numbers: " + bt.getSum(root));
    }
}
