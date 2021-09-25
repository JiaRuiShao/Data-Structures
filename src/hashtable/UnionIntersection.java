package hashtable;

import java.util.HashSet;
import java.util.Set;

public class UnionIntersection {

    private <T> void traverseSLL(SinglyLinkedList<T> result, SinglyLinkedList<T>.Node curr, Set<T> mySet) {
        while (curr != null) {
            if (!mySet.contains(curr.data)) { // new data to be added
                mySet.add(curr.data);
                result.insertAtEnd(curr.data);
            }
            curr = curr.nextNode;
        }
    }

    <T> SinglyLinkedList<T> getUnion(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
        Set<T> mySet = new HashSet<>(); // to store the unique list node values
        SinglyLinkedList<T> result = new SinglyLinkedList<>();
        SinglyLinkedList<T>.Node curr = list1.getHeadNode();
        traverseSLL(result, curr, mySet);
        curr = list2.getHeadNode();
        traverseSLL(result, curr, mySet);
        return result;
    }

    private <T> void traverseSLLIntersection(SinglyLinkedList<T> result, SinglyLinkedList<T>.Node curr, Set<T> mySet) {
        while (curr != null) {
            if (!mySet.contains(curr.data)) { // new data to be added
                mySet.add(curr.data);
            }
            curr = curr.nextNode;
        }
    }

    <T> SinglyLinkedList<T> getIntersection(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
        Set<T> set1 = new HashSet<>(); // to store the unique list node values in list1
        SinglyLinkedList<T> result = new SinglyLinkedList<>();
        SinglyLinkedList<T>.Node curr = list1.getHeadNode();
        while (curr != null) {
            if (!set1.contains(curr.data)) { // new data to be added
                set1.add(curr.data);
            }
            curr = curr.nextNode;
        }
        Set<T> set2 = new HashSet<>(); // to store the already added intersection data
        curr = list2.getHeadNode();
        while (curr != null) {
            if (set1.contains(curr.data) && !set2.contains(curr.data)) {
                result.insertAtEnd(curr.data);
                set2.add(curr.data);
            }
            curr = curr.nextNode;
        }
        return result;
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> list1 = new SinglyLinkedList<Integer>();
        for(int i=7; i>3; i--){
            list1.insertAtHead(i);
        }
        System.out.print("1st ");
        list1.printList();
        SinglyLinkedList<Integer> list2 = new SinglyLinkedList<Integer>();
        for(int i=0; i<5; i++){
            list2.insertAtHead(i);
        }
        System.out.print("2nd ");
        list2.printList();
        System.out.print("After Intersection ");
        new UnionIntersection().getIntersection(list1, list2).printList();
        System.out.print("After Union ");
        new UnionIntersection().getUnion(list1, list2).printList();
    }
}
