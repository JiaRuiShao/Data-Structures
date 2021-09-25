package trie;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TrieWords {

    /**
     * Time: O(26^h + 2*h*input.length()) where h is the max length of the input String
     * Space: O(h) where h is the max length of the input String
     *
     * @param curr the curr TrieNode we're working on
     * @param result the result
     * @param sb the StringBuilder used to stored
     */
    private void getWordsRec(TrieNode curr, List<String> result, StringBuilder sb) {
        // base case
        if (curr == null) {
            return;
        }

        if (curr.isEndWord) {
            result.add(sb.toString()); // implemented using System.arraycopy()
        }

        // recursive rules
        for (int i = 0; i < curr.children.length; i++) {
            if (curr.children[i] != null) {
                sb.append((char)(i + 'a'));
                getWordsRec(curr.children[i], result, sb);
            }
        }

        // remove the last char
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
            // why we should NOT use sb.deleteCharAt() when remove the last char???
            // https://www.javacodeexamples.com/java-stringbuilder-remove-last-character-example-stringbuffer/2213
            // because it uses System.arraycopy() which uses more space
        }
    }

    /**
     * Here we use StringBuilder here, another way is to use a char array
     * @param root the input Trie root
     * @return the String LL
     */
    public List<String> getWords(TrieNode root) {
        List<String> result = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        getWordsRec(root, result, sb);
        return result;
    }

    public static void main(String args[]) {
        TrieWords words = new TrieWords();

        // Input keys (use only 'a' through 'z' and lower case)
        String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their", "abc"};
        String output[] = {"Not present in trie", "Present in trie"};
        Trie t = new Trie();

        System.out.println("Keys: " + Arrays.toString(keys));

        // Construct trie
        for (int i = 0; i < keys.length; i++) {
            t.insert(keys[i]);
        }

        // check result
        List<String> list = words.getWords(t.getRoot());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
