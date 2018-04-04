package lintcode;

import java.util.ArrayList;
import java.util.Collections;

public class MajorityNumber {
	/**
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(ArrayList<Integer> nums) {
    	Collections.sort(nums);
        int count = 1, candidate = nums.get(0), maxCount = 1;        
        for (int i = 1; i < nums.size(); i++) {
            if (candidate == nums.get(i)) {
            	maxCount = count++;
            } else {
            	count--;
            }
            if (count == 0) {
            	candidate = nums.get(i);
            	count = maxCount;
            }
        }
        return candidate;
    }
}
