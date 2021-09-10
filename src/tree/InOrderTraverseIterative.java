package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Time: O(N)
 * Space: O(H) where H is the height of the binary tree. It's O(logN) if the tree is a balanced tree; It's O(n) if else
 */
public class InOrderTraverseIterative {
    Stack<BinaryTreeNode> stack = new Stack<>();

    String iterativeInorder(BinaryTreeNode root) {
        BinaryTreeNode curr = root;
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty() || curr != null) {
            // go left
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            sb.append(stack.peek().data).append(" ");
            curr = stack.pop().right;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        List<Integer> input = new ArrayList<Integer>();
        input.add(100);input.add(50);input.add(200);input.add(25);input.add(75);input.add(125);input.add(350);
        BinaryTree bt = new BinaryTree();
        BinaryTreeNode root = bt.createBST(input);
        System.out.print("Inorder Iterative Traversal= ");
        InOrderTraverseIterative iterative = new InOrderTraverseIterative();
        System.out.println(iterative.iterativeInorder(root));
    }


}
