package lintcode;

public class BinaryTreeLongestConsecutiveSequence {
    /**
     * @param root the root of binary tree
     * @return the length of the longest consecutive sequence path
     */
    private int longestPath = 1;
    private int dfs(TreeNode root) {
        int leftLength = 1;
        int rightLength = 1;
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left != null) {
            leftLength = dfs(root.left) + 1;
            if (root.left.val != root.val + 1) {
                leftLength = 1;
            }
        }
        if (root.right != null) {
            rightLength = dfs(root.right) + 1;
            if (root.right.val != root.val + 1) {
                rightLength = 1;
            }
        }
        if (longestPath < Math.max(leftLength, rightLength)) {
            longestPath = Math.max(leftLength, rightLength);
        }
        return Math.max(leftLength, rightLength);
    }
    public int longestConsecutive(TreeNode root) {
        // Write your code here
        if (root == null) {
            return 0;
        }
        dfs(root);
        return longestPath;
    }
}
