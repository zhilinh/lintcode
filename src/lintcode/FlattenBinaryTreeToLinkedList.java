package lintcode;

public class FlattenBinaryTreeToLinkedList {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    private TreeNode preorder(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root;
        }
        TreeNode copy = root.right;
        TreeNode leftEnd = null;
        if (root.left != null) {
            root.right = root.left;
            root.left = null;
            leftEnd = preorder(root.right);
            if (leftEnd != null) {
                leftEnd.right = copy;
            }
        }
        if (copy != null) {
            return preorder(copy);
        } else {
            return leftEnd;
        }
    }
    public void flatten(TreeNode root) {
        // write your code here
        if (root != null) {
            preorder(root);
        }
    }
}
