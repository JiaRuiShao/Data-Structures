package hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CheckSymmetric {

    /**
     * Find Symmetric.
     * Time: O(n)
     * Space: O(n)
     *
     * @param arr input int matrix
     * @return the first symmetric pairs.
     */
    public String findSymmetric(int[][] arr) {
        if (arr == null || arr.length == 0 || arr[0].length == 0) {
            return null;
        }
        // store the int[] in a hashmap as key-value pairs
        Map<Integer, Integer> nums = new HashMap<>();
        for (int[] intArr : arr) {
            nums.put(intArr[0], intArr[1]);
        }
        // check symmetrics
        StringBuilder sb = new StringBuilder();
        for (int[] intArr : arr) {
            if (nums.containsKey(intArr[1]) && nums.get(intArr[1]) == intArr[0]) {
                sb.append(Arrays.toString(intArr));
                nums.remove(intArr[0], intArr[1]);
            }
        }
        return sb.toString();
    }

    /**
     * Traverse given Array
     * Look for second element of each pair in the hash. i.e for pair (1,2) look for key 2 in map.
     * If found then store it in the result array, otherwise insert the pair in hash
     *
     * @param arr the input matrix
     * @return the first symmetric pairs.
     */
    public static String findSymmetricImproved(int[][] arr) {
        HashMap < Integer,Integer > hashMap = new HashMap < Integer,Integer >();
        String result = "";

        // Traverse through the given array
        for (int i = 0; i < arr.length; i++) {
            int first = arr[i][0];
            int second = arr[i][1];

            Integer value = hashMap.get(second);

            if (value != null && value == first) {
                //Symmetric Pair found
                result += "{" + String.valueOf(second) + "," + String.valueOf(first) + "}";
            }
            else
                hashMap.put(first, second);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2}, {3, 4}, {5, 9}, {4, 3}, {9, 5}};
        String symmetric = new CheckSymmetric().findSymmetric(arr);
        System.out.println(symmetric);
    }
}
