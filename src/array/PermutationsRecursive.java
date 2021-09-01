package array;

import java.util.ArrayList;
import java.util.List;

class PermutationsRecursive {

    public static List<List<Integer>> generatePermutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generatePermutationsRecursive(nums, 0, new ArrayList<Integer>(), result);
        return result;
    }

    private static void generatePermutationsRecursive(int[] nums, int index, List<Integer> currentPermutation,
                                                      List<List<Integer>> result) {
        // base case
        if (currentPermutation.size() == nums.length) { // if index == nums.length
            result.add(currentPermutation);
            return;
        }

        // recursively add new numbers to all positions
        for (int i = 0; i <= currentPermutation.size(); i++) {
            List<Integer> newPermutation = new ArrayList<>(currentPermutation);
            newPermutation.add(i, nums[index]);
            generatePermutationsRecursive(nums, index + 1, newPermutation, result);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = PermutationsRecursive.generatePermutations(new int[]{1, 2, 3, 4});
        System.out.println("Here are all the permutations: " + result);
        System.out.println(result.size());
    }
}
