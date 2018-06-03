package lintcode;

public class SegmentTreeModify {
	
	/**
     * @param root: The root of segment tree.
     * @param index: index.
     * @param value: value
     * @return: nothing
     */
    public void modify(SegmentTreeNode root, int index, int value) {
        // write your code here
    	if (root.start == root.end && root.start == index) {
    		root.max = value;
    		return;
    	}
    	int mid = (root.start + root.end) / 2;
    	if (index <= mid) {
    		modify(root.left, index, value);
    	} else {
    		modify(root.right, index, value);
    	}
    	root.max = Math.max(root.left.max, root.right.max);
    }
}
