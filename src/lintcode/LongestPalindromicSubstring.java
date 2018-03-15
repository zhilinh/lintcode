package lintcode;

public class LongestPalindromicSubstring {
	/**
     * @param s: input string
     * @return: the longest palindromic substring
     */
    public String longestPalindrome(String s) {
    	int maxLen = 1;
    	int maxSta = 0;
    	for (int i = 0; i < s.length() - 1; i++) {
    		int a, b, j, tmpLen;
    		a = findLongestPalindrome(i, 0, s);
    		b = findLongestPalindrome(i, 1, s);    		
    		if (a > b) {
    			tmpLen = a;
    			j = i - (a / 2 - 1);
    		} else {
    			tmpLen = b;
    			j = i - (b / 2);
    		}
    		if (tmpLen > maxLen) {
    			maxLen = tmpLen;
    			maxSta = j;
    		}
    	}
    	return s.substring(maxSta, maxSta + maxLen);
    }
    
    private int findLongestPalindrome(int i, int k, String s) {
    	int tmpLen = k;
    	int j;
		for (j = 0; j < s.length(); j++) {
			if (i - j - k >= 0 && i + j + 1 < s.length() && s.charAt(i - j - k) == s.charAt(i + j + 1)) {
				tmpLen += 2;
			} else {
				break;
			}
		}
		return tmpLen;
    }
}
