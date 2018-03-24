package lintcode;

public class PowXN {
	/*
     * @param x: the base number
     * @param n: the power number
     * @return: the result
     */
    public double myPow(double x, int n) {
    	// Base cases
        if (n == 0) {
            return 1;
        }
        
        if (n == 1) {
            return x;
        }
        
        if (n == -1) {
            return 1 / x;
        }
        
        // Recursion
        double ans = myPow(x, n / 2);
        
        if (n % 2 == 0) {
            return ans * ans;
        } else {
            return (n > 0) ? ans * ans * x : ans * ans * 1 / x;
        }
    }
}
