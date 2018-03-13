package lintcode;

public class ConvertSortedListToBalancedBST {
	private ListNode current;

	public TreeNode sortedListToBST(ListNode head) {        
        int size = 0;
        current = head;
        while (current != null) {
        	size++;
        	current = current.next;
        }
        current = head;
        return recur(size);
    }
	
	private TreeNode recur(int size) {
		if (size == 0) {
			return null;
		}
		if (size == 1) {
			TreeNode tmp = new TreeNode(current.val);
			current = current.next;
			return tmp;
		}
		TreeNode tmp = new TreeNode(0);
		tmp.left = recur(size / 2);
		tmp.val = current.val;
		current = current.next;
		tmp.right = recur((size - 1) / 2);
		return tmp;
	}
}
