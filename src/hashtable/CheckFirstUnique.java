package hashtable;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class CheckFirstUnique {

    /**
     * Time: O(n)
     * Space: O(n)
     *
     * @param arr the input arr
     * @return the first element that is unique in the array
     */
    public Integer findFirstUnique(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        Map<Integer, Integer> occurrence = new LinkedHashMap<>();
        // add all elements in to the LLHashMap
        for (int num : arr) {
            occurrence.put(num, occurrence.getOrDefault(num, 0) + 1);
        }
        // traverse the LLHashMap to find the first num with one value(occurrence)
        for (Map.Entry<Integer, Integer> entry : occurrence.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        CheckFirstUnique checkUnique = new CheckFirstUnique();
        int[] arr = {2, 54, 7, 2, 6, 54};
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.printf("First Unique in an Array: %d%n", checkUnique.findFirstUnique(arr));
    }
}
