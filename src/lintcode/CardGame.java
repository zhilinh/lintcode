package lintcode;

public class CardGame {
	/**
     * @param n: The number of cards
     * @param totalProfit: The totalProfit
     * @param totalCost: The totalCost
     * @param a: The profit of cards
     * @param b: The cost of cards
     * @return: Return the number of legal plan
     */
    public int numOfPlan(int n, int totalProfit, int totalCost, int[] a, int[] b) {
        // Write your code here
    	long mod = 1000000007;
    	long[][][] opt = new long[totalProfit + 2][totalCost][n + 1];
    	opt[0][0][0] = 1;
    	for (int i = 0; i < totalProfit + 2; i++) {
    		for (int j = 0; j < totalCost; j++) {
    			for (int k = 0; k < n; k++) {
    				if (opt[i][j][k] > 0) {
    					opt[i][j][k + 1] += opt[i][j][k];
    					opt[i][j][k + 1] %= mod;
    					if (j + b[k] < totalCost) {
    						// Different from Coin Challenge II
    						// A card can only be selected once
    						// So the value moves to the next card
    						opt[Math.min(i + a[k], totalProfit + 1)][j + b[k]][k + 1] += opt[i][j][k];
    						opt[Math.min(i + a[k], totalProfit + 1)][j + b[k]][k + 1] %= mod;
    					}
    				}
    			}
    		}
    	}
    	int sum = 0;
    	for (int i = 0; i < totalCost; i++) {
    		sum += opt[totalProfit + 1][i][n];
    		sum %= mod;
    	}
    	return sum;
    }
}
