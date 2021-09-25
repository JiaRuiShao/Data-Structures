/**
 * If you are given a dictionary and a word,
 * can you use a Trie to find if the given word can be formed by combining two dictionary words?
 */

package trie;

public class WordFormation {

    /**
     * Time: O(numCharInDict) + O(n^2)
     * Space: O(26*Word#InDict*AvgWordLength + n^2) where n is the target.length()
     *
     * @param dict the input String arr
     * @param target the given target String
     * @return true if the target String can be formed by combing two words in dict; false if not
     */
    public boolean isFormationPossible(String[] dict, String target) {
        // corner case
        if (dict == null || target.length() < 2 || dict.length < 2) {
            return false;
        }

        // create a trie & insert the Strings in dict into the trie
        Trie trie = new Trie();
        for (String str : dict) { // O(numCharInDict)
            trie.insert(str);
        }

        // search the target String
        for (int i = 1; i < target.length(); i++) { // O(target.length()-1)
            String s1 = target.substring(0, i);
            String s2 = target.substring(i, target.length());
            if (trie.search(s1) && trie.search(s2)) { // O(target.length())*O(target.length()-1)
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
