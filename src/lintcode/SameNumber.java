package lintcode;

import java.util.HashMap;
import java.util.Map;

public class SameNumber {
	/**
     * @param nums: the arrays
     * @param k: the distance of the same number
     * @return: the ans of this question
     */
    public String sameNumber(int[] nums, int k) {
        // Write your code here
    	Map<Integer, Integer> index = new HashMap<Integer, Integer>();
    	for (int i = 0; i < nums.length; i++) {
    		if (index.containsKey(nums[i])) {
    			int dis = i - index.get(nums[i]);
    			if (dis < k) {
    				return "YES";
    			} else {
    				index.put(nums[i], i);
    			}
    		} else {
    			index.put(nums[i], i);
    		}
    	}
    	return "NO";
    }
}
