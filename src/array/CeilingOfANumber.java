/*
* Given an array of numbers sorted in ascending order, find the ceiling of a given number ‘key’.
* The ceiling of the ‘key’ will be the smallest element in the given array greater than or equal to the ‘key’.
* Write a function to return the index of the ceiling of the ‘key’. If there isn’t any ceiling return -1.
* */

package array;

public class CeilingOfANumber {

    /**
     * Time: O(logN)
     * Space: O(1)
     *
     * @param arr the input array
     * @param key the target number
     * @return the ceiling of target number key; -1 if not exist
     */
    public static int searchCeilingOfANumber(int[] arr, int key) {
        // corner case
        if (arr == null || arr.length == 0) return -1;

        int left = 0, right = arr.length - 1, mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (arr[mid] == key) return mid;
            else if (arr[mid] > key) right = mid - 1;
            else if (arr[mid] < key) left = mid + 1;
        }
        // terminate when left = right + 1
        return (left < arr.length) ? left : -1;
    }

    /**
     * Time: O(logN)
     * Space: O(1)
     *
     * @param arr the input array
     * @param key the target number
     * @return the floor of target number key; -1 if not exist
     */
    public static int searchFloorOfANumber(int[] arr, int key) {
        // corner case
        if (arr == null || arr.length == 0) return -1;

        int left = 0, right = arr.length - 1, mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (arr[mid] == key) return mid;
            else if (arr[mid] > key) right = mid - 1;
            else if (arr[mid] < key) left = mid + 1;
        }
        // terminate when left = right + 1
        return (right >= 0) ? right : -1;
    }

    public static void main(String[] args) {
        System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, 6));
        System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 1, 3, 8, 10, 15 }, 12));
        System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, 17));
        System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, -1));

        System.out.println(searchFloorOfANumber(new int[] { 4, 6, 10 }, 6));
        System.out.println(searchFloorOfANumber(new int[] { 1, 3, 8, 10, 15 }, 12));
        System.out.println(searchFloorOfANumber(new int[] { 4, 6, 10 }, 17));
        System.out.println(searchFloorOfANumber(new int[] { 4, 6, 10 }, -1));
    }
}
