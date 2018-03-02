package lintcode;

public class InterleavingString {
	/**
     * @param s1: A string
     * @param s2: A string
     * @param s3: A string
     * @return: Determine whether s3 is formed by interleaving of s1 and s2
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        // write your code here
    	if (s3.length() != s1.length() + s2.length()) {
    		return false;
    	}
    	int m = s1.length();
    	int n = s2.length();
    	int[][] obj = new int[m + 1][n + 1];
    	obj[0][0] = 0;
    	
    	// Initialize the first row and column
    	// from 0 to len - 1
    	for (int i = 0; i < m; i++) {
    		if (s1.charAt(i) == s3.charAt(i)) {
    			obj[i + 1][0] = obj[i][0] + 1;
    		} else {
    			obj[i + 1][0] = obj[i][0];
    		}
    	}
    	for (int j = 0; j < n; j++) {
    		if (s2.charAt(j) == s3.charAt(j)) {
    			obj[0][j + 1] = obj[0][j] + 1;
    		} else {
    			obj[0][j + 1] = obj[0][j];
    		}
    	}
    	
    	// Start from (1, 1) to (m, n) to get the maximum value from up and left
    	// Be careful with the edge
    	for (int i = 1; i < m + 1; i++) {
    		for (int j = 1; j < n + 1; j++) {
    			int x = 0;
    			int y = 0;
    			if (s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
    				y = 1;
    			}
    			if (s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
    				x = 1;
    			}
    			obj[i][j] = Math.max(obj[i - 1][j] + y, obj[i][j - 1] + x);
    		}
    	}
    	
    	// If obj[m][n] is equal to the length then it succeed
    	if (obj[m][n] == s3.length()) {
    		return true;
    	} else {
    		return false;
    	}
    }
}
