package lintcode;

public class SubtreeWithMaximumAverage {
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
    private static double maxVal = Double.NEGATIVE_INFINITY;
    private static TreeNode maxTree;
    private int[] average(TreeNode root) {
        int sum = 0;
        int count = 0;
        if (root.left == null && root.right == null) {
            if (maxVal < root.val) {
                maxVal = root.val;
                maxTree = root;
            }
            return new int[]{root.val, 1};
        }
        if (root.left != null) {
            int[] leftSum = average(root.left);
            sum += leftSum[0];
            count += leftSum[1];
        }
        if (root.right != null) {
            int[] rightSum = average(root.right);
            sum += rightSum[0];
            count += rightSum[1];
        }
        if (maxVal < 1.0 * (root.val + sum) / (count + 1)) {
            maxVal = 1.0 * (root.val + sum) / (count + 1);
            maxTree = root;
        }
        return new int[]{root.val + sum, 1 + count};
    }
    public TreeNode findSubtree2(TreeNode root) {
        // Write your code here
        if (root != null) {
            average(root);
        }
        return maxTree;
    }
}
