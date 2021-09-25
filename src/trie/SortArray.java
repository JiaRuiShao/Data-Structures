package trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortArray {

    private void sortArrRec(TrieNode curr, List<String> result, char[] chararr, int idx) {
        // base case
        if (curr == null) {
            return;
        }
        if (curr.isEndWord) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < idx; i++) {
                sb.append(chararr[i]);
            }
            result.add(sb.toString());
        }
        // recursive rules
        for (int i = 0; i < curr.children.length; i++) {
            if (curr.children[i] != null) {
                chararr[idx] = (char) ('a' + i);
                sortArrRec(curr.children[i], result, chararr, idx + 1);
            }
        }
    }


    public ArrayList<String> sortArray(String[] arr) {
        if (arr == null) {
            return null;
        }

        ArrayList<String> result = new ArrayList<String>();
        char[] chararr = new char[26];

        // Construct trie
        Trie t = new Trie();
        for (String str : arr) {
            t.insert(str);
        }

        sortArrRec(t.getRoot(), result, chararr, 0);
        return result;
    }

    public static void main(String[] args) {
        SortArray trie = new SortArray();

        // Input keys (use only 'a' through 'z' and lower case)
        String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their", "abc"};
        System.out.println("Keys: " + Arrays.toString(keys));

        ArrayList<String> list = trie.sortArray(keys);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
