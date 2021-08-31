/**
 * Given an array of numbers sorted in ascending order, find the range of a given number ‘key’.
 * The range of the ‘key’ will be the first and last position of the ‘key’ in the array.
 * Write a function to return the range of the ‘key’. If the ‘key’ is not present return [-1, -1].
 *
 * Input: [4, 6, 6, 6, 9], key = 6
 * Output: [1, 3]
 */

package array;

class FindRange {

    public static int[] findRange(int[] arr, int key) {
        int[] result = new int[]{-1, -1};

        if (arr == null || arr.length == 0) {
            return result;
        }

        int left = 0, right = arr.length - 1, mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (arr[mid] < key) {
                left = mid + 1;
            } else if (arr[mid] > key) {
                right = mid - 1;
            } else {
                int lb = mid, rb = mid;
                while (lb >= 0 && arr[lb] == key) lb--;
                while (rb < arr.length && arr[rb] == key) rb++;
                return new int[]{lb + 1, rb - 1};
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] result = FindRange.findRange(new int[]{4, 6, 6, 6, 9}, 6);
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
        result = FindRange.findRange(new int[]{1, 3, 8, 10, 15}, 10);
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
        result = FindRange.findRange(new int[]{1, 3, 8, 10, 15}, 12);
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
    }
}
