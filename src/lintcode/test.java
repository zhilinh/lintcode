package lintcode;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    BinaryTreeLevelOrderTraversal a = new BinaryTreeLevelOrderTraversal();
	    TreeNode root = new TreeNode(10);
	    TreeNode node1 = new TreeNode(5);
	    TreeNode node2 = new TreeNode(15);
	    TreeNode node3 = new TreeNode(6);
	    TreeNode node4 = new TreeNode(20);
	    TreeNode node5 = new TreeNode(5);
	    TreeNode node6 = new TreeNode(6);
	    TreeNode node7 = new TreeNode(9);
	    TreeNode node8 = new TreeNode(7);
	    root.left = node1;
	    root.right = node2;
//	    node2.left = node3;
//	    node2.right = node4;
		System.out.println(a.levelOrder(root));
	}
}
