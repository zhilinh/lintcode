package lintcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    /**
     * @param root: The root of binary tree.
     * @return: Level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> currentRow = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root == null) {
            return result;
        }
        queue.offer(root);
        int currentNum = 0;
        int thisRow = 1;
        int newRow = 0;
        while (!queue.isEmpty()) {
            currentNum++;
            TreeNode node = queue.poll();
            currentRow.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
                newRow++;
            }
            if (node.right != null) {
                queue.offer(node.right);
                newRow++;
            }
            if (currentNum == thisRow) {
                result.add(currentRow);
                currentRow = new ArrayList<Integer>();
                currentNum = 0;
                thisRow = newRow;
                newRow = 0;
            }
        }
        return result;
    }
}
