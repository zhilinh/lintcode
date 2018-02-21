package lintcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class SearchRangInBST {
	/*
     * @param root: param root: The root of the binary search tree
     * @param k1: An integer
     * @param k2: An integer
     * @return: return: Return all keys that k1<=key<=k2 in ascending order
     */
    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	List<Integer> array = new ArrayList<Integer>();
    	if (root == null) {
    		return array;
    	}
    	queue.add(root);
    	while (!queue.isEmpty()) {
    		TreeNode curr = queue.poll();
    		// To avoid NullPointer error!
    		if (curr == null) {
    			continue;
    		}
    		if (k1 <= curr.val && curr.val <= k2) {
    			array.add(curr.val);
    		}
    		queue.add(curr.left);
    		queue.add(curr.right);
    	}
    	Collections.sort(array);
    	return array;
    }
}
