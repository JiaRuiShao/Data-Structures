package hashtable;

import java.util.HashSet;
import java.util.Set;

public class CheckDisjoint {

    /**
     * Check if the given Arrays are Disjoint (assume all elements are unique in a arr)
     * Time: O(m + n) where m is the length of arr1, and n is the length of arr2
     * Space: O(n) if n is < m
     *
     * @param arr1 arr1
     * @param arr2 arr2
     * @return true if arr2 is a subset of arr1
     */
    public boolean isDisjoint(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null) {
            return false;
        }
        Set<Integer> numbers = new HashSet<>();
        // add all elements in the smaller arr into the hashmap
        for (int n : arr2) {
            numbers.add(n);
        }
        // check whether the elements are in the longer arr
        for (int m : arr1) {
            if (numbers.contains(m)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CheckDisjoint hashset = new CheckDisjoint();
        int[] arr1 = {9, 4, 3, 1, -2, 6, 5};
        int[] arr2 = {7, 10, 8};
        int[] arr3 = {1, 12};
        System.out.println(hashset.isDisjoint(arr1, arr2));
        System.out.println(hashset.isDisjoint(arr1, arr3));
    }
}
