package lintcode;

public class CoinChange {
	/**
     * @param coins: a list of integer
     * @param amount: a total amount of money amount
     * @return: the fewest number of coins that you need to make up
     */
    public int coinChange(int[] coins, int amount) {
        // write your code here
    	int[] opt = new int[amount + 1];
    	opt[0] = 0;
    	for (int i = 1; i < amount + 1; i++) {
    		opt[i] = amount + 1;
    		for (int j = 0; j < coins.length; j++) {
    			if (i - coins[j] >= 0 && opt[i - coins[j]] != amount + 1) {
    				opt[i] = Math.min(opt[i], opt[i - coins[j]] + 1);
    			}
    		}
    	}
    	return opt[amount] == amount + 1 ? -1 : opt[amount];
    }
}
