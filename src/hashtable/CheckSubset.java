/*
 * Find whether an array is a subset of another array.
 */
package hashtable;

// HashSet   =>  HashSet<Integer> hSet = new HashSet<>();
// HashMap   =>  HashMap<Integer,String> hMap = new HashMap<>();
// HashTable =>  Hashtable<Integer,String> hTable = new Hashtable<>();
// HashSet Functions => {add(), remove(), contains()}
// HashMap and HashTable Functions => {put(key,value), get(key), remove(key), containsKey(key), containsValue(value)}

import java.util.HashMap;
import java.util.Map;

class CheckSubset {

    /**
     * Check whether arr2 is a subset of arr1. Could use queue is order matters.
     * Time: O(m+n) where m is the num of elements of the arr1, and the n is the num of elements in arr2
     * Space: O(n)
     *
     * @param arr1 arr1
     * @param arr2 arr2
     * @return true if arr2 is a subset of arr1; false if not
     */
    public boolean isSubset(int[] arr1, int[] arr2) {
        if (arr2 == null || arr1 == null || arr2.length > arr1.length) {
            return false;
        }
        Map<Integer, Integer> nums = new HashMap<>();
        // add all int in arr2 to the hashmap
        for (int ele : arr2) {
            nums.put(ele, nums.getOrDefault(ele, 0) + 1);
        }
        // check whether arr1 contains these nums or not
        for (int ele : arr1) {
            if (nums.get(ele) != null) {
                nums.put(ele, nums.get(ele) - 1);
                if (nums.get(ele) == 0) {
                    nums.remove(ele);
                }
            }
        }
        return nums.isEmpty();
    }

    public static void main(String[] args) {
        CheckSubset subset = new CheckSubset();
        int[] arr1 = {9, 4, 7, 1, -2, 6, 5};
        int[] arr2 = {7, 1, -2};
        int[] arr3 = {10, 12};

        System.out.println(subset.isSubset(arr1, arr2));
        System.out.println(subset.isSubset(arr1, arr3));
    }
}