package string;

import java.util.HashSet;
import java.util.Set;

class StringSegmentation{

    public static boolean segmentString(String s, Set<String> dict) {
        String w1 = null, w2 = null;
        for (int i = 1; i < s.length(); i++) {
            w1 = s.substring(0, i);
            w2 = s.substring(i, s.length()); // create substring can be avoided by passing indexes
            if (dict.contains(w1)) {
                if (dict.contains(w2) || w2.length() == 0 || segmentString(w2, dict)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * =========================================== Algorithm ===========================================
     * n = length of input string
     * for i = 0 to n - 1
     *   first_word = substring (input string from index [0, i] )
     *   second_word = substring (input string from index [i + 1, n - 1] )
     *   if dictionary has first_word
     *     if second_word is in dictionary OR second_word is of zero length, then return true
     *     recursively call this method with second_word as input and return true if it can be segmented
     *
     * @param s the input string
     * @param dictionary the given dictionary
     * @return true if the input string can be divided into the words in the dictionary; false if not
     */
    public static boolean canSegmentString(String s, Set<String> dictionary) {
        if (s == null || s.length() == 0) {
            return false;
        }
        return segmentString(s, dictionary);
    }

    public static void main(String[] args) {
        Set < String > dictionary = new HashSet< String >();
        String s = new String();
        s = "hellonow";

        dictionary.add("hello");
        dictionary.add("hell");
        dictionary.add("on");
        dictionary.add("now");
        if (canSegmentString(s, dictionary)) {
            System.out.println("String Can be Segmented");
        } else {
            System.out.println("String Can NOT be Segmented");
        }
    }
}