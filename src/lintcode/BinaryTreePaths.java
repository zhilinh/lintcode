package lintcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    /**
     * @param root the root of the binary tree
     * @return all root-to-leaf paths
     */
    private List<String> result = new ArrayList<String>();
    private void dfs(TreeNode root, String path) {
        path += String.valueOf(root.val) + "->";
        if (root.left == null && root.right == null) {
            path = path.substring(0, path.length() - 2);
            result.add(path);
        }
        if (root.left != null) {
            dfs(root.left, path);
        }
        if (root.right != null) {
            dfs(root.right, path);
        }
    }
    public List<String> binaryTreePaths(TreeNode root) {
        // Write your code here
        if (root == null) {
            return result;
        }
        dfs(root, "");
        return result;
    }
}
