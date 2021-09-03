package linkedlist;

class AddIntegers {

    /**
     * Time: O(m + n)
     * Space: O(1)
     *
     * @param integer1 head of the first linkedlist
     * @param integer2 head of the second linkedlist
     * @return head of the linkedlist whose data stored is the sum of 1st & 2nd linkedlist
     */
    static LinkedListNode addIntegers(LinkedListNode integer1, LinkedListNode integer2) {

        LinkedListNode head = null, curr = null;
        int carry = 0;

        while (integer1 != null || integer2 != null || carry != 0) {
            int num, one, two;

            one = integer1 == null ? 0 : integer1.data;
            two = integer2 == null ? 0 : integer2.data;
            num = (one + two + carry) % 10;
            carry = (one + two + carry) / 10;

            if (head == null) {
                head = new LinkedListNode(num);
                curr = head;
            } else {
                curr.next = new LinkedListNode(num);
                curr = curr.next;
            }

            integer1 = integer1 == null ? integer1 : integer1.next;
            integer2 = integer2 == null ? integer2 : integer2.next;
        }

        return head;
    }


    public static void main(String[] args) {

        int[] v1 = new int[]{1, 0, 9, 9}; // 1099
        int[] v2 = new int[]{7, 3, 2}; // 732

        LinkedListNode first = LinkedList.createLinkedList(v1);
        LinkedListNode second = LinkedList.createLinkedList(v2);

        LinkedListNode result = addIntegers(first, second);

        System.out.println("First integer: ");
        LinkedList.display(first);
        System.out.println("Second integer: ");
        LinkedList.display(second);

        System.out.println("Result: ");
        LinkedList.display(result);
    }
}