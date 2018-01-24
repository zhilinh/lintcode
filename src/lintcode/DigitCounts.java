package lintcode;

public class DigitCounts {
	/*
     * @param : An integer
     * @param : An integer
     * @return: An integer denote the count of digit k in 1..n
     */
    public int digitCounts(int k, int n) {
        // write your code here
    	StringBuilder tmp = new StringBuilder();
    	int count = 0;
    	for (int i = 0; i < n + 1; i++) {
    		tmp.append(String.valueOf(i));
    	}
    	for (int i = 0; i < tmp.length(); i++) {    		
    		if (tmp.charAt(i) == (char) (k + '0')) {
    			count++;
    		}
    	}
    	return count;
    }
}
