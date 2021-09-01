/*
* Given an infinite sorted array (or an array with unknown size),
* find if a given number ‘key’ is present in the array.
* Write a function to return the index of the ‘key’ if it is present in the array, otherwise return -1.
* Since it is not possible to define an array with infinite (unknown) size,
* you will be provided with an interface ArrayReader to read elements of the array.
* ArrayReader.get(index) will return the number at index;
* if the array’s size is smaller than the index, it will return Integer.MAX_VALUE.
*
* */

package array;

class ArrayReader {
    int[] arr;

    ArrayReader(int[] arr) {
        this.arr = arr;
    }

    public int get(int index) {
        if (index >= arr.length)
            return Integer.MAX_VALUE;
        return arr[index];
    }
}

class SearchInfiniteSortedArray {

    private static int binarySearch(ArrayReader reader, int key, int left, int right) {
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (reader.get(mid) < key) {
                left = mid + 1;
            } else if (reader.get(mid) > key) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * O(log_2(N)+log_2(2N)) = O(logN)
     * @param reader the arr reader helper
     * @param key the target key
     * @return the index of the key; -1 if it doesn't exist
     */
    public static int search(ArrayReader reader, int key) {
       int start = 0, end = 1;
       while (reader.get(end) < key) {
           int oldEnd = end;
           end += (end - start) * 2 + 1;
           start = oldEnd + 1;
       }
        return binarySearch(reader, key, start, end);
    }

    public static void main(String[] args) {
        ArrayReader reader = new ArrayReader(new int[] { 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30 });
        System.out.println(SearchInfiniteSortedArray.search(reader, 16));
        System.out.println(SearchInfiniteSortedArray.search(reader, 11));
        reader = new ArrayReader(new int[] { 1, 3, 8, 10, 15 });
        System.out.println(SearchInfiniteSortedArray.search(reader, 15));
        System.out.println(SearchInfiniteSortedArray.search(reader, 200));
    }
}