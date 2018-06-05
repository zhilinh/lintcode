package lintcode;

public class FindTheCelebrity {
	
	boolean knows(int a, int b) {
		return true;
	};
	
	/**
     * @param n a party with n people
     * @return the celebrity's label or -1
     */
    public int findCelebrity(int n) {
        // Write your code here
    	int curr = 0;
    	for (int i = 1; i < n; i++) {
    		if (knows(curr, i)) {
    			curr = i;
    		}
    	}
    	for (int i = 0; i < n; i++) {
    		if (knows(curr, i)) {
    			return -1;
    		}
    		// IMPORTANT!
    		if (curr != i && !knows(i, curr)) {
    			return -1;
    		}
    	}
    	return curr;
    }
}
