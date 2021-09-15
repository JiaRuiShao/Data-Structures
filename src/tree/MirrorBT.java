/*
 * Given the root node of a binary tree, swap the ‘left’ and ‘right’ children for each node.
 * The below example shows how the mirrored binary tree should look like.
 *
 * 			    100                                     100
 * 			/   	   \                            /   	  \
 * 		  55		   200                        200		   55
 * 	     /	\		   / \           ===>         /	\		  / \
 * 	    25	75		 150 350                   350  150      75  25
 * 	   /  \   \            \                   /            /   / \
 * 	  10  50  80           400               400           80  50 10
 */

package tree;

public class MirrorBT {

    /**
     * Mirror Binary Tree using Pre-order Traversal (DFS).
     * Note: Post-order Traversal also works.
     *
     * Time: O(n)
     * Space: O(h)
     *
     * @param curr the node we're working on in stack
     */
    public void mirror(TreeNode curr) {
        // base case
        if (curr == null) {
            return;
        }

        //swap left & right child node
        TreeNode temp;
        temp = curr.left;
        curr.left = curr.right;
        curr.right = temp;

        // recursively swap until reach base case
        mirror(curr.left);
        mirror(curr.right);
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

        MirrorBT bt = new MirrorBT();
        LevelOrderTraversal traverse = new LevelOrderTraversal();
        bt.mirror(root);
        System.out.println(traverse.levelOrderTraverse3(root));
    }

}
