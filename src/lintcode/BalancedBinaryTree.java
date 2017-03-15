package lintcode;

public class BalancedBinaryTree {
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    private boolean result = true;
    private int dps(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int leftDepth = dps(root.left);
        int rightDepth = dps(root.right);
        if (Math.abs(leftDepth - rightDepth) < 2) {
            return Math.max(leftDepth, rightDepth) + 1;
        } else {
            result = false;
        }
        return 0;
    }
    public boolean isBalanced(TreeNode root) {
        // write your code here
        dps(root);
        return result;
    }
}
