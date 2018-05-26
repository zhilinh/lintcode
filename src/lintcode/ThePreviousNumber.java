package lintcode;

public class ThePreviousNumber {
	/**
     * @param num: The arry you should handle
     * @return: Return the array
     */
    public int[] getPreviousNumber(int[] num) {
        // Write your code here    	
    	int[] ans = new int[num.length];
    	if (num == null || num.length == 0) {
    		return ans;
    	}
    	ans[0] = num[0];
    	for (int i = 1; i < num.length; i++) {
    		boolean sign = true;
    		for (int j = i - 1; j > -1; j--) {
    			if (num[j] < num[i]) {
    				ans[i] = num[j];
    				sign = false;
    				break;
    			} else {
    				if (ans[j] < num[i]) {
    					ans[i] = ans[j];
    					sign = false;
    					break;
    				}
    			}    			
    		}
    		if (sign) {
    			ans[i] = num[i];
    		}
    	}
    	return ans;
    }
}
