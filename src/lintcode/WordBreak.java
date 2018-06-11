package lintcode;

import java.util.*;

public class WordBreak {
	/*
     * @param s: A string
     * @param dict: A dictionary of words dict
     * @return: A boolean
     */
    public boolean wordBreak(String s, Set<String> dict) {
        // write your code here
        int n = s.length();
        boolean[] breakable = new boolean[n + 1];
        breakable[0] = true;
        
        for (int i = 1; i < n + 1; i++) {
            for (int j = i; j > -1; j--) {
                if (!breakable[j]) continue;
                String str = s.substring(j, i);
                if (dict.contains(str)) breakable[i] = true;
            }
        }
        return breakable[n];
    }
}
