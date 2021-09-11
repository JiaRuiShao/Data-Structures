package tree;

import java.util.ArrayList;
import java.util.List;

public class PreOrderTraversal {

    private void preOrderTraverseRecursive(BinaryTreeNode curr, StringBuilder sb) {
        // base case
        if (curr == null) {
            return;
        }
        // pre-order: node << leftChild << rightChild
        sb.append(curr.data).append(" ");
        preOrderTraverseRecursive(curr.left, sb);
        preOrderTraverseRecursive(curr.right, sb);
    }

    public String preOrderTraverse(BinaryTreeNode root) {
        StringBuilder sb = new StringBuilder();
        // corner case
        if (root != null) {
            preOrderTraverseRecursive(root, sb);
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>();
        input.add(100);input.add(50);input.add(200);input.add(25);input.add(75);input.add(350);

        BinaryTree bt = new BinaryTree();
        PreOrderTraversal traverse = new PreOrderTraversal();

        BinaryTreeNode root = bt.createBST(input);
        System.out.println("Level Order Traversal:");
        System.out.println(traverse.preOrderTraverse(root));
    }
}
