/*
* Given an array of numbers sorted in ascending order,
* find the element in the array that has the minimum difference with the given ‘key’.
* */

package array;

class MinimumDifference {

    /**
     * Binary Search
     *
     * Time: O(logN)
     * Space: O(1)
     *
     * @param arr the input array
     * @param key the target key
     * @return the element nearest to the key
     */
    public static int searchMinDiffElement(int[] arr, int key) {
        // corner case
        if (arr == null || arr.length == 0) return -1;

        // binary search
        int left = 0, right = arr.length - 1, mid;
        while (left < right - 1) {
            mid = left + (right - left) / 2;
            if (arr[mid] == key) return key;
            else if (arr[mid] < key) left = mid;
            else right = mid;
        }

        return Math.abs(arr[left] - key) < Math.abs(arr[right] - key) ? arr[left] : arr[right];
    }

    public static void main(String[] args) {
        System.out.println(MinimumDifference.searchMinDiffElement(new int[]{4, 6, 10}, 7));
        System.out.println(MinimumDifference.searchMinDiffElement(new int[]{4, 6, 10}, 4));
        System.out.println(MinimumDifference.searchMinDiffElement(new int[]{1, 3, 8, 10, 15}, 12));
        System.out.println(MinimumDifference.searchMinDiffElement(new int[]{4, 6, 10}, 17));
    }
}