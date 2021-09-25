package hashtable;

import java.util.*;

public class CheckSum {

    /**
     * Time: O(n)
     * Space: O(n) -- hashset
     *
     * @param arr the given integer arr
     * @param n   the target sum
     * @return the first pair of integers that sum to n
     */
    int[] findSum(int[] arr, int n) {
        int[] result = new int[2];
        if (arr == null || arr.length == 0) {
            return result;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (set.contains(n - num)) {
                result = new int[]{n - num, num};
                return result;
            } else {
                set.add(num);
            }
        }
        return result;
    }

    /**
     * Get all possible pairs whose sum is n
     * Time: O(n)
     * Space: (n) -- pair + hashset
     *
     * @param arr the given arr
     * @param n the target
     * @return integer pairs whose sum is n
     */
    List<List<Integer>> getPairsSum(int[] arr, int n) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> pair;
        if (arr == null || arr.length == 0) {
            return result;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : arr) { // O(n)
            if (set.contains(n - num)) {
                pair = new LinkedList<>();
                pair.add(n - num);
                pair.add(num);
                result.add(new LinkedList<Integer>(pair)); // O(2) * O(n) = O(n)
            } else {
                set.add(num);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 10;
        int[] arr = {2, 4, 5, 7, 8, 3, 9, 10, 1};
        System.out.printf("Pairs sum to %d: %s%n", n, Arrays.toString(new CheckSum().getPairsSum(arr, n).toArray()));
    }
}
