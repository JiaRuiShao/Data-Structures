/*
 * Convert a Max-Heap to a Min-Heap.
 */

package heap;

import java.util.Arrays;

public class ConvertHeap {

    private void checkMaxHeapProperty(int[] heap, int index) {
        while (index < heap.length / 2) {
            int maxIdx = index, max = heap[index];
            int leftChildIdx = index * 2 + 1;
            int rightChildIdx = index * 2 + 2;
            if (leftChildIdx < heap.length && heap[leftChildIdx] > max) {
                maxIdx = leftChildIdx;
                max = heap[leftChildIdx];
            }
            if (leftChildIdx < heap.length && heap[rightChildIdx] > max) {
                maxIdx = rightChildIdx;
                max = heap[rightChildIdx];
            }
            if (maxIdx != index) {
                heap[maxIdx] = heap[index];
                heap[index] = max;
                index = maxIdx;
            } else {
                break;
            }
        }
    }

    /**
     * Bottom-up.
     * the function starts from the last parent node present at the n/2th position of the array,
     * and it checks if the values at the child nodes are greater than the parent nodes.
     *
     * Time: loose upperbound O(nlogn); tight upper bound: O(n)
     * Space: O(n+logn) = O(n)
     *
     * @param heap the given input heap array
     */
    public void convertToMaxHeap(int[] heap) {
        if (heap == null || heap.length == 0) {
            return;
        }
        // check the maxHeap property for parent nodes from bottom-up
        for (int i = (heap.length - 1) / 2; i >= 0; i--) {
            checkMaxHeapProperty(heap, i);
        }
    }

    private void checkMinHeapProperty(int[] heap, int index) {
        while (index < heap.length / 2) {
            int minIdx = index, min = heap[index];
            int leftChildIdx = index * 2 + 1;
            int rightChildIdx = index * 2 + 2;
            if (leftChildIdx < heap.length && heap[leftChildIdx] < min) {
                minIdx = leftChildIdx;
                min = heap[leftChildIdx];
            }
            if (leftChildIdx < heap.length && heap[rightChildIdx] < min) {
                minIdx = rightChildIdx;
                min = heap[rightChildIdx];
            }
            if (minIdx != index) {
                heap[minIdx] = heap[index];
                heap[index] = min;
                index = minIdx;
            } else {
                break;
            }
        }
    }

    public void convertToMinHeap(int[] heap) {
        if (heap == null || heap.length == 0) {
            return;
        }
        // check the minHeap property for parent nodes from bottom-up
        for (int i = (heap.length - 1) / 2; i >= 0; i--) {
            checkMinHeapProperty(heap, i);
        }
    }

    public static void main(String[] args) {
        int[] heapArray = {9, 4, 7, 1, -2, 6, 5};
        System.out.println("Max Heap: " + Arrays.toString(heapArray));
        new ConvertHeap().convertToMinHeap(heapArray);
        System.out.println("Min Heap: " + Arrays.toString(heapArray));

        heapArray = new int[]{-2, 1, 5, 9, 4, 6, 7};
        System.out.println("Min Heap: " + Arrays.toString(heapArray));
        new ConvertHeap().convertToMaxHeap(heapArray);
        System.out.println("Max Heap: " + Arrays.toString(heapArray));
    }
}
