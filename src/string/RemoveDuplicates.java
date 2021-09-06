/*
* Remove duplicate characters from a string which is passed by reference.
* */

package string;

import java.util.HashSet;

public class RemoveDuplicates {

    /**
     * Time: O(n)
     * Space: O(n) when each element in the input char arr is unique
     *
     * @param str the input char array
     */
    static void removeDuplicates(char[] str){
        if (str == null || str.length == 0) {
            return;
        }

        HashSet set = new HashSet();
        int read = 0, write = 0;
        while (read < str.length) {
            if (!set.contains(str[read])) {
                set.add(str[read]);
                str[write++] = str[read];
            }
            read++;
        }

        // fill out the elements from write to read with null
        while (write < str.length) {
            str[write++] = '\0';
        }
    }

    public static void printCharArray(char[] arr) {
        for (char c : arr) {
            if (c != '\0') {
                System.out.printf("%c", c);
            }
        }
    }

    public static void main(String[] args) {
        char[] input = "dabbac".toCharArray();
        System.out.print("Before: ");
        System.out.println(input);
        RemoveDuplicates.removeDuplicates(input);
        System.out.print("After: ");
        printCharArray(input);
    }
}
