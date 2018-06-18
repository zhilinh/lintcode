package lintcode;

import java.util.*;

public class BSTIterator {
	
	// Space complexity: O(height)
    Stack<TreeNode> stack;
	
    /*
     * @param root: The root of binary tree.
     */
	public BSTIterator(TreeNode root) {
		// do initialization if necessary		
		stack = new Stack<TreeNode>();
		if (root == null) return;
		while (root != null) {
			stack.add(root);
			root = root.left;
		}
    }

    /*
     * @return: True if there has next node, or false
     */
    public boolean hasNext() {
        // write your code here
    	return !stack.isEmpty();
    }

    /*
     * @return: return next node
     */
    public TreeNode next() {
        // write your code here
    	TreeNode curr = stack.pop();
    	if (curr.right != null) {
    		TreeNode rightLeft = curr.right;
    		while (rightLeft != null) {
        		stack.push(rightLeft);
        		rightLeft = rightLeft.left;
        	}
    	}    	
    	return curr;
    }

//	List<TreeNode> nodes;
//	int p;
//	
//    /*
//    * @param root: The root of binary tree.
//    */public BSTIterator(TreeNode root) {
//        // do initialization if necessary
//    	nodes = new ArrayList<TreeNode>();
//    	p = 0;
//    	traversal(root);
//    }
//
//    /*
//     * @return: True if there has next node, or false
//     */
//    public boolean hasNext() {
//        // write your code here
//    	if (p >= nodes.size()) {
//    		return false;
//    	}
//    	return true;
//    }
//
//    /*
//     * @return: return next node
//     */
//    public TreeNode next() {
//        // write your code here
//    	return nodes.get(p++);
//    }
//    
//    public void traversal(TreeNode root) {
//    	if (root == null) {
//    		return;
//    	}
//    	if (root.left != null) {
//    		traversal(root.left);
//    	}
//    	nodes.add(root);
//    	traversal(root.right);
//    }
}
