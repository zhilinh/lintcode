package lintcode;

public class PowerOfTwo {
	/**
     * @param n: an integer
     * @return: if n is a power of two
     */
    public boolean isPowerOfTwo(int n) {
        // Write your code here
    	// n = 0x0010
    	// n - 1 = 0x000F
    	return n > 0 && (n & (n - 1)) == 0;    	
    }
}
