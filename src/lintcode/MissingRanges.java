package lintcode;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
	/*
     * @param nums: a sorted integer array
     * @param lower: An integer
     * @param upper: An integer
     * @return: a list of its missing ranges
     */
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        // write your code here
    	List<String> strs = new ArrayList<String>();
    	List<Integer> numList = new ArrayList<Integer>();
    	String ans;
    	
    	if (nums == null || nums.length == 0) {
    		if (lower != upper) {
    			ans = String.valueOf(lower) + "->" + String.valueOf(upper);
    		} else {
    			ans = String.valueOf(lower);
    		}
    		strs.add(ans);
    		return strs;
    	}
    	
    	// Remove duplicates
    	numList.add(nums[0]);
    	for (int i = 1; i < nums.length; i++) {
    		if (nums[i] != nums[i - 1]) {
    			numList.add(nums[i]);
    		}
    	}
    	Integer[] ums = numList.toArray(new Integer[numList.size()]);
    	
    	int init = lower;
    	int p = 0;
    	
    	while (ums[p] < lower) {
			p++;
		}
    	
    	while (p < ums.length) {
    		int end = ums[p] - 1;
    		if (init == ums[p]) {
    			init++;
    		} else {
    			if (init == end) {
    				strs.add(String.valueOf(init));
    			} else {
    				strs.add(String.valueOf(init) + "->" + String.valueOf(end));
    			}
    			init = ums[p] + 1;
    		}
    		p++;
    	}
    	if (init != Integer.MIN_VALUE && init < upper) {
    		strs.add(String.valueOf(init) + "->" + String.valueOf(upper));
    	}
    	if (init != Integer.MIN_VALUE && init == upper) {
    		strs.add(String.valueOf(init));
    	}
    	return strs;
    }
}
