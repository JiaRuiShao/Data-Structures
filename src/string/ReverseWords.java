/*
* Reverse Words in a Sentence.
* */

package string;

class ReverseWords{

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    private static void reverse(char[] sentence, int left, int right) {
        while (left < right) {
            swap(sentence, left, right);
            left++;
            right--;
        }
    }

    public static void reverseWords (char[] sentence) {
        // corner case
        if (sentence == null || sentence.length == 0) {
            return;
        }

        // reverse the whole sentence first
        reverse(sentence, 0, sentence.length - 1);

        // reverse each word, seperated by the white space
        int left = 0, right = 0;
        while (right < sentence.length) {
            if (sentence[right] == ' ') {
                if (left != right) {
                    reverse(sentence, left, right - 1);
                }
                left = right + 1;
            }
            right++;
        }
        reverse(sentence, left, right - 1);
    }

    public static void main(String[] args) {
        char[] s = "Hello World!".toCharArray();
        System.out.println(s);
        reverseWords(s);
        System.out.println(s);
    }
}