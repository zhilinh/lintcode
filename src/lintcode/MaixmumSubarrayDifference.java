package lintcode;

public class MaixmumSubarrayDifference {
	/**
     * @param nums: A list of integers
     * @return: An integer indicate the value of maximum difference between two substrings
     */
    public int maxDiffSubArrays(int[] nums) {
        // write your code here
    	int[] leftMaxs = new int[nums.length];
    	int[] leftMins = new int[nums.length];
    	int[] rightMaxs = new int[nums.length];
    	int[] rightMins = new int[nums.length];
    	
    	leftMaxs[0] = nums[0];
    	leftMins[0] = nums[0];
    	rightMaxs[nums.length - 1] = nums[nums.length - 1];
    	rightMins[nums.length - 1] = nums[nums.length - 1];
    	
    	int leftSum = nums[0];
    	int rightSum = nums[nums.length - 1];
    	int leftMin = 0;
    	int leftMax = 0;
    	int rightMin = 0;
    	int rightMax = 0;
    	
    	for (int i = 1; i < nums.length; i++) {
    		// if leftSum < 0, leftMax >= 0 
    		leftMax = Math.max(leftMax, leftSum);
    		leftMin = Math.min(leftMin, leftSum);
    		leftSum += nums[i];
    		leftMaxs[i] = Math.max(leftMaxs[i - 1], leftSum - leftMin);
    		leftMins[i] = Math.min(leftMins[i - 1], leftSum - leftMax);
    	}
    	
    	for (int i = nums.length - 2; i >= 0; i--) {
    		rightMax = Math.max(rightMax, rightSum);
    		rightMin = Math.min(rightMin, rightSum);
    		rightSum += nums[i];
    		rightMaxs[i] = Math.max(rightMaxs[i + 1], rightSum - rightMin);
    		rightMins[i] = Math.min(rightMins[i + 1], rightSum - rightMax);
    	}
    	
    	int largest = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            largest = Math.max(largest, Math.max(Math.abs(rightMaxs[i + 1] - leftMins[i]), Math.abs(leftMaxs[i] - rightMins[i + 1])));
        }
        
        return largest;
    }
}
