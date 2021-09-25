package hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class RemoveSLLDuplicates {

    /**
     * Remove the numbers that are duplicate after the first occurrence.
     * Time: O(n)
     * Space: O(n)
     *
     * @param sll the given SLL
     * @param <V> the data type
     */
    <V> void removeDup(SinglyLinkedList<V> sll) {
        SinglyLinkedList<V>.Node curr = sll.headNode;
        SinglyLinkedList<V>.Node prev = null;
        Set<V> occurrence = new HashSet<>();

        while (curr != null) {
            if (occurrence.contains(curr.data)) { // dup num, need to be removed
                prev.nextNode = curr.nextNode; // prev couldn't be null by design
                curr = curr.nextNode;
            } else { // not dup, moving two pointers forward
                occurrence.add(curr.data);
                prev = curr;
                curr = curr.nextNode;
            }
        }
    }

    /**
     * Remove all the dup elements that are not unique. no matter it's the first occurrence or not.
     * Time: O(n)
     * Space: O(n)
     *
     * @param sll the given Singly LinkedList
     * @param <V> the node data type
     */
    <V> void removeALLDup(SinglyLinkedList<V> sll) {
        SinglyLinkedList<V>.Node curr = sll.headNode;
        SinglyLinkedList<V>.Node prev = null;
        Map<V, Integer> occurrence = new HashMap<>();
        while (curr != null) {
            occurrence.put(curr.data, occurrence.getOrDefault(curr.data, 0) + 1);
            curr = curr.nextNode;
        }
        curr = sll.headNode;
        while (curr != null) {
            if (occurrence.get(curr.data) > 1) { // dup num, need to be removed
                if (prev == null) { // curr == head
                    sll.headNode = curr.nextNode;
                } else { // prev != null
                    prev.nextNode = curr.nextNode;
                }
                curr = curr.nextNode;
            } else { // not dup, moving two pointers forward
                prev = curr;
                curr = curr.nextNode;
            }
        }
    }

    public static void main(String[] args) {
        RemoveSLLDuplicates sll = new RemoveSLLDuplicates();
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        for (int i = 1; i <= 8; i++) {
            list.insertAtHead(i);
        }

        // inserting duplicates
        list.insertAtHead(2);
        list.insertAtHead(4);
        list.insertAtHead(1);

        System.out.println("List before deleting duplicates from list :");
        list.printList();
        sll.removeDup(list);
        // sll.removeALLDup(list);
        System.out.println("List after deleting duplicates from list :");
        list.printList();
    }
}
