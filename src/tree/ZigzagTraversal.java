/*
* Given a binary tree, populate an array to represent its zigzag level order traversal.
* You should populate the values of all nodes of the first level from left to right,
* then right to left for the next level and keep alternating in the same manner
* for the following levels.
* */

package tree;

import java.util.ArrayList;
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


public class ZigzagTraversal {

    private void swap(List<Integer> al, int i, int j) {
        int temp = al.get(i);
        al.set(i, al.get(j));
        al.set(j, temp);
    }

    private void reverse(List<Integer> level) {
        int start = 0, end = level.size() - 1;
        while (start < end) {
            swap(level, start, end);
            start++;
            end--;
        }
    }

    /*
    * Naive solution: traverse the nodes in level order and reverse the level of nodes if
    * it's an even level.
    * Time: O(N) + O(2^1+2^3+...+2^(H-1)) = O(N) + O(2^1+2^3+...+(N/2)) = O(N)
    * Space: O(N)
    * */
    public List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> level;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode temp;

        // corner case
        if (root == null) {
            return result;
        }
        queue.offer(root);
        queue.offer(null);
        int levelNum = 1;
        while (queue.peek() != null) {
            level = new ArrayList<>();
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
            // end of the level
            if (levelNum++ % 2 == 0) {
                reverse(level);
            }
            result.add(level);
            queue.offer(queue.poll());
        }
        return result;
    }

    public List<List<Integer>> traverseImproved(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> level;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode temp;

        // corner case
        if (root == null) {
            return result;
        }
        queue.offer(root);
        queue.offer(null);
        int levelNum = 1;
        while (queue.peek() != null) {
            level = new LinkedList<>();
            while (queue.peek() != null) {
                temp = queue.poll();
                if (levelNum % 2 == 0) {
                    level.add(0, temp.val);
                } else {
                    level.add(temp.val);
                }

                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
            // end of the level
            ++levelNum;
            result.add(level);
            queue.offer(queue.poll());
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(100);
        root.left = new TreeNode(55);
        root.right = new TreeNode(200);
        root.left.left = new TreeNode(25);
        root.left.right = new TreeNode(75);
        root.right.right = new TreeNode(350);
        root.left.left.left = new TreeNode(10);
        root.left.left.right = new TreeNode(50);

        ZigzagTraversal traverse = new ZigzagTraversal();
        List<List<Integer>> result = traverse.traverse(root);
        System.out.println("Zigzag traversal:          " + result);
        List<List<Integer>> result2 = traverse.traverseImproved(root);
        System.out.println("Zigzag traversal Improved: " + result2);
    }
}
