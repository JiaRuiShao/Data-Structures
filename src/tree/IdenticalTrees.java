package tree;

import java.util.ArrayList;
import java.util.List;

class IdenticalTrees {

    public static boolean areIdentical(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 == null || root2 == null) {
            return false;
        }
        return areIdentical(root1.left, root2.left) && areIdentical(root1.right, root2.right);
    }

    public static void main(String[] argv) {

        BinaryTree bt1 = new BinaryTree();
        List<Integer> input1 = new ArrayList<Integer>();
        input1.add(100);
        input1.add(50);
        input1.add(200);
        input1.add(25);
        input1.add(125);
        input1.add(250);
        BinaryTreeNode root1 = bt1.createBST(input1);

        BinaryTree bt2 = new BinaryTree();
        List<Integer> input2 = new ArrayList<Integer>();
        input2.add(1);
        input2.add(2);
        input2.add(10);
        input2.add(50);
        input2.add(180);
        input2.add(199);
        BinaryTreeNode root2 = bt2.createBST(input2);

        bt1.traverse();
        bt2.traverse();
        System.out.println();
        if (areIdentical(root1, root2)) {
            System.out.println("The trees are identical");
        } else {
            System.out.println("The trees are not identical");
        }
    }
}
