package lintcode;

import java.util.ArrayList;

public class MaximumSubarray {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        // write your code        
        if (nums == null) {
            return 0;
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;            
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum > ans) {
                    ans = sum;
                }
            }
        }
        return ans;
    }
}
