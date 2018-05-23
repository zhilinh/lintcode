package lintcode;

public class WindowSum {
	/**
     * @param nums: a list of integers.
     * @param k: length of window.
     * @return: the sum of the element inside the window at each moving.
     */
    public int[] winSum(int[] nums, int k) {
        // write your code here
    	int sum = 0;
    	if (nums.length == 0) {
    		return new int[0];
    	}
    	if (k >= nums.length) {
    		for (int i = 0; i < nums.length; i++) {
    			sum += nums[i];
    		}
    		return new int[] {sum};
    	}
    	int[] ans = new int[nums.length - k + 1];
    	    	
    	for (int i = 0; i < nums.length - k + 1; i++) {
    		ans[i] = 0;
    		for (int j = 0; j < k; j++) {
    			ans[i] += nums[i + j];
    		}
    	}
    	return ans;
    }
}
