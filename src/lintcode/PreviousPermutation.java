package lintcode;

import java.util.Collections;
import java.util.List;

public class PreviousPermutation {
	/*
     * @param nums: A list of integers
     * @return: A list of integers that's previous permuation
     */
    public List<Integer> previousPermuation(List<Integer> nums) {
        // write your code here
    	int end = nums.size() - 1;
    	
    	// Corner cases
    	if (end <= 0) {
    		return nums;
    	}
    	
    	/**
    	 * Reverse reasonings on the next permutation
		 * 
		 * 55-0123-4-7 (to make it the least)
		 * 54-7-5-3210 (to make it the greatest)
		 * 
    	 */
    	for (int i = end - 1; i > -1; i--) {
    		if (nums.get(i) > nums.get(i + 1)) {
    			// Find the maximum number less than the first number
    			int j = findMax(nums, i, end);
    			// Swap the two numbers
    			swap(nums, i, j);
    			// Swap the list behind the index of the first number
    			swapList(nums, i + 1, end);
    			return nums;
    		}
    	}
    	Collections.reverse(nums);
    	return nums;
    }
    
    
    public void swap(List<Integer> list, int a, int b) {
    	int tmp = list.get(a);
    	list.set(a, list.get(b));
    	list.set(b, tmp);
    }
    
    public void swapList(List<Integer> list, int a, int b) {
    	for (int i = a; i < (b - a + 1) / 2 + a; i++) {
    		swap(list, i, b - (i - a));
    	}
    }
    
    /**
     * Find the maximum less number behind
     * 
     * @param list
     * @param index of the first number greater than a number on right
     * @param end index of the list
     * @return the index of the maximum number behind
     */  
    public int findMax(List<Integer> list, int index, int end) {
    	int maxNum = 0;
    	int j = index;
    	// It has to be reverse iteration in case equal numbers at tails
    	for (int i = end; i > index; i--) {
    		if (list.get(i) < list.get(index) && maxNum < list.get(i)) {
    			maxNum = list.get(i);
    			j = i;
    		}
    	}
    	return j;
    }
}