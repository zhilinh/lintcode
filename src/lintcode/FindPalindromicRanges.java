package lintcode;

public class FindPalindromicRanges {
	/**
     * @param L: A positive integer
     * @param R: A positive integer
     * @return:  the number of interesting subranges of [L,R]
     */
    public int PalindromicRanges(int L, int R) {
        if (L > R) {
        	return 0;
        }
        int[] opt = new int[R - L];
        opt[0] = isPalindromic(L) ? 1 : 0; 
        for (int i = 1; i < R - L; i++) {
        	opt[i] = opt[i - 1];
        	if (isPalindromic(i)) {
        		opt[i]++;
        	}
        }
        int count = 0;
        for (int i = 0; i < R - L; i++) {
        	for (int j = i; j < R - L; j++) {
        		if ((opt[j] - opt[i]) % 2 == 0 && j != i) {
        			count++;
        		}
        	}
        }
        return count;
    }
    
    private boolean isPalindromic(int val) {
    	String tmp = String.valueOf(val);
    	for (int i = 0, j = tmp.length() - 1; i < j; i++, j--) {
    		if (tmp.charAt(i) != tmp.charAt(j)) {
    			return false;
    		}
    	}
    	return true;
    }
}
