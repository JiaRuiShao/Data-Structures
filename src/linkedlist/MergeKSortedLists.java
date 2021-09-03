package linkedlist;

import java.util.PriorityQueue;/*class ListNode {
    int value;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }
}*/

class MergeKSortedLists {

    /**
     * Time: O(N * logK) where N is the total number of elements in k lists
     * Space: O(K) -- heap size is k
     *
     * @param lists input linked list heads
     * @return the head of the result sorted list
     */
    public static ListNode merge(ListNode[] lists) {
        ListNode result = null;
        // corner case
        if (lists == null || lists.length == 0) {
            return result;
        }

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((n1, n2) -> (n1.value - n2.value)); // k-size minHeap
        for (ListNode head : lists) {
            if (head != null) {
                minHeap.offer(head);
            }
        }

        ListNode curr = null;
        while (!minHeap.isEmpty()) { // O(N)
            ListNode node = minHeap.poll(); // O(logk)
            if (result == null) {
                result = node;
                curr = result;
            } else {
                curr.next = node;
                curr = curr.next;
            }
            if (node.next != null) {
                minHeap.offer(node.next);  // O(logk)
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(6);
        l1.next.next = new ListNode(8);

        ListNode l2 = new ListNode(3);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(7);

        ListNode l3 = new ListNode(1);
        l3.next = new ListNode(3);
        l3.next.next = new ListNode(4);

        ListNode result = MergeKSortedLists.merge(new ListNode[] { l1, l2, l3 });
        System.out.print("Here are the elements form the merged list: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}

