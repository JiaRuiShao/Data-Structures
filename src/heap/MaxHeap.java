package heap;

import java.util.Arrays;

class MaxHeap {

    /**
     * takes the node value and compares it with the key at the parent node,
     * and swaps them if the childrenNode.key >= parentNode.key
     *
     * @param heapArray the input heap array
     * @param index the index (parent) that we're working on
     * @param heapSize array/heap size
     */
    private void maxHeapify(int[] heapArray, int index, int heapSize) {
        int largest = index;
        while (largest < heapSize / 2) {      // check parent nodes only
            int left = (2 * index) + 1;       // left child
            int right = (2 * index) + 2;      // right child

            if (left < heapSize && heapArray[left] > heapArray[index]) {
                largest = left;
            }
            if (right < heapSize && heapArray[right] > heapArray[largest]) {
                largest = right;
            }
            if (largest != index) { // swap parent with largest child
                int temp = heapArray[index];
                heapArray[index] = heapArray[largest];
                heapArray[largest] = temp;
                index = largest;
            } else
                break; // if heap property is satisfied
        } //end of while
    }

    /**
     * Take the array and starts from the last child node at the last level,
     * passes it to MaxHeapify for comparison.
     *
     * @param heapArray the input heap array
     * @param heapSize the size of the array/heap
     */
    public void buildMaxHeap(int[] heapArray, int heapSize) {
        // swap largest child to parent node
        for (int i = (heapSize - 1) / 2; i >= 0; i--) {
            maxHeapify(heapArray, i, heapSize);
        }
    }

    public static void main(String[] args) {
        int[] heapArray = {1, 4, 7, 12, 15, 14, 9, 2, 3, 16};

        System.out.println("Before heapify: " + Arrays.toString(heapArray));
        new MaxHeap().buildMaxHeap(heapArray, heapArray.length);
        System.out.println("After heapify: " + Arrays.toString(heapArray));
    }
}