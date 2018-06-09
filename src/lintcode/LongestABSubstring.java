package lintcode;

public class LongestABSubstring {
	/**
     * @param S: a String consists of a and b
     * @return: the longest of the longest string that meets the condition
     */
    public int getAns(String S) {
        // Write your code here
    	char[] sc = S.toCharArray();
    	int cntA = 0, cntB = 0, ans = 0;
    	for (int i = 0; i < sc.length; i++) {
    		if (sc[i] == 'A') {
    			cntA++;
    		} else {
    			cntB++;
    		}
    	}
    	ans = cntA > cntB ? cntB * 2 : cntA * 2;
    	return ans;
    }
}
