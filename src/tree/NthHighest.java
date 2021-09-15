/*
 * 			    100
 * 			/   	   \
 * 		  55		   200
 * 	     /	\		   / \
 * 	    25	75		 150 350
 * 	   /  \   \            \
 * 	  10  50  80           400
 */

package tree;

public class NthHighest {
    public int currentCount = 0;

    /**
     * A helper function to traverse the tree in reverse in-order DFS.
     * Time: O(n)
     * Space: O(h) # call-stacks
     *
     * @param node the tree node in the stack we're currently working on
     * @param sb teh StringBuilder to store the result
     */
    private void reverseInOrderTraversal(TreeNode node, StringBuilder sb) {
        // base case
        if (node == null || currentCount <= 0) {
            return;
        }
        // recursive rules
        // reverse in-order traverse: right -> node -> left
        reverseInOrderTraversal(node.right, sb);
        if (currentCount > 0) {
            sb.append(node.val).append(" ");
            currentCount--;
        }
        reverseInOrderTraversal(node.left, sb);
    }

    /**
     * DFS. Reverse in-order traversal.
     *
     * @param root the given BST root
     * @param n num of returned node value
     * @return the largest n nodes value
     */
    public String findNthHighestInBST(TreeNode root, int n) {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            return sb.toString();
        }
        currentCount = n;
        reverseInOrderTraversal(root, sb);
        return sb.toString().trim();
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

        NthHighest bst = new NthHighest();
        System.out.println(bst.findNthHighestInBST(root, 6));
    }
}
