package lintcode;

public class ValidateBinarySearchTree {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        // write your code here
        return helper(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }
    
    private boolean helper(TreeNode root, long max, long min) {
        if (root == null) return true;
        
        if (root.val >= max || root.val <= min) return false;
        
        boolean left = helper(root.left, root.val, min);
        boolean right = helper(root.right, max, root.val);
        
        return left && right;
    }
}
