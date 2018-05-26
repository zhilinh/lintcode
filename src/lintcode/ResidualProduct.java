package lintcode;

public class ResidualProduct {
	/**
     * @param arr: The array you should handle
     * @return: Return the product
     */
    public int[] getProduct(int[] arr) {
        // Write your code here
    	long prod = 1;
    	int[] ans = new int[arr.length];
    	boolean sign = false;
    	
    	for (int i = 0; i < arr.length; i++) {
    		if (arr[i] == 0 && !sign) {
    			sign = true;
    			continue;
    		}
    		prod *= arr[i];
    	}
    	
    	if (arr.length == 1) {
			ans[0] = 0;
			return ans;
		}
    	if (sign) {
    		for (int i = 0; i < arr.length; i++) {
    			if (arr[i] == 0) {
    				ans[i] = (int) prod;
    			} else {
    				ans[i] = 0;
    			}
    		}    		
    	} else {
    		for (int i = 0; i < arr.length; i++) {    			
    			ans[i] = (int) (prod / arr[i]);
    		}    			
    	}
    	return ans;
    }
}
