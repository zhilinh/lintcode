package lintcode;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    SubtreeWithMaximumAverage a = new SubtreeWithMaximumAverage();
	    TreeNode root = new TreeNode(1);
	    TreeNode left1 = new TreeNode(-1);
	    TreeNode left2 = new TreeNode(2);
	    TreeNode left3 = new TreeNode(1);
	    TreeNode right1 = new TreeNode(2);
	    TreeNode right2 = new TreeNode(-4);
	    TreeNode right3 = new TreeNode(-5);
	    root.left = left1;
	    left1.left = left2;
	    left1.right = left3;
	    root.right = right1;
	    right1.left = right2;
	    right1.right = right3;
		System.out.println(a.findSubtree2(root).val);
	}
}
