package lintcode;

public class FindKClosestElements {
	/**
     * @param A: an integer array
     * @param target: An integer
     * @param k: An integer
     * @return: an integer array
     */
    public int[] kClosestNumbers(int[] A, int target, int k) {
        // Binary Search
    	int[] ans = new int[k];
    	int left = 0, mid = 0, right = A.length - 1, count = 0;
    	while (left < right - 1) {
    		mid = left + (right - left) / 2;
    		if (A[mid] > target) {
    			right = mid;
    		} else {
    			if (A[mid] < target) {
    				left = mid;
    			} else {
    				break;
    			}
    		}
    	}
    	
    	// Two pointers
    	right = left + 1;
    	while (count < k) {
    		// Corner cases
    		if (left == -1) {
    			ans[count] = A[right];
    			right++;
    			count++;
    			continue;
    		}
    		if (right == A.length) {
    			ans[count] = A[left];
    			left--;
    			count++;
    			continue;
    		}
    		
    		// Find the closest nums
    		if (target - A[left] <= A[right] - target) {
    			ans[count] = A[left];
    			left--; 
    		} else {
    			ans[count] = A[right];
    			right++;
    		}
    		count++;
    	}
    	return ans;
    }
}
