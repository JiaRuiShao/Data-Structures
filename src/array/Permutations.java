package array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Permutations {

    /**
     * Time: O(N∗N!)
     * Space: O(N∗N!)
     *
     * @param nums the input num array
     * @return the permutations
     */
    public static List<List<Integer>> findPermutationsItr(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<List<Integer>> permutations = new LinkedList<>();
        permutations.add(new ArrayList<>());
        for (int currentNumber : nums) {
            // take all existing permutations and add the current number to create new permutations
            int n = permutations.size();
            for (int i = 0; i < n; i++) {
                List<Integer> oldPermutation = permutations.poll();
                // create a new permutation by adding the current number at every position
                for (int j = 0; j <= oldPermutation.size(); j++) {
                    List<Integer> newPermutation = new ArrayList<Integer>(oldPermutation);
                    newPermutation.add(j, currentNumber);
                    if (newPermutation.size() == nums.length)
                        result.add(newPermutation);
                    else
                        permutations.add(newPermutation);
                }
            }
        }
        return result;
    }

    private static List<List<Integer>> findPermutations (int[] nums) {
        return null;
    }


    public static List<List<Integer>> findPermutationsRec(int[] nums) {
        // corner case
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> results = new ArrayList<>();
        return findPermutations(nums);
    }

    public static void main(String[] args) {
        List<List<Integer>> result = Permutations.findPermutationsItr(new int[]{1, 3, 5});
        System.out.print("Here are all the permutations: " + result);
    }
}

