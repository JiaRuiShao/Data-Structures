/*
 * Given the root to a binary tree where each node has an additional pointer called sibling (or next),
 * connect the sibling pointer to the next node in the same level. The last node in each level should
 * point to the first node of the next level in the tree.
 *
 * In the following tree, the expected output would be (-> represents next):
 * 100 -> 5 -> 200 -> 25 -> 75 -> 150 -> 350 -> 10 -> 50 -> 80 -> 400
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

import java.util.LinkedList;
import java.util.Queue;

public class ConnectSiblings {

    /**
     * Use exact approach in level-order traversal.
     * Time: O(n)
     * Space: O(n)
     *
     * @param root the given tree root
     */
    public void connect(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode curr, prev = null;
        queue.offer(root);
        queue.offer(null); // as separator betw diff levels
        while (queue.peek() != null) {
            while (queue.peek() != null) {
                curr = queue.poll();
                if (prev != null) {
                    prev.next = curr;
                }
                prev = curr; // update prev
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            queue.offer(queue.poll());
        }
    }

    /**
     * Use two pointers to traverse the level-order nodes with next.
     * Time: O(n)
     * Space: O(1)
     *
     * Initially set both current and last as 'root'
     * while current node is not null
     *   - If current node has a left child, append this left node to the last and make it last node.
     *   - If current node has a right child, append this right node to the last and make it last node.
     *   - update current node to current's next node
     *
     * @param root the given input tree root
     */
    public void connectImproved(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode curr = root, last = root;
        while (curr != null) {
            if (curr.left != null) {
                last.next = curr.left;
                last = last.next;
            }
            if (curr.right != null) {
                last.next = curr.right;
                last = last.next;
            }
            curr = curr.next;
        }
    }

    public void printNext(TreeNode root) {
        if (root == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        TreeNode curr = root;
        while (curr != null) {
            sb.append(curr.val).append(" ");
            curr = curr.next;
        }
        System.out.println(sb.toString().trim());
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

        ConnectSiblings siblings = new ConnectSiblings();
        // siblings.connect(root);
        siblings.connectImproved(root);
        siblings.printNext(root);
    }
}
