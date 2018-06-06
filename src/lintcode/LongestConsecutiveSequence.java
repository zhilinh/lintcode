package lintcode;

import java.util.*;

public class LongestConsecutiveSequence {
	
	/**
     * @param num: A list of integers
     * @return: An integer
     */
    public int longestConsecutive(int[] num) {
        // write your code here
    	Set<Integer> set = new HashSet<Integer>();
    	int ans = 1;
    	for (int i : num) {
    		set.add(i);
    	}
    	
    	for (int i : num) {
    		if (!set.contains(i)) {
    			continue;
    		}
    		int length = 1;
    		int left = i - 1;
    		int right = i + 1;
    		// O(1)
    		while (set.contains(left)) {
    			set.remove(left);
    			length++;
    			left--;
    		}
    		// O(1)
    		while (set.contains(right)) {
    			set.remove(right);
    			length++;
    			right++;
    		}
    		ans = Math.max(ans, length);
    	}
    	return ans;
    }
}
