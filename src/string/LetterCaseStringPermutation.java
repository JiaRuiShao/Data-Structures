/*
* Given a string, find all of its permutations preserving the character sequence but changing case.
* */

package string;

import java.util.*;

class LetterCaseStringPermutation {

    /**
     * Time: O(2^N) we have 2^N permutations at most
     * Space: O(N*2^N) for each call stack, we create three new String.
     * We have 2^N call stack, and the String length is at most N, so the space complexity is O(N*2^N)
     *
     * @param str the input String
     * @param index the index we are currently working on
     * @param permutation the temp String to store the unfinished permutation
     * @param result the permutations
     */
    private static void findPermutations(String str, int index, String permutation, List<String> result) {
        // base case
        if (permutation.length() == str.length()) {
            result.add(permutation);
            return;
        }

        // if (Character.isLetter(str.charAt(i)))
        if (str.substring(index, index+1).matches("[a-zA-Z]")) { // chars
            findPermutations(str, index + 1, permutation.concat(str.substring(index, index+1).toLowerCase()), result);
            findPermutations(str, index + 1, permutation.concat(str.substring(index, index+1).toUpperCase()), result);
        } else { // numbers
            findPermutations(str, index + 1, permutation.concat(str.substring(index, index+1)), result);
        }
    }

    public static List<String> findLetterCaseStringPermutations(String str) {
        // corner case
        if (str == null || str.length() == 0) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        findPermutations(str, 0, "", result);
        return result;
    }

    public static void main(String[] args) {
        List<String> result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ad52");
        System.out.println(" String permutations are: " + result);

        result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ab7c");
        System.out.println(" String permutations are: " + result);
    }
}

