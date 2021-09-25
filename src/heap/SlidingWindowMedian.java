package heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class SlidingWindowMedian {
    // solution 1- hashtable
    // solution 2- use two heaps
    Queue<Integer> minHeap; // store the larger half numbers in the minHeap
    Queue<Integer> maxHeap; // store the smaller half numbers in the maxHeap

    private void balanceHeap() {
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        } else if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public void insertNum(int num) {
        if (maxHeap.isEmpty()) {
            maxHeap.offer(num);
        } else if (num <= maxHeap.peek()) {
            maxHeap.offer(num);
        } else { // num > maxHeap.peek()
            minHeap.offer(num);
        }
        // make sure the size of minHeap & maxHeap differ by at most 1
        balanceHeap();
    }

    public double findMedian() {
        if (minHeap.isEmpty() && maxHeap.isEmpty()) {
            return -1;
        }
        if (maxHeap.size() == minHeap.size()) {
            return ((double) maxHeap.peek() + (double) minHeap.peek()) / 2;
        } else { // maxHeap.size() = minHeap.size() + 1
            return (double) maxHeap.peek();
        }
    }

    /**
     * Time: O(nlogK)
     * Space: O(k)
     *
     * @param nums the input arr
     * @param k the nums to calculate the median
     * @return the median arr
     */
    public double[] findSlidingWindowMedian(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        if (nums == null || nums.length == 0 || k > nums.length || k < 1) {
            return result;
        }

        int start = 0, end = 0;
        minHeap = new PriorityQueue<>(k / 2 + 1); // initialize minHeap
        maxHeap = new PriorityQueue<>(k / 2 + 1, (a, b) -> (b.compareTo(a)));  // initialize maxHeap

        while (end < nums.length) { // O(n)
            insertNum(nums[end++]); // O(logk) * O(n)
            if (end - start + 1 > k) { // O(n - k + 1)
                // store the median in the result
                result[start] = findMedian(); // O(1)  * O(n - k + 1)
                if (nums[start] <= maxHeap.peek()) { // O(1)  * O(n - k + 1)
                    maxHeap.remove(nums[start++]); // O(logk) * O(n - k + 1)
                } else {
                    minHeap.remove(nums[start++]); // O(logk) * O(n - k + 1)
                }
                balanceHeap();  // O(1)  * O(n - k + 1)
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SlidingWindowMedian slidingWindowMedian = new SlidingWindowMedian();
        double[] result = slidingWindowMedian.findSlidingWindowMedian(new int[]{1, 2, -1, 3, 5}, 2);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
            System.out.print(num + " ");
        System.out.println();

        slidingWindowMedian = new SlidingWindowMedian();
        result = slidingWindowMedian.findSlidingWindowMedian(new int[]{1, 2, -1, 3, 5}, 3);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
            System.out.print(num + " ");
    }
}
