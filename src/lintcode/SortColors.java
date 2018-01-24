package lintcode;

public class SortColors {
	/**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        // write your code here
    	int zero = 0;
    	int one = 0;
    	for (int i = 0; i < nums.length; i++) {
    		if (nums[i] == 0) {
    			zero++;
    		} else if (nums[i] == 1) {
    			one++;
    		}
    	}
    	for (int i = 0; i < zero; i++) {
    		nums[i] = 0;
    	}
    	for (int i = 0; i < one; i++) {
    		nums[zero + i] = 1;
    	}
    	for (int i = 0; i < nums.length - zero - one; i++) {
    		nums[zero + one + i] = 2;
    	}
    }
}
