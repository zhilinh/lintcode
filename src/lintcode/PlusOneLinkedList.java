package lintcode;

public class PlusOneLinkedList {
	/**
     * @param head: the first Node
     * @return: the answer after plus one
     */
    public ListNode plusOne(ListNode head) {
        // Write your code here
    	int carries = dfs(head);
    	if (carries == 1) {
    		ListNode dummyNode = new ListNode(1);
    		dummyNode.next = head;
    		return dummyNode;
    	}
    	return head;
    }
    
    private int dfs(ListNode node) {
    	if (node.next == null) {
    		node.val += 1;
    		if (node.val > 9) {
    			node.val -= 10;
    			return 1;
    		}
    		return 0;
    	}
    	node.val += dfs(node.next);
    	if (node.val > 9) {
    		node.val -= 10;
    		return 1;
    	}
    	return 0;
    }
}
