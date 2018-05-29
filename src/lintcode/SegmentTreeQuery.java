package lintcode;

public class SegmentTreeQuery {
	
	public class SegmentTreeNode {
		 public int start, end, max;
		 public SegmentTreeNode left, right;
		 public SegmentTreeNode(int start, int end, int max) {
			 this.start = start;
			 this.end = end;
			 this.max = max;
		     this.left = this.right = null;
		 }
	}
	
	/**
     * @param root: The root of segment tree.
     * @param start: start value.
     * @param end: end value.
     * @return: The maximum number in the interval [start, end]
     */
    public int query(SegmentTreeNode root, int start, int end) {
        // write your code here
    	if (start == root.start && end == root.end) {
    		return root.max;
    	}
    	int mid = (root.start + root.end) / 2;
    	int leftMax = Integer.MIN_VALUE;
    	int rightMax = Integer.MIN_VALUE;
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
    	return Math.max(leftMax, rightMax);
    }
}
