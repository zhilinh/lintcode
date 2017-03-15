package lintcode;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestor3 {
    /**
     * @param root The root of the binary tree.
     * @param A and B two nodes
     * @return: Return the LCA of the two nodes.
     */
    private TreeNode a;
    private TreeNode b;
    private List<TreeNode> pathA;
    private List<TreeNode> pathB;
    private void dps(TreeNode root, List<TreeNode> path) {
        if (root == null) {
            return;
        }
        path.add(root);
        if (root.val == a.val) {
            pathA = new ArrayList<TreeNode>(path);
        }
        if (root.val == b.val) {
            pathB = new ArrayList<TreeNode>(path);
        }        
        dps(root.left, path);
        dps(root.right, path);
        path.remove(root);
    }
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        a = A;
        b = B;
        List<TreeNode> path = new ArrayList<TreeNode>();
        dps(root, path);
        if (pathA == null || pathB == null) {
            return null;
        }
        int indexA = pathA.size() - 1;
        int indexB = pathB.size() - 1;        
        while (! pathA.get(indexA).equals(pathB.get(indexB))) {
            if (pathA.contains(pathB.get(indexB))) {
                return pathB.get(indexB);
            }
            if (pathB.contains(pathA.get(indexA))) {
                return pathA.get(indexA);
            }
            indexA--;
            indexB--;
        }
        if (pathA.get(indexA).equals(pathB.get(indexB))) {
            return pathA.get(indexA);
        }
        return null;
    }
}
