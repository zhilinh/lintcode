package systemdesign;

import java.util.*;

public class TrieService {

    private TrieNode root = null;

    public TrieService() {
        root = new TrieNode();
    }

    public TrieNode getRoot() {
        // Return root of trie root, and 
        // lintcode will print the tree struct.
        return root;
    }

    // @param word a string
    // @param frequency an integer
    public void insert(String word, int frequency) {
        // Write your cod here
        TrieNode cur = root;
        int n = word.length();

        for (int i = 0; i < n; ++i) {
            Character c = word.charAt(i);
            if (!cur.children.containsKey(c))
                cur.children.put(c, new TrieNode());

            cur = cur.children.get(c);
            addFrequency(cur.top10, frequency);
        }
    }

    public void addFrequency(List<Integer> top10, int frequency) {
        top10.add(frequency);
        int n = top10.size();
        int index = n - 1;
        while (index > 0) {
            if (top10.get(index) > top10.get(index - 1)) {
                int temp1 = top10.get(index);
                int temp2 = top10.get(index - 1);
                top10.set(index, temp2);
                top10.set(index - 1, temp1);
                index -= 1;
            } else 
                break; 
        }
        if (n > 10)
            top10.remove(n - 1);
    }
 }
