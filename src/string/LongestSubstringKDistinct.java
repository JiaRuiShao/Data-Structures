/*
* Given a string, find the length of the longest substring in it with no more than K distinct characters.*
* */

package string;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinct {

    /**
     * Time: O(n)
     * Space: O(K)
     *
     * @param str input String
     * @param k the input max unique number allowed
     * @return the max length of contiguous numbers
     */
    public static int findLength(String str, int k) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        Map<Character, Integer> map = new HashMap<>(); // size <= k + 1
        int start = 0, maxLength = Integer.MIN_VALUE;
        for (int end = 0; end < str.length(); end++) {
            map.put(str.charAt(end), map.getOrDefault(str.charAt(end), 0) + 1);
            while (map.size() > k) {
                map.put(str.charAt(start), map.get(str.charAt(start)) - 1);
                if (map.get(str.charAt(start)) == 0) {
                    map.remove(str.charAt(start));
                }
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 2));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 1));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("cbbebi", 3));
    }
}
