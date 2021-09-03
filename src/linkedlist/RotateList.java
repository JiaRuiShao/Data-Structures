package linkedlist;

class RotateList {

    private static int getLength(LinkedListNode head) {
        LinkedListNode curr = head;
        int length = 0;
        while (head != null) {
            head = head.next;
            length++;
        }
        return length;
    }

    public static LinkedListNode rotateList(LinkedListNode head, int n) {
        // corner case
        if (head == null || n == 0) {
            return head;
        }

        int skip = 0, length = getLength(head);
        if (n > 0) {
            skip = length - n % length;
        } else { // n < 0
            skip = - (n % length);
        }

        LinkedListNode newHead = null, curr = head;
        for (int i = 0; i < skip - 1; i++) {
            curr = curr.next;
        }
        newHead = curr.next;
        curr.next = null;
        curr = newHead;

        // start from new head to find the original tail
        while (curr.next != null) {
            curr = curr.next;
        }
        // terminate when newHead is the original tail
        curr.next = head;

        return newHead;
    }

    public static void main(String[] args) {
        int[] list1 = {1, 2, 3, 4, 5};
        LinkedListNode listHead = LinkedList.createLinkedList(list1);

        System.out.print("Original list: ");
        LinkedList.display(listHead);

        listHead = rotateList(listHead, 2);
        System.out.print("List rotated by 2: ");
        LinkedList.display(listHead);

        listHead = rotateList(listHead, -2);
        System.out.print("List rotated by -2: ");
        LinkedList.display(listHead);

        listHead = rotateList(listHead, -1);
        System.out.print("List rotated by -1: ");
        LinkedList.display(listHead);
    }
}
