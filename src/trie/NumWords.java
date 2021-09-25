/*
* If you are given a Trie, can you find the total number of words it contains?
* A solution is placed in the "solution" section to help you,
* but we would suggest you try to solve it on your own first.
* */

package trie;

import java.util.Arrays;

public class NumWords {


    /**
     *
     * Time: O(26^h) where 26 is the alphabet number, and h is the length of the longest word in dictionary
     * Space: O(1)
     *
     * Explanation:
     * It’s a pretty straightforward algorithm. Starting from the root, we visit each branch recursively.
     * Whenever a node is found with its isEndWord set to true, the result variable is incremented by 1.
     *
     * @param root the given root of trie
     * @return the num of words in the given trie
     */
    public int totalWords(TrieNode root) {
        int wordCount = 0;

        // base case
        if (root.isEndWord) {
            wordCount++;
        }
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                wordCount += totalWords(root.children[i]);
            }
        }
        return wordCount;
    }

    public static void main(String[] args) {
        String[] keys = {"the", "a", "there", "answer", "any",
                "by", "bye", "their","abc"};

        System.out.println("Keys: "+ Arrays.toString(keys));

        // construct trie
        Trie t = new Trie();
        for (String key : keys) {
            t.insert(key);
        }

        NumWords words = new NumWords();
        System.out.println((words.totalWords(t.getRoot())));
    }
}
