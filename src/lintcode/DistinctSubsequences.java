package lintcode;

public class DistinctSubsequences {
	/*
     * @param : A string
     * @param : A string
     * @return: Count the number of distinct subsequences
     */
    public int numDistinct(String S, String T) {
        // write your code here
    	int[][] ans = new int[S.length() + 1][T.length() + 1];
    	for (int i = 0; i < S.length() + 1; i++) {
    		ans[i][0] = 1;
    	}
    	
    	for (int i = 1; i < S.length() + 1; i++) {
            for (int j = 1; j < T.length() + 1; j++) {
                ans[i][j] = ans[i - 1][j];
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    ans[i][j] += ans[i - 1][j - 1];
                }
            }
        }
    	return ans[S.length()][T.length()];
    }
}
