package lintcode;

public class ValidPalindrome {
	/**
     * @param s: A string
     * @return: Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        // write your code here
    	s = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
    	for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
    		if (s.charAt(i) != s.charAt(j)) {
    			return false;
    		}
    	}
    	return true;
    }
}
