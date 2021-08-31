/*
 * Given an array with positive numbers and a positive target number,
 * find all of its contiguous subarrays whose product is less than the target number.
 *
 * Input: [2, 5, 3, 10], target=30
 * Output: [2], [5], [2, 5], [3], [5, 3], [10]
 *
 * */

package array;

import java.util.ArrayList;
import java.util.List;

public class SubarrayProductLessThanK {

    /**
     * Time: O(N^2) ????O(N^3)
     * Space: O(N*N^2) = O(N^3)
     * Explanation: The worst-case will happen when every subarray has a product less than the target
     * For an array with distinct elements, finding all of its contiguous subarrays is like
     * finding the number of ways to choose two indices, i and j, in the array such that i <= j
     * - when i = 0, j can have any value from 0 to n-1, giving a total of n choices
     * - when i = 1, j can have any value from 1 to n-1, giving a total of n-1 choices
     * ...
     * - when i = n-1, j can only have 1 choice
     *
     * choices:  n + (n-1) + (n-2) + ... 3 + 2 + 1 = n∗(n+1)/2
     *
     * So, at most, we need space for O(n^2) output lists.
     * At worst, each subarray can take O(n) space, so overall, our algorithm’s space complexity will be O(n^3).
     *
     * @param arr    the input array
     * @param target the target
     * @return contiguous subarrays whose product is < the target
     */
    public static List<List<Integer>> findSubarrays(int[] arr, int target) {
        List<List<Integer>> subarray = new ArrayList<>();

        // corner case
        if (arr == null || arr.length == 0) {
            return new ArrayList<>();
        }

        int product = 1, start = 0;
        for (int end = 0; end < arr.length; end++) {
            if (arr[end] < target) {
                subarray.add(List.of(arr[end])); // Arrays.asList()
            }
            product *= arr[end];

            // shrinking the window if the product is too large
            while (start <= end && product >= target) {
                product /= arr[start++];
            }

            if (product < target && start < end) {
                List<Integer> temp = new ArrayList<>();
                for (int i = start; i <= end; i++) {
                    temp.add(arr[i]);
                }
                subarray.add(temp);
            }
        }
        return subarray;
    }

    public static void main(String[] args) {
        System.out.println(findSubarrays(new int[]{2, 5, 3, 10}, 30));
        System.out.println(findSubarrays(new int[]{8, 2, 6, 5}, 50));
    }

}
