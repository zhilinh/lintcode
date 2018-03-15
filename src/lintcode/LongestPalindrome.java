package lintcode;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
	/**
     * @param s: a string which consists of lowercase or uppercase letters
     * @return: the length of the longest palindromes that can be built
     */
    public int longestPalindrome(String s) {
        // write your code here
    	int ans = 0;
    	boolean odd = false;
    	Map<Character, Integer> dict = new HashMap<Character, Integer>();
    	for (int i = 0; i < s.length(); i++) {
    		if (dict.containsKey(s.charAt(i))) {
    			dict.put(s.charAt(i), dict.get(s.charAt(i)) + 1);
    		} else {
    			dict.put(s.charAt(i), 1);
    		}
    	}
    	for (char i : dict.keySet()) {
    		if (dict.get(i) % 2 == 0) {
    			ans += dict.get(i);
    		} else {
    			ans += dict.get(i) - 1;
    			odd = true;
    		}
    	}
    	if (odd) {
    		ans++;
    	}
    	return ans;
    }

}
