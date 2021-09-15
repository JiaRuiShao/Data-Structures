/*
 * In the following tree, the expected output would be (-> represents next):
 * 100 -> 55 -> 200 -> 25 -> 75 -> 150 -> 350 -> 10 -> 50 -> 80 -> 400
 *
 * 			    100
 * 			/   	   \
 * 		  55		   200
 * 	     /	\		   / \
 * 	    25	75		 150 350
 * 	   /  \   \            \
 * 	  10  50  80           400
 *
 */

package tree;

import java.io.*;

public class SerializeBT {
    private static final int MARKER = Integer.MIN_VALUE;

    public void serialize(TreeNode node, ObjectOutputStream stream) throws java.io.IOException {
        if (node == null) {
            stream.writeInt(MARKER);
            return;
        }
        // pre-order: node -> left -> right
        stream.writeInt(node.val);
        serialize(node.left, stream);
        serialize(node.right, stream);
    }

    public TreeNode deserialize(ObjectInputStream stream) throws java.io.IOException {
        int val = stream.readInt();
        if (val == MARKER) {
            return null;
        }

        TreeNode node = new TreeNode(val);
        node.left = deserialize(stream);
        node.right = deserialize(stream);
        return node;
    }

    public static void main(String[] args) throws IOException {
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

        SerializeBT binaryTree = new SerializeBT();
        try {
            ByteArrayOutputStream baostream = new ByteArrayOutputStream();
            ObjectOutputStream stream = new ObjectOutputStream(baostream);
            binaryTree.serialize(root, stream);
            stream.close();

            ByteArrayInputStream baistream = new ByteArrayInputStream(baostream.toByteArray());
            ObjectInputStream istream = new ObjectInputStream(baistream);
            TreeNode newRoot = binaryTree.deserialize(istream);

            LevelOrderTraversal traverse = new LevelOrderTraversal();
            System.out.println(traverse.levelOrderTraverse3(newRoot));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
