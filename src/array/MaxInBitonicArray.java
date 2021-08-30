/*
 * Find the maximum value in a given Bitonic array.
 * An array is considered bitonic if it is monotonically increasing and then monotonically decreasing.
 * Monotonically increasing or decreasing means that for any index i in the array arr[i] != arr[i+1].
 *
 * */


package array;

public class MaxInBitonicArray {

    /**
     * Time: O(N)
     * Space: O(1)
     *
     * @param arr the input array
     * @return the max num in the array
     */
    public static int findMax(int[] arr) {
        // corner case
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int maxNum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxNum = Math.max(maxNum, arr[i]);
            if (arr[i] < arr[i - 1]) {
                break;
            }
        }
        return maxNum;
    }

    /**
     * A bitonic array is a sorted array; the only difference is that
     * its first part is sorted in ascending order and the second part is sorted in descending order.
     *
     * Since no two consecutive numbers are same (as the array is monotonically increasing or decreasing),
     * whenever we calculate the middle, we can compare the numbers pointed out by the index middle and middle+1
     * to find if we are in the ascending or the descending part.
     *
     * Time: O(logN)
     * Space: O(1)
     *
     * @param arr the input array
     * @return the max num in the array
     */
    public static int findMaxBS(int[] arr) {
        // corner case
        if (arr == null || arr.length == 0) {
            return -1;
        }

        // use binary search to find the largest num
        int left = 0, right = arr.length - 1, middle;
        while (left < right) {
            middle = left + (right - left) / 2;
            if (arr[middle] < arr[middle + 1]) { // in the first (ascending) part of the bitonic array
                left = middle + 1;
            } else { // in the second (descending) part of the bitonic array
                right = middle;
            }
        }
        return arr[left]; // left == right
    }

    public static void main(String[] args) {
        System.out.println(MaxInBitonicArray.findMaxBS(new int[]{1, 3, 8, 12, 4, 2}));
        System.out.println(MaxInBitonicArray.findMaxBS(new int[]{3, 8, 3, 1}));
        System.out.println(MaxInBitonicArray.findMaxBS(new int[]{1, 3, 8, 12}));
        System.out.println(MaxInBitonicArray.findMaxBS(new int[]{10, 9, 8}));
    }
}
