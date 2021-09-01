package array;

import java.util.*;

public class Testing {
    public static List<List<Integer>> findPermutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<List<Integer>> permutation = new LinkedList<>();
        permutation.add(new ArrayList<>());
        int size;

        for (int num : nums) {
            size = permutation.size();
            for (int i = 0; i < size; i++) {
                List<Integer> previousPermutation = permutation.poll();
                // add the new num in all positions (0, 1, ... n)
                for (int j = 0; j <= previousPermutation.size(); j++) {
                    List<Integer> currentPermutation = new ArrayList<>(previousPermutation);
                    currentPermutation.add(j, num);
                    if (currentPermutation.size() == nums.length) {
                        result.add(currentPermutation);
                    } else {
                        permutation.add(currentPermutation);
                    }
                }

            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = findPermutations(new int[]{1, 2, 3, 4});
        System.out.println("Here are all the permutations: " + result);
        System.out.println(result.size());
        System.out.println();
        boolean[] myBoolean = new boolean[1];
        System.out.println(Arrays.toString(myBoolean));
    }
}
