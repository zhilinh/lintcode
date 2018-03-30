package lintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringPermutation2Ans {
	/*
     * @param str: A string
     * @return: all permutations
     */
    public List<String> stringPermutation2(String str) {
        // write your code here
        List<String> result = new ArrayList<String>();
        if (str == null) {
            return result;
        }
        
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        boolean[] used = new boolean[str.length()];
        String one = "";
        getList(chars, one, used, result);
        return result;
    }
    
    public void getList(char[] chars, String one, boolean[] used, List<String> result) {
        if (one.length() == chars.length) {
            result.add(one);
            return;
        }
        
        for (int i = 0; i < chars.length; i++) {
        	// if this char used or repeated, continue
        	// used[i - 1] == false, already dfsed
            if (used[i] || (i > 0 && chars[i] == chars[i - 1] && used[i - 1] == false)) {
                continue;
            }
            one += chars[i];
            // dfs
            used[i] = true;
            getList(chars, one, used, result);
            // dfs back
            one = one.substring(0, one.length() - 1);
            used[i] = false;
        }
    }
}
