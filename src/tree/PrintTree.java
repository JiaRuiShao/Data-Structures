/*
* Print Tree Perimeter
* Given the root node of a binary tree, print the nodes that form the boundary (perimeter).
*
* In the following tree, the highlighted nodes form the perimeter. The expected output for the below tree
* would be 100,55,25,10,50,80,150,400,350,200.
*
* 			    100
			/   	   \
		  55		   200
	     /	\		   / \
	    25	75		 150 350
	   /  \   \            \
	  10  50  80           400
* */

package tree;

import java.util.Stack;

public class PrintTree {

    /**
     * Print the left perimeter, leaf nodes and right perimeter
     *
     * @param root the given input tree root
     * @return the String that contain the tree perimeters
     */
    public String printPerimeter(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            return sb.toString();
        }
        sb.append(root.val).append(" ");
        getLeftPerimeter(root.left, sb);
        getLeafNodes(root, sb);
        getRightPerimeter(root.right, sb);
        return sb.toString();
    }

    /**
     * Private helper function.
     * Time: O(h)
     * Space: O(1)
     *
     * @param curr the input tree root
     * @param sb   the StringBuilder sued to store the perimeters
     */
    private void getLeftPerimeter(TreeNode curr, StringBuilder sb) {
        while (curr != null && curr.left != null) {
            sb.append(curr.val).append(" ");
            curr = curr.left;
        } // terminate when curr == null or curr.left == null
    }

    /**
     * Time: O(n)
     * Space: O(h)
     *
     * @param curr the input tree root
     * @param sb   the StringBuilder sued to store the perimeters
     */
    private void getLeafNodes(TreeNode curr, StringBuilder sb) {
        // base case
        if (curr == null) {
            return;
        }
        if (curr.left == null && curr.right == null) { // leaf found
            sb.append(curr.val).append(" ");
        }
        // recursive rule
        getLeafNodes(curr.left, sb);
        getLeafNodes(curr.right, sb);
    }

    /**
     * Time: O(h)
     * Space: O(h)
     *
     * @param curr the input tree root
     * @param sb   the StringBuilder sued to store the perimeters
     */
    private void getRightPerimeter(TreeNode curr, StringBuilder sb) {
        Stack<TreeNode> stack = new Stack<>();
        while (curr != null && curr.right != null) {
            stack.push(curr);
            curr = curr.right;
        } // terminate when curr == null or curr.right == null
        while (!stack.isEmpty()) {
            sb.append(stack.pop().val).append(" ");
        }
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

        PrintTree tree = new PrintTree();
        System.out.println(tree.printPerimeter(root));
    }
}
