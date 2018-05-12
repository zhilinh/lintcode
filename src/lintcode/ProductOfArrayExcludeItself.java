package lintcode;

import java.util.ArrayList;
import java.util.List;

public class ProductOfArrayExcludeItself {
	/*
     * @param nums: Given an integers array A
     * @return: A long long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    public List<Long> productExcludeItself(List<Integer> nums) {
        // write your code here
    	List<Long> ans = new ArrayList<Long>();
    	for (int i = 0; i < nums.size(); i++) {
    		long product = 1;
    		for (int j = 0; j < nums.size(); j++) {
    			if (i != j) {
    				product *= nums.get(j);
    			}
    		}
    		ans.add(product);
    	}
    	return ans;
    }
}
