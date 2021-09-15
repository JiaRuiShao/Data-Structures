/*
 * Given a binary tree and a number ‘S’,
 * find all paths from root-to-leaf such that
 * the sum of all the node values of each path equals ‘S’.
 */

package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AllPathForSum {

    /**
     * A private helper recursive function.
     * Time: O(n) + O(n/2 * h) = O(nh) ~[nlogn, n^2] where n/2 is the max num of new ArrayList<>(temp) we need to call when
     * the tree is a perfect binary tree and all the path have sum of the target.
     * Space: O(h) ~ [logn, n] b/c temp max size is the maxHeight of the tree
     */
    private void getSum(TreeNode curr, int target, List<List<Integer>> result, List<Integer> temp) {
        // base case```
        if (curr == null) {
            return;
        }
        // pre-order traversal: node -> left -> right
        target -= curr.val;
        temp.add(curr.val);

        // base case
        if (target == 0 && curr.left == null && curr.right == null) {
            result.add(new ArrayList<>(temp)); // o(h)
            // ** Notice here we couldn't just add the temp into the result
            // b/c later when we remove val from the temp, the result will be modified as well **
        } else {
            // recursive rules
            getSum(curr.left, target, result, temp);
            getSum(curr.right, target, result, temp);
        }

        temp.remove(temp.size() - 1); // remove the last node val from the temp
    }

    public List<List<Integer>> findAllPathOfASum (TreeNode root, int target) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> temp  = new LinkedList<>();
        getSum(root, target, result, temp);
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);

        AllPathForSum bt = new AllPathForSum();
        int sum = 23;
        List<List<Integer>> result = bt.findAllPathOfASum(root, sum);
        System.out.println("Tree paths with sum " + sum + ": " + result);
    }
}
