package lintcode;

public class Sqrt {
	/**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
    	int sign = 1;
    	if (x < 0) { sign = -1; x = -x; }
        long i = Math.round(Math.floor(Math.sqrt(x)));
        return (int) i * sign;
    }
}
