package lintcode;

public class PalindromicSubstrings {
	
	int count = 1;
	
	/**
     * @param str: s string
     * @return: return an integer, denote the number of the palindromic substrings
     */
    public int countPalindromicSubstrings(String str) {
    	if (str.length() == 0) {
    		return 0;
    	}
        for (int i = 0; i < str.length() - 1; i++) {
            checkPalindrome(str, i, i);
            checkPalindrome(str, i, i + 1);
        }
        return count;
    }
    
    private void checkPalindrome(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) { 
            count++;
            i--;
            j++;
        }
    }
}
