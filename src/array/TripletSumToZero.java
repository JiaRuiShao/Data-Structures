/*
 * Given an array of unsorted numbers, find all UNIQUE triplets in it that add up to zero.
 *
 * Input: [-5, 2, -1, -2, 3]
 * Output: [[-5, 2, 3], [-2, -1, 3]]
 *
 * */

package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSumToZero {

    /**
     * Time: O(NlogN + N^2) = O(N^2)
     * Space: O(N + 1) = O(N)
     *
     * @param arr the input array
     * @return unique triplets that sum upto zero
     */
    public static List<List<Integer>> searchTriplets(int[] arr) {
        List<List<Integer>> triplets = new ArrayList<>();

        // corner case
        if (arr == null || arr.length == 0) {
            return triplets;
        }

        // sort the array O(nlogn)
        Arrays.sort(arr);

        // O(N^2) to find the target nums
        for (int i = 0; i < arr.length; i++) { // O(N)
            // skip the duplicate nums
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            // use two pointers to find the nums whose sum is negative arr[i]
            int left = i + 1, right = arr.length - 1;
            while (left < right) { // O(N*N)
                if (arr[left] + arr[right] == -arr[i]) {
                    triplets.add(Arrays.asList(arr[i], arr[left++], arr[right--]));
                    // skip the duplicates
                    while (left < right && arr[left] == arr[left - 1]) {
                        left++;
                    }
                    while (left < right && arr[right] == arr[right + 1]) {
                        right--;
                    }
                } else if (arr[left] + arr[right] < -arr[i]) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return triplets;
    }

    public static void main(String[] args) {
        System.out.println(searchTriplets(new int[]{-3, 0, 1, 2, -1, 1, -2}));
        System.out.println(searchTriplets(new int[]{-5, 2, -1, -2, 3}));
    }

}
