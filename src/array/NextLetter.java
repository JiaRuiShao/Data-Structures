package array;

class NextLetter {

    public static char searchNextLetter(char[] letters, char key) {
        int left = 0, right = letters.length - 1, mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (letters[mid] == key) {
                return letters[(mid + 1) % letters.length];
            } else if (letters[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return letters[left % letters.length];
    }

    public static void main(String[] args) {
        System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'f'));
        System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'b'));
        System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'm'));
        System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'h'));
    }
}
