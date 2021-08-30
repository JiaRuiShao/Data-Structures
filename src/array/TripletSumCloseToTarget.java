/*
 * Given an array of unsorted numbers and a target number, find a triplet in the array whose sum
 * is as close to the target number as possible, return the sum of the triplet.
 * If there are more than one such triplet, return the sum of the triplet with the smallest sum.
 *
 * Input: [-2, 0, 1, 2], target=2
 * Output: 1 (The triplet [-2, 1, 2] has the closest sum to the target)
 *
 * */

package array;

import java.util.Arrays;

public class TripletSumCloseToTarget {

    /**
     * Time: O(NlogN + N^2) = O(N^2)
     * Space: O(N + 1) = O(N)
     *
     * @param arr the input array
     * @param targetSum the target sum
     * @return the smallest sum of the triplets who has the smallest diff w/ the target sum
     */
    public static int searchTriplet(int[] arr, int targetSum) {
        // corner case
        if (arr == null || arr.length == 0) {
            return -1;
        }

        Arrays.sort(arr);
        int left, right, sum = Integer.MAX_VALUE, absDiff = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            left = i + 1;
            right = arr.length - 1;
            while (left < right) {
                // record the possible smallest target sum
                if (Math.abs(arr[left] + arr[right] + arr[i] - targetSum) < absDiff) {
                    absDiff = Math.abs(arr[left] + arr[right] + arr[i] - targetSum);
                    sum = arr[left] + arr[right] + arr[i];
                }
                if (Math.abs(arr[left] + arr[right] + arr[i] - targetSum) == absDiff && arr[left] + arr[right] + arr[i] < sum) {
                    sum = arr[left] + arr[right] + arr[i];
                }
                // two pointers
                if (arr[left] + arr[right] + arr[i] < targetSum) {
                    left++;
                } else if (arr[left] + arr[right] + arr[i] > targetSum) {
                    right--;
                } else {
                    return targetSum;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(searchTriplet(new int[]{-2, 0, 1, 2}, 2));
        System.out.println(searchTriplet(new int[]{-3, -1, 1, 2}, 1));
        System.out.println(searchTriplet(new int[]{1, 0, 1, 1}, 100));
    }
}
