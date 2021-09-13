package tree;

public class BSTValid {

    /**
     * Time: O(N)
     * Space: O(h) where h is the height of the tree. it's logn if the tree is balanced; or it's n in the worst case
     *
     * @param curr the input root
     * @param prev the prev node in a in-order DFS
     * @return tree is it's a valid BST; false if not
     */
    private boolean isValid(TreeNode curr, TreeNode prev) {
        // base case
        if (curr == null) {
            return true;
        }
        if (prev != null && curr.val <= prev.val) {
            return false;
        }
        // recursive rules
        if (!isValid(curr.left, prev)) {
            return false;
        }
        prev = new TreeNode(curr.val); // update prev
        if (!isValid(curr.right, prev)) {
            return false;
        }
        return true;
    }

    public boolean isBSTValid(TreeNode root) {
        TreeNode prev = null;
        return isValid(root, prev);
    }

    /*private boolean isValid(TreeNode curr, int prev) {
        // base case
        if (curr == null) {
            return true;
        }
        if (prev != Integer.MIN_VALUE && curr.val <= prev) {
            return false;
        }
        // recursive rules
        if (!isValid(curr.left, prev)) {
            return false;
        }
        prev = curr.val; // update prev
        if (!isValid(curr.right, prev)) {
            return false;
        }
        return true;
    }

    public boolean isBSTValid(TreeNode root) {
        int prev = Integer.MIN_VALUE;
        return isValid(root, prev);
    }*/

    public static void main(String[] args) {
        BSTValid bst = new BSTValid();
        TreeNode root = new TreeNode(100);
        root.left = new TreeNode(55);
        root.right = new TreeNode(200);
        root.left.left = new TreeNode(25);
        root.left.right = new TreeNode(75);
        root.right.right = new TreeNode(350);
        root.left.left.left = new TreeNode(10);
        root.left.left.right = new TreeNode(50);

        System.out.println("Is BST valid: " + Boolean.toString(bst.isBSTValid(root)));
        // System.out.println("Is BST valid: " + String.valueOf((bst.isBSTValid(root))));

        root.left.right.left = new TreeNode(54);
        System.out.println("Is BST valid: " + Boolean.toString(bst.isBSTValid(root)));
    }

}
