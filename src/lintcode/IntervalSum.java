package lintcode;

import java.util.*;

public class IntervalSum {
	
	class SegmentTreeNode {
		int start, end;
		long max;
		SegmentTreeNode left, right;
		SegmentTreeNode(int start, int end, long max) {
			this.start = start;
			this.end = end;
			this.max = max;
			this.left = this.right = null;
		}		
	}
	
	int[] A;
	
	/**
     * @param A: An integer list
     * @param queries: An query list
     * @return: The result list
     */
    public List<Long> intervalSum(int[] A, List<Interval> queries) {
        // write your code here
    	this.A = A;
    	SegmentTreeNode root = new SegmentTreeNode(0, A.length - 1, 0L);
    	dfsBuild(root);
    	List<Long> ans = new ArrayList<Long>();
    	for (Interval i : queries) {
    		ans.add(query(root, i.start, i.end));
    	}
    	return ans;
    }
    
    public void dfsBuild(SegmentTreeNode root) {
    	if (root.start == root.end) {
    		root.max = A[root.start];
    		return;
    	}
    	root.left = new SegmentTreeNode(root.start, (root.start + root.end) / 2, 0L);
    	root.right = new SegmentTreeNode((root.start + root.end) / 2 + 1, root.end, 0L);
    	dfsBuild(root.left);
    	dfsBuild(root.right);
    	root.max = root.left.max + root.right.max;
    }
    
    public long query(SegmentTreeNode root, int start, int end) {
        // write your code here
    	if (start == root.start && end == root.end) {
    		return root.max;
    	}
    	int mid = (root.start + root.end) / 2;
    	long leftMax = 0L;
    	long rightMax = 0L;
    	if (start <= mid) {
    		if (mid < end) {
    			leftMax = query(root.left, start, mid);
    		} else {
    			leftMax = query(root.left, start, end);
    		}
    	}
    	if (mid < end) {
    		if (start <= mid) {
    			rightMax = query(root.right, mid + 1, end);
    		} else {
    			rightMax = query(root.right, start, end);
    		}
    	}
    	return leftMax + rightMax;
    }
}
