/*
 * Find contiguous subarray with sum equal to 0.
 */

package hashtable;

import java.util.*;

class CheckSumZero {

    private void addSumArr(int[] arr, List<List<Integer>> result, int i, int j) {
        List<Integer> temp = new LinkedList<>();
        for (int k = i; k <= j; k++) {
            temp.add(arr[k]);
        }
        result.add(new LinkedList<>(temp));
    }

    /**
     * Check whether continuous elements sum to zero -- brute force
     * Time: O(n^3)
     * Space: O(n^2)
     *
     * @param arr the given integer arr
     * @return true if found; false if not
     */
    List<List<Integer>> findSubZero(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new LinkedList<>();
        int sum;
        for (int i = 0; i < arr.length; i++) { // O(n)
            sum = arr[i];
            if (sum == 0) {
                addSumArr(arr, result, i, i); // check whether this element is 0
            }
            for (int j = i + 1; j < arr.length; j++) { // O(n - 1) * O(n)
                sum += arr[j];
                // check whether the sum is zero, and if it is, add the elements to result
                if (sum == 0) {
                    addSumArr(arr, result, i, j); // O(n) * O(n - 1) * O(n)
                }
            }
        }
        return result;
    }

    /**
     * Using HashMap tp store the sum and idx.
     * When arr[i] == 0 or sum == 0 or HashMap already contains the sum
     * (means that the elements from i + 1 to i are sum to zero)
     *
     * Time: O(n^2)
     * Space: O(n + n^2) = O(n^2)
     *
     * @param arr the given arr
     * @return the contiguous elements that sum to zero
     */
    List<List<Integer>> findSubZeroImproved(int[] arr) {
        List<List<Integer>> result = new LinkedList<>();
        if (arr == null || arr.length == 0) {
            return result;
        }
        Map<Integer, Integer> mySum = new HashMap<>(); // store the sum and end idx
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (arr[i] == 0) {
                addSumArr(arr, result, i, i);
            } else if (sum == 0) {
                addSumArr(arr, result, 0, i);
            } else if (mySum.containsKey(sum)) {
                addSumArr(arr, result, mySum.get(sum) + 1, i);
            } else {
                mySum.put(sum, i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        CheckSumZero sumZero = new CheckSumZero();
        int[] arr = {0, 6, 4, -7, 3, 12, 9};
        System.out.println(sumZero.findSubZero(arr));
        System.out.println(sumZero.findSubZeroImproved(arr));
    }
}
