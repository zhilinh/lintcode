package lintcode;

public class SegmentTreeBuild {
	/*
     * @param start: start value.
     * @param end: end value.
     * @return: The root of Segment Tree.
     */
    public SegmentTreeNode build(int start, int end) {
        // write your code here
    	if (start > end) {
    		return null;
    	}
    	SegmentTreeNode root = new SegmentTreeNode(start, end);
    	return dfsBuild(root);
    	
    }
    
    public SegmentTreeNode dfsBuild(SegmentTreeNode root) {
    	if (root.start == root.end) {
    		return new SegmentTreeNode(root.start, root.end);    		
    	}
    	root.left = new SegmentTreeNode(root.start, (root.start + root.end) / 2);
    	root.right = new SegmentTreeNode((root.start + root.end) / 2 + 1, root.end);
    	dfsBuild(root.left);
    	dfsBuild(root.right);
    	return root;
    }
}
