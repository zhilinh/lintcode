package lintcode;

import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {
	
	/**
	public class NodeComparator implements Comparator<ListNode> {
		@Override
		public int compare(ListNode o1, ListNode o2) {
			return o1.val - o2.val;
		}
	}
	*/
	
	/**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {
        // write your code here
    	// Comparator<ListNode> comparator = new NodeComparator();
    	
    	PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
    	iterateList(lists, queue);
    	
    	ListNode dummyNode = new ListNode(0);
    	ListNode start = dummyNode;
    	while (!queue.isEmpty()) {
    		dummyNode.next = new ListNode(queue.poll());
    		dummyNode = dummyNode.next;
    	}
    	return start.next;
    }
    
    public void iterateList(List<ListNode> lists, PriorityQueue<Integer> queue) {
    	boolean isEmpty = true;
    	for (int i = 0; i < lists.size(); i++) {
    		ListNode node = lists.get(i);
    		if (node != null) {
    			isEmpty = false;
    			queue.add(node.val);
    			lists.set(i, node.next);
    		}
    	}
    	if (!isEmpty) {
    		iterateList(lists, queue);
    	}
    }
}