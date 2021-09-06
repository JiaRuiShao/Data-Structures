package string;

public class RemoveSpaces {

    static void removeWhiteSpaces (char[] s) {
        if (s == null || s.length == 0) {
            return;
        }
        int write = -1, read = 0;
        while (read < s.length) {
            if (s[read] != ' ') {
                s[++write] = s[read];
            }
            read++;
        }
        while (write < s.length - 1) {
            s[++write] = '\0';
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
        char[] s = "All greek  to me.".toCharArray();
        System.out.print("Before: ");
        printCharArray(s);
        removeWhiteSpaces(s);
        System.out.println();
        System.out.print("After: ");
        printCharArray(s);
    }
}
