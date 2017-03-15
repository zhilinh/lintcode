package lintcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePathSum {
    /**
     * @param root the root of binary tree
     * @param target an integer
     * @return all valid paths
     */
    private int num;
    private List<List<Integer>> result = new ArrayList<List<Integer>>();
    private int sum(List<Integer> array) {
        int sum = 0;
        for (Integer i : array) {
            sum += i;
        }
        return sum;
    }
    private void dfs(TreeNode root, List<Integer> array) {
        List<Integer> newArray = new ArrayList<Integer>(array);
        newArray.add(root.val);
        if (root.left == null && root.right == null && num == sum(newArray)) {
            result.add(newArray);
            return;
        }
        if (root.left != null) {
            dfs(root.left, newArray);
        }
        if (root.right != null) {
            dfs(root.right, newArray);
        }
    }
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // Write your code here
        if (root == null) {
            return result;
        }
        this.num = target;
        List<Integer> array = new ArrayList<Integer>();
        dfs(root, array);
        return result;
    }
}
