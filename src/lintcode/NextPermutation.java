package lintcode;

import java.util.Arrays;

public class NextPermutation {
	/**
     * @param nums: A list of integers
     * @return: A list of integers
     */
    public int[] nextPermutation(int[] nums) {
        // write your code here
    	int end = nums.length - 1;
    	
    	// Corner cases
    	if (end <= 0) {
    		return nums;
    	}
    	
    	/**
    	 * Find the first number less than a number on right
    	 * It must have a DESCENDING sequence at tail for all permutation later
		 * But for the next permutation, it has to be an ASCENDING sequence at tail
		 * 
		 * 54-7-5-3210 (to make it the greatest)
		 * 55-0123-4-7 (to make it the least)
		 * 
    	 */
    	for (int i = end - 1; i > -1; i--) {
    		if (nums[i] < nums[i + 1]) {
    			// Find the minimum number greater than the first number
    			int j = findMin(nums, i, end);
    			// Swap the two numbers
    			swap(nums, i, j);
    			// Swap the list behind the index of the first number
    			swapList(nums, i + 1, end);
    			return nums;
    		}
    	}
    	Arrays.sort(nums);
    	swapList(nums, 0, end);
    	return nums;
    }
    
    public void swap(int[] list, int a, int b) {
    	int tmp = list[a];
    	list[a] = list[b];
    	list[b] = tmp;
    }
    
    public void swapList(int[] list, int a, int b) {
    	for (int i = a; i < (b - a + 1) / 2 + a; i++) {
    		swap(list, i, b - (i - a));
    	}
    }
    
    /**
     * Find the minimum greater number behind
     * 
     * @param list
     * @param index of the first number less than a number on right
     * @param end index of the list
     * @return the index of the minimum number behind
     */    
    public int findMin(int[] list, int index, int end) {
    	int minNum = Integer.MAX_VALUE;
    	int j = index;
    	// It has to be increasing iteration in case equal numbers at tails
    	for (int i = index + 1; i < end + 1; i++) {
    		if (list[i] > list[index] && minNum > list[i]) {
    			minNum = list[i];
    			j = i;
    		}
    	}
    	return j;
    }
}
