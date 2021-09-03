package linkedlist;

class ReverseK{

    private static LinkedListNode getNext(LinkedListNode curr, int reverseSize) {
        LinkedListNode temp = curr, next;
        for (int i = 0; i < reverseSize - 1; i++) {
            if (temp == null) {
                return temp;
            }
            temp = temp.next;
        }
        next = temp.next;
        return next;
    }

    private static LinkedListNode reverse(LinkedListNode curr, int reverseSize) {
        LinkedListNode temp = curr, prev = null, next = null;
        for (int i = 0; i < reverseSize; i++) {
            if (temp == null) {
                return temp;
            }
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }

        return prev;
    }

    static LinkedListNode reverseKNodes(LinkedListNode head, int k) {
        if (k <= 1 || head == null) {
            return head;
        }

        LinkedListNode curr = head, prev, reverseHead = null;
        LinkedListNode currentHead = null, currentTail, prevTail = null;
        int reverse;

        while (curr != null) {
            prev = null;
            currentTail = curr; // head

            // reverse the link
            reverse = k;
            while (curr != null && reverse > 0) { // 1
                LinkedListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;

                reverse--;
            }
            // terminate when we're reaching the end of the LinkedList or we're done reversing k nodes
            // curr now points at (nk+1) node

            currentHead = prev;
            if (reverseHead == null) {
                reverseHead = currentHead;
            }

            // connect to previous lists if there's any
            if (prevTail != null) {
                prevTail.next = currentHead;
            }
            prevTail = currentTail; // update prevTail
        }

        return reverseHead;
    }

    public static void main(String[] args) {
        int[] v1 = new int[]{1, 2, 3, 4, 5, 6, 7};
        LinkedListNode listHead = LinkedList.createLinkedList(v1);
        System.out.print("Original list: ");
        LinkedList.display(listHead);

        listHead = reverseKNodes(listHead, 4);
        System.out.print("List reversed by 4: ");
        LinkedList.display(listHead);
        System.out.println();

        int[] v2 = new int[]{1, 2, 3};
        listHead = LinkedList.createLinkedList(v2);
        System.out.print("Original list: ");
        LinkedList.display(listHead);

        listHead = reverseKNodes(listHead, 4);
        System.out.print("List reversed by 4: ");
        LinkedList.display(listHead);
    }
}
