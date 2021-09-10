package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class InorderTraverseRecursive {
    private Stack<BinaryTreeNode> stack;

    public InorderTraverseRecursive(BinaryTreeNode root) {
        stack = new Stack<>();
        inOrderTraverse(root);
    }

    private void inOrderTraverse(BinaryTreeNode curr) {
        // base case
        if (curr == null) {
            return;
        }
        // we want in-order (left, parent, right --> ascending), but because we are using stack to store the numbers,
        // the order would be reversed when we pop the elements out,
        // so here we go right first and then go left to store the elements in desc (right, parent, left --> descending)
        inOrderTraverse(curr.right);
        stack.push(curr);
        inOrderTraverse(curr.left);
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public BinaryTreeNode getNext() {
        return stack.pop();
    }

    public String inorderUsingIterator(BinaryTreeNode root) {
        InorderTraverseRecursive iter = new InorderTraverseRecursive(root);
        String result = "";
        while (iter.hasNext()) {
            result += iter.getNext().data + " ";
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> input = new ArrayList<Integer>();
        input.add(100);input.add(50);input.add(200);input.add(25);input.add(75);input.add(125);input.add(300);
        input.add(12); input.add(35); input.add(60);

        BinaryTree bt = new BinaryTree();
        BinaryTreeNode root = bt.createBST(input);
        InorderTraverseRecursive inOrderTraverse = new InorderTraverseRecursive(root);

        System.out.print("Inorder Iterator = ");
        System.out.println(inOrderTraverse.inorderUsingIterator(root));
    }
}