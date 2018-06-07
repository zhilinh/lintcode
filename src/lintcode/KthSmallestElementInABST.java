package lintcode;

public class KthSmallestElementInABST {
	
	int val = 0;
	
	/**
     * @param root: the given BST
     * @param k: the given k
     * @return: the kth smallest element in BST
     */
    public int kthSmallest(TreeNode root, int k) {
        // write your code here
    	searchKth(root, 0, k);
    	return val;
    }
    
    private int searchKth(TreeNode root, int count, int k) {
    	if (count > k || root == null) {
    		return count;
    	}
    	if (root.left == null && root.right == null) {
    		count++;
    		if (count == k) {
    			val = root.val;
    			count++;
    		}
    		return count;
    	}
    	
    	count = searchKth(root.left, count, k);
    	count++;
    	if (count == k) {
    		val = root.val;
    		count++;
    		return count;
    	}
    	count = searchKth(root.right, count, k);
    	return count;
    }
}
