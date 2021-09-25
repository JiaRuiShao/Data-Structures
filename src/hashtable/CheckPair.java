package hashtable;

import java.util.HashMap;
import java.util.Map;

public class CheckPair {

    /**
     * Time: O(n^2): n-1 + n-2 + ... + 1 = (n-1)n/2
     * Space: (n)
     * @param arr the given input arr
     * @return the pair of integers whose sum are the same
     */
    public String findPair(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        Map<Integer, StringBuilder> nums = new HashMap<>();
        StringBuilder result = new StringBuilder();
        StringBuilder value;
        int key = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                key = arr[i] + arr[j];
                value = new StringBuilder().append("{").append(arr[i]).append(",").append(arr[j]).append("}");
                if (nums.containsKey(key)) { // need to check if the num is duplicate in other case
                    // instantiate a map<Integer, Integer> to store sum and the 1st num
                    result.append(nums.get(key));
                    result.append(value);
                    return result.toString(); // found one pair
                } else {
                    nums.put(key, value);
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 7, 1, 12, 9};
        System.out.println(new CheckPair().findPair(arr));
    }
}
