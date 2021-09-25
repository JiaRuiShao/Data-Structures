/*
 * Find the k Smallest Elements in an Array。
 */

package heap;

import java.util.*;

public class KSmallest {

    /**
     * Time: O(klogk + nlogk)
     * Space: O(k)
     *
     * @param arr the input array
     * @param k the target num k
     * @return the int[] arr whose length is k
     */
    public int[] findKSmallest(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k < 1) {
            return new int[0];
        }
        // 1) use Collections.reverseOrder()
        Queue<Integer> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());
        // 2) use anonymous Comparator
        Queue<Integer> maxHeap2 = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer int1, Integer int2) {
                if (int1.equals(int2)) {
                    return 0;
                }
                return int2 < int1? -1:1;
            }
        });
        // 3) use lambda Comparator
        Queue<Integer> maxHeap3 = new PriorityQueue<>(k, (int1, int2) -> (int2.compareTo(int1)));
        k = Math.min(k, arr.length);
        int[] result = new int[k];

        for (int num : arr) { // O(klogk) + O(nlogk)
            if (maxHeap2.size() < k) {
                maxHeap2.offer(num);
            } else if (maxHeap2.size() == k && maxHeap2.peek() > num) {
                maxHeap2.poll();
                maxHeap2.offer(num);
            } // else do nothing: when the maxHeap size is k, and the largest num stored in the maxHeap is still < num
        }

        for (int j = k - 1; j >= 0; j--) {
            result[j] = maxHeap2.poll();
        }

        return result;
    }

    public static void main(String[] args) {
        int[] input = {9, 4, 7, 1, -2, 6, 5};
        int[] output = new KSmallest().findKSmallest(input, 2);
        System.out.println(Arrays.toString(output));
    }
}
