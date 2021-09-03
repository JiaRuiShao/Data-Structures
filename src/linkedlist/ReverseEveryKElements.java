package linkedlist;

class ListNode {
    int value = 0;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }
}

class ReverseEveryKElements {

    public static ListNode reverse(ListNode head, int k) {

        // corner case
        if (head == null || k <= 1) {
            return head;
        }

        ListNode curr = head, prevTail = null, reverseStart = null, reverseEnd = null, temp;

        while (curr != null) {
            ListNode prev = null;
            // ** IMPORTANT: declare and initialize prev within the while loop so that
            // every reverseEnd.next is null
            for (int i = 1; curr != null && i <= k; i++) {
                // record the two node where
                if (i == 1) {
                    reverseEnd = curr;
                }
                // reverse
                temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            // connect the current start with the previous tail & update previous tail to current end
            reverseStart = prev;
            if (prevTail == null) {
                head = reverseStart;
            } else {
                prevTail.next = reverseStart;
            }

            prevTail = reverseEnd;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        ListNode result = ReverseEveryKElements.reverse(head, 3);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}