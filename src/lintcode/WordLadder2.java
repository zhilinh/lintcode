package lintcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WordLadder2 {
    List<List<String>> ans = new ArrayList<List<String>>();
    int step = Integer.MAX_VALUE;

    /**
     * @param start,
     *            a string
     * @param end,
     *            a string
     * @param dict,
     *            a set of string
     * @return a list of lists of string
     */
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        // write your code here
        if (dict == null || start == null || end == null) {
            return ans;
        }
        String[] words = dict.toArray(new String[dict.size()]);
        int length = start.length();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() != length) {
                return ans;
            }
        }
        helper(words, start, end, new ArrayList<String>(), 0);
        return ans;
    }

    public boolean checkDistance(String curr, String obj) {
        int dis = 0;
        for (int i = 0; i < curr.length(); i++) {
            if (curr.charAt(i) != obj.charAt(i)) {
                dis++;
            }
        }
        return dis == 1;
    }

    public void helper(String[] words, String curr, String end, List<String> partitions, Integer currStep) {
        partitions.add(curr);
        if (checkDistance(curr, end)) {
            partitions.add(end);
            List<String> copy = new ArrayList<String>();
            for (int i = 0; i < partitions.size(); i++) {
                copy.add(partitions.get(i));
            }
            if (currStep == step) {
                ans.add(copy);
            }
            if (currStep < step) {
                step = currStep;
                ans = new ArrayList<List<String>>();
                ans.add(copy);
            }
            partitions.remove(partitions.size() - 1);
        } else {
            for (int i = 0; i < words.length; i++) {
                if (checkDistance(curr, words[i]) && (!partitions.contains(words[i]))) {
                    helper(words, words[i], end, partitions, currStep + 1);
                }
            }
        }
        partitions.remove(partitions.size() - 1);
    }
}
