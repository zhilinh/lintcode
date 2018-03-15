package lintcode;

import java.util.List;

public class MaximumSubarrayII {
	public int maxTwoSubArrays(List<Integer> nums) {
        // write your code here
        int[] left = new int[nums.size()];
        int[] right = new int[nums.size()];
        
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int i = 0; i < nums.size();i++) {
            if (currentSum <= 0) {
                currentSum = nums.get(i);
            } else {
                currentSum += nums.get(i);
            }
            left[i] = maxSum = Math.max(currentSum, maxSum);
        }
        currentSum = 0;
        maxSum = Integer.MIN_VALUE;
        for (int i = nums.size() - 1; i >= 0;i--) {
            if (currentSum <= 0) {
                currentSum = nums.get(i);
            } else {
                currentSum += nums.get(i);
            }
            right[i] = maxSum = Math.max(currentSum, maxSum);
        }
        int split = 0;
        currentSum = 0;
        maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size() - 1; i++) {
            if(left[i] + right[i+1] > maxSum) {
                maxSum = left[i] + right[i+1];
                split = i;
            }
        }
        return maxSum;
    }
}