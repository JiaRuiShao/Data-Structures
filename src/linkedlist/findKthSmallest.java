/*
* Given ‘M’ sorted arrays, find the K’th smallest number among all the arrays.
* */

package linkedlist;

import java.util.*;

class Node {
    int arrayIndex;
    int elementIndex;
    Node(int arrayIndex, int elementIndex) {
        this.arrayIndex = arrayIndex;
        this.elementIndex = elementIndex;
    }
}

class KthSmallestInMSortedArrays {

    /**
     * Time: O(k * logM) where M is the number of the input lists
     * Space: O(M) heap size M
     *
     * @param lists the input lists
     * @param k k
     * @return the kth smallest number among all elements
     */
    public static int findKthSmallest(List<Integer[]> lists, int k) {
        PriorityQueue<Node> minHeap = new PriorityQueue<Node>(
                (n1, n2) -> (lists.get(n1.arrayIndex)[n1.elementIndex] - lists.get(n2.arrayIndex)[n2.elementIndex]));
        int result = 0, n = 0;

        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i) != null) {
                minHeap.offer(new Node(i, 0));
            }
        }

        while (!minHeap.isEmpty()) {
            Node temp = minHeap.poll();
            result = lists.get(temp.arrayIndex)[temp.elementIndex];
            if (++n == k) {
                break;
            }
            if (temp.elementIndex < lists.get(temp.arrayIndex).length) {
                temp.elementIndex++;
                minHeap.offer(temp);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Integer[] l1 = new Integer[] { 2, 6, 8 };
        Integer[] l2 = new Integer[] { 3, 6, 7 };
        Integer[] l3 = new Integer[] { 1, 3, 4 };
        List<Integer[]> lists = new ArrayList<Integer[]>();
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);
        int result = KthSmallestInMSortedArrays.findKthSmallest(lists, 5);
        System.out.print("Kth smallest number is: " + result);
    }
}
