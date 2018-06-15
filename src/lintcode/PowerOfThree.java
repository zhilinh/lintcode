package lintcode;

public class PowerOfThree {
	/**
     * @param n: an integer
     * @return: if n is a power of three
     */
    public boolean isPowerOfThree(int n) {
        // 1162261467 is 3^19,  3^20 is bigger than int  
        return n > 0 && 1162261467 % n == 0;
    }
}
