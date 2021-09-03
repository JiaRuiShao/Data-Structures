/*
 * Given the head nodes of two linked lists that may or may not intersect,
 * find out if they intersect and return the point of intersection. Return null otherwise.
 * */

package linkedlist;

public class Intersect {

    private static int getLength(LinkedListNode head) {
        int length = 0;
        while (head != null) {
            head = head.next;
            length++;
        }
        return length;
    }

    private static LinkedListNode moveForward(LinkedListNode head, int step) {
        for (int i = 0; i < step; i++) {
            head = head.next;
        }
        return head;
    }

    /**
     * 1 - Find lengths of both linked lists: L1 and L2
     * 2  - Calculate the difference in length of both linked lists: d = |L1 - L2|
     * 3 - Move head pointer of longer list 'd' steps forward
     * 4 - Now traverse both lists, comparing nodes until we find a match or reach the end of lists
     *
     * Time: O(m + n)
     * Space: O(1)
     *
     * @param head1 head1
     * @param head2 head2
     * @return the intersection if it exist
     */
    public static LinkedListNode intersect(LinkedListNode head1, LinkedListNode head2) {
        int length1 = getLength(head1), length2 = getLength(head2);

        // move head forward Math.abs(getLength(head1) - getLength(head2)) steps
        if (length1 >= length2) {
            head1 = moveForward(head1, Math.abs(length1 - length2));
        } else {
            head2 = moveForward(head2, Math.abs(length1 - length2));
        }

        while (head1 != null && head2 != null) {
            if (head1 == head2) {
                return head1;
            }
            head1 = head1.next;
            head2 = head2.next;
        }

        return null;
    }
}
