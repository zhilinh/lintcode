package lintcode;

public class MinimumSubtree {
    /**
     * @param root the root of binary tree
     * @return the root of the minimum subtree
     */
    private int minSum = Integer.MAX_VALUE;
    private TreeNode minTree;
    private int sumTree(TreeNode root) {
        int sum = 0;
        if (root.left == null && root.right == null) {
            if (root.val < minSum) {
                minSum = root.val;
                minTree = root;
            }
            return root.val;
        }
        if (root.left != null) {
            sum += sumTree(root.left);
        }
        if (root.right != null) {
            sum += sumTree(root.right);
        }
        sum += root.val;
        if (sum < minSum) {
            minSum = sum;
            minTree = root;
        }
        return sum;
    }
    public TreeNode findSubtree(TreeNode root) {
        // Write your code here
        if (root == null) {
            return null;
        }
        sumTree(root);
        return minTree;
    }
}
