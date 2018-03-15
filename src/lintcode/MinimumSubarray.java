package lintcode;

import java.util.List;

public class MinimumSubarray {
	/*
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
    public int minSubArray(List<Integer> nums) {
        // write your code here
        
        int min[] = new int[nums.size()];
        min[0] = nums.get(0);
        int minSum = min[0];
        for(int i = 1; i < nums.size(); i++){
            min[i] = Math.min(min[i - 1] + nums.get(i), nums.get(i));
            minSum = Math.min(min[i], minSum);
        }
        
        return minSum;
    }
}
