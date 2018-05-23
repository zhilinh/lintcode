package lintcode;

public class MaximumSubtree {
	int maxSum = Integer.MIN_VALUE;
	TreeNode subRoot;
	
	/**
     * @param root: the root of binary tree
     * @return: the maximum weight node
     */
    public TreeNode findSubtree(TreeNode root) {
        // write your code here
    	dfs(root);
    	return subRoot;
    }
    
    public int dfs(TreeNode root) {
    	if (root == null) {
    		return 0;
    	}
    	
    	if (root.left == null && root.right == null) {
    		if (root.val > maxSum) {
    			maxSum = root.val;
    			subRoot = root;
    		}
    		return root.val;
    	}
    	
    	int leftSum = dfs(root.left);
    	int rightSum = dfs(root.right);
    	int sum = leftSum + rightSum + root.val;
    	if (sum > maxSum) {
    		maxSum = sum;
    		subRoot = root;
    	}
    	return sum;
    }
}
