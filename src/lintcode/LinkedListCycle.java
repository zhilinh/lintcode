package lintcode;

import java.util.HashMap;
import java.util.Map;

public class LinkedListCycle {
    /**
     * @param head: The first node of linked list.
     * @return: True if it has a cycle, or false
     */
    public boolean hasCycle(ListNode head) {  
        // write your code here
        if (head == null) {
            return false;
        }
        Map<ListNode, Boolean> map = new HashMap<ListNode, Boolean>();
        while (head.next != null) {
            if (map.containsKey(head)) {
                return true;
            } else {
                map.put(head, true);
                head = head.next;
            }
        }
        return false;
    }
}
