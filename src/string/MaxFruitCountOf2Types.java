/*
* Given an array of characters where each character represents a fruit tree,
* you are given two baskets, and your goal is to put maximum number of fruits in each basket.
*
* The only restriction is that each basket can have only one type of fruit.
* You can start with any tree, but you can’t skip a tree once you have started.
* You will pick one fruit from each tree until you cannot, i.e.,
* you will stop when you have to pick from a third fruit type.
*
* Write a function to return the maximum number of fruits in both baskets.*
*
* Input: Fruit=['A', 'B', 'C', 'A', 'C']
* Output: 3
*
* */


package string;

import java.util.HashMap;
import java.util.Map;

public class MaxFruitCountOf2Types {
    /**
     * Time: O(n)
     * Space: O(1)
     *
     * @param arr the input arr
     * @return the max length
     */
    public static int findLength(char[] arr) {
        // corner case
        if (arr == null || arr.length == 0) {
            return -1;
        }
        Map<Character, Integer> map = new HashMap<>(); // size <= 3
        int start = 0, maxLength = 0;
        for (int end = 0; end < arr.length; end++) {
            map.put(arr[end], map.getOrDefault(arr[end], 0) + 1);
            while (map.size() > 2) {
                map.put(arr[start], map.get(arr[start]) - 1);
                if (map.get(arr[start]) == 0) {
                    map.remove(arr[start]);
                }
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        System.out.println(arr[start] + " " + arr[maxLength + start - 1]);
        return maxLength;
    }

    public static void main(String[] args) {
        char[] fruits = new char[]{'A','B','A','B','B','B','C','C','B','B','C'};
        System.out.println(findLength(fruits));
    }
}
