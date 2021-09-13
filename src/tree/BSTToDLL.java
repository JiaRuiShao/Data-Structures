/*
* Given a binary tree, convert it to a doubly linked list so that
* the order of the doubly linked list is the same as an in-order traversal of the binary tree.
* */

package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Node{
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BSTToDLL {

    Node head = null, prev= null;

    /*
    * We will modify the nodes in the binary tree in-place. After the conversion,
    * the left and right child pointers of every node will point to its predecessor and successor,
    * respectively, in the in-order traversal of the original tree.
    * Then, we will return the head node of the linked list, which should be
    * the first node in the in-order traversal of the original binary tree.
    *
    * Time: O(n)
    * Space: O(1)
    *
    * */
    public void toDoublyLinkedListRec(Node curr) {
        // base case
        if (curr == null) {
            return;
        }
        toDoublyLinkedListRec(curr.left);
        if (head == null) {
            head = curr;
        } else { // prev != null
            prev.right = curr;
            curr.left = prev;
        }
        prev = curr; // update prev to curr
        toDoublyLinkedListRec(curr.right);
    }

    /**
     * Time: O(N)
     * Space: O(H) [O(log_2(N)), O(N)]
     *
     * @param root the given tree root
     */
    public void toDoublyLinkedListItr(Node root) {
        if (root == null) {
            return;
        }
        Node curr = root, prev = null, temp;
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } // terminate the while loop when curr.left == null
            temp = stack.pop();
            if (prev == null) {
                head = temp;
            } else {
                prev.right = temp;
                temp.left = prev;
            }
            prev = temp; // update the prev
            curr = temp.right;
        } //terminate when curr == null && stack is empty
    }

    List<Integer> getList(Node head) {
        List<Integer> r = new ArrayList<Integer>();
        if (head == null) {
            return r;
        }
        Node temp = head;
        while (temp != null) {
            r.add(temp.data);
            temp = temp.right;
        }
        return r;
    }

    public static void main(String[] args) {
        Node root = new Node(100);
        root.left = new Node(55);
        root.right = new Node(200);
        root.left.left = new Node(25);
        root.left.right = new Node(75);
        root.right.right = new Node(350);
        root.left.left.left = new Node(10);
        root.left.left.right = new Node(50);

        BSTToDLL convert = new BSTToDLL();
        /*convert.toDoublyLinkedListRec(root);
        List<Integer> result1 = convert.getList(convert.head);
        System.out.println(result1);*/
        convert.toDoublyLinkedListItr(root);
        List<Integer> result2 = convert.getList(convert.head);
        System.out.println(result2);
    }
}
