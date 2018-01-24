package lintcode;

import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {
	/**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        // write your code here
    	ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
    	if (numbers == null || numbers.length < 3) {
    		return ans;
    	}
    	Arrays.sort(numbers);    	
    	for (int i = 0; i < numbers.length - 2; i++) {
    		if (i > 0 && numbers[i] == numbers[i - 1]) {
    			continue;
    		} else {
    			int target = numbers[i];
    			int left = i + 1;
    			int right = numbers.length - 1;
    			twoSum(-target, ans, numbers, left, right);
    		}
    	}
    	return ans;
    }
    
    public void twoSum(int target,
    		ArrayList<ArrayList<Integer>> ans,
    		int[] numbers,
    		int left,
    		int right) {
    	while (left < right) {
    		if (numbers[left] + numbers[right] == target) {
    			ArrayList<Integer> tmp = new ArrayList<Integer>();
    			tmp.add(-target);
    			tmp.add(numbers[left]);
    			tmp.add(numbers[right]);
    			ans.add(tmp);
    			left++;
    			right--;

        		while (left < right && numbers[right] == numbers[right - 1]) {
        			right--;
        		}
        		while (left < right && numbers[left] == numbers[left + 1]) {
        			left++;
        		}
    		} else if (numbers[left] + numbers[right] < target) {
    			left++;
    		} else if (numbers[left] + numbers[right] > target) {
    			right--;
    		}
    	}
    }
}
