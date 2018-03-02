package lintcode;

public class ReverseLinkedList {
	/*
     * @param head: n
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        // write your code here
    	ListNode now = head;
    	ListNode next = null;
    	ListNode last = null;
    	while (now != null) {
    		next = now.next;
    		now.next = last;
    		last = now;
    		now = next;
    	}
    	return last;    	
    }
}
