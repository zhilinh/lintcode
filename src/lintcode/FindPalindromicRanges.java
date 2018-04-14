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
		if (L == R) {
			return 1;
		}
		int[] opt = new int[R - L + 2];
		opt[0] = 0;
		for (int i = L; i <= R; i++) {
			opt[i - L + 1] = opt[i - L];
			if (isPalindromic(i)) {
				opt[i - L + 1]++;
			}
		}
		int count = 0;
		for (int i = 1; i <= R - L + 1; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if ((opt[i] - opt[j]) % 2 == 0) {
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
