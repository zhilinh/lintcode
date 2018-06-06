package lintcode;

public class PaintFence {
	/**
     * @param n non-negative integer, n posts
     * @param k non-negative integer, k colors
     * @return an integer, the total number of ways
     */
	public int numWays(int n, int k) {
        if (n <= 0)
            return 0;
        if (n == 1)
            return k;
        if (n == 2)
            return k * k;
        int same = k;
        int diff = k * (k - 1);
        int result = 0;
        for (int i = 3; i <= n; i++) {
            int tmp = diff;
            diff = (same + diff) * (k - 1);
            same = tmp;
            result = diff + same;
        }
        return result;
    }
}
