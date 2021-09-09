/*
*  Implement a method to find the next greater element after any given element from the stack.
* */

package stackqueue;

import java.util.*;

class NextGreaterChallenge {

    /**
     * Time: O(n)
     * Space: o(n) worst case when the arr is in ascending order
     *
     * @param arr the input array
     * @return the next greater elements
     */
    public static int[] nextGreaterElement(int[] arr) {
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        // loop from right to left to keep track of the next element that is larger than arr[i]
        for (int i = arr.length - 1; i >= 0; i--) {
            // while loop to pop all previous elements that are less than the current element
            // e.g. arr = {25, 1, 2, 3, 4} when i = 0, we need to pop all the elements to get the correct result
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 3, 2, 1}; // 4 pops
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(nextGreaterElement(arr)));
        System.out.println();

        arr = new int[]{10, 1, 2, 3, 4}; // 4 pops
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(nextGreaterElement(arr)));
        System.out.println();
    }
}