package heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class FindMedian {
    Queue<Integer> minHeap = new PriorityQueue<>(); // store the larger half numbers in the minHeap
    Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b.compareTo(a))); // store the smaller half numbers in the maxHeap
    // solution 1 - in-place sorting first, then find the median

    // solution 2 - insertion sort

    // solution 3 - two heaps

    /**
     * 1. We can store the first half of numbers (i.e., smallNumList) in a Max Heap.
     *    We should use a Max Heap as we are interested in knowing the largest number in the first half.
     * 2. We can store the second half of numbers (i.e., largeNumList) in a Min Heap,
     *    as we are interested in knowing the smallest number in the second half.
     * 3. Inserting a number in a heap will take O(logN), which is better than the brute force approach
     *    (O(n) for insertionSort, and O(nlogn) for mergeSort).
     *
     * @param num the num to be inserted
     */
    public void insertNum(int num) {
        if (maxHeap.isEmpty()) {
            maxHeap.offer(num);
        } else if (num <= maxHeap.peek()) {
            maxHeap.offer(num);
        } else { // num > maxHeap.peek()
            minHeap.offer(num);
        }
        // make sure the size of minHeap & maxHeap differ by at most 1
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        } else if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
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

    public static void main(String[] args) {
        FindMedian medianOfAStream = new FindMedian();
        medianOfAStream.insertNum(3);
        medianOfAStream.insertNum(1);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(5);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(4);
        System.out.println("The median is: " + medianOfAStream.findMedian());
    }
}
