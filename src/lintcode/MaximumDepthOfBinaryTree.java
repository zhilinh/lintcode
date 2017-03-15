package lintcode;

public class MaximumDepthOfBinaryTree {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    private int maxDepth = 0;
    private void dps(TreeNode root, int depth) {
        if (root.left == null && root.right == null) {
            depth += 1;
            maxDepth = Math.max(depth, maxDepth);
        }
        if (root.left != null) {
            dps(root.left, depth + 1);
        }
        if (root.right != null) {
            dps(root.right, depth + 1);
        }
    }
    public int maxDepth(TreeNode root) {
        // write your code here
        if (root == null) {
            return 0;
        }
        dps(root, 0);
        return maxDepth;
    }
}
