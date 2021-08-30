/*
 * Given an array arr of unsorted numbers and a target sum, count all triplets in it
 * such that arr[i] + arr[j] + arr[k] < target where i, j, and k are three different indices.
 * Write a function to return the count of such triplets.
 *
 * Input: [-1, 0, 2, 3], target=3
 * Output: 2 ([-1, 0, 3], [-1, 0, 2])
 * */

package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletWithSmallerSum {

    /**
     * Time: O(NlogN + N^2) = O(N^2)
     * Space: O(N + 1) = O(N)
     *
     * @param arr the input array
     * @param target the target sum
     * @return the triplets# whose sum < the target
     */
    public static int searchTriplets(int[] arr, int target) {
        int left, right, count = 0;

        // corner case
        if (arr == null || arr.length == 0) {
            return count;
        }

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            left = i + 1;
            right = arr.length - 1;
            while (left < right) {
                if (arr[i] + arr[left] + arr[right] < target) {
                    count += right - left;
                    left++;
                } else {
                    right--;
                }
            }
        }
        return count;
    }

    /**
     * Time: O(NlogN + N^3) = O(N^3)
     * Space: O(N) ignoring the space required for the output array
     *
     * @param arr the input array
     * @param target the target sum
     * @return the triplets whose sum < the target
     */
    public static List<List<Integer>> getTriplets(int[] arr, int target) {
        // corner case
        if (arr == null || arr.length == 0) {
            return new ArrayList<>();
        }

        Arrays.sort(arr);

        List<List<Integer>> triplets = new ArrayList<>();
        int left, right;
        for (int i = 0; i < arr.length; i++) {
            left = i + 1;
            right = arr.length - 1;
            while (left < right) {
                if (arr[i] + arr[left] + arr[right] < target) {
                    for (int j = right; j > left; j--) {
                        triplets.add(Arrays.asList(arr[i], arr[left], arr[j]));
                    }
                    left++;
                } else {
                    right--;
                }
            }
        }
        return triplets;
    }

    public static void main(String[] args) {
        System.out.println(searchTriplets(new int[]{-1, 0, 2, 3}, 3));
        System.out.println(getTriplets(new int[]{-1, 0, 2, 3}, 3));
        System.out.println(searchTriplets(new int[]{-1, 4, 2, 1, 3}, 5));
        System.out.println(getTriplets(new int[]{-1, 4, 2, 1, 3}, 5));
    }
}
