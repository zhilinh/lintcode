package lintcode;

public class CoinChangeII {
	/**
     * @param amount: a total amount of money amount
     * @param coins: the denomination of each coin
     * @return: the number of combinations that make up the amount
     */
    public int change(int amount, int[] coins) {
        // write your code here
    	int n = coins.length;
    	int[][] opt = new int[amount + 1][n + 1];
    	opt[0][0] = 1;
    	for (int i = 0; i < amount + 1; i++) {
    		for (int j = 0; j < n; j++) {
    		    if (opt[i][j] > 0) {
    		        opt[i][j + 1] += opt[i][j];
    		        if (i + coins[j] < amount + 1) {
    		        	// Different from Card Game
    		        	// A coin can be selected many times
    		            opt[i + coins[j]][j] += opt[i][j];
    		        }
    			}
    		}
    	}
    	return opt[amount][n];
    }
}
