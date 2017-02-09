package lintcode;

public class FindPeak {
	/**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        // write your code here
    	int n = A.length;
    	if (A[2] < A[1]) { return 1; }
    	if (A[n - 3] < A[n - 2]) { return n - 2; }
    	int i = 3;
    	while (i < n - 2) {
    		if (2 * A[i] > A[i - 1] + A[i + 1]) {
    			return i;
    		}
    		if (A[i] > A[i + 1]) {
    			i += 2;
    		} else {
    			i++;
    		}
    	}
    	return 0;
    }
}
