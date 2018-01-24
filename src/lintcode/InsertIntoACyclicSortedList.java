package lintcode;

public class InsertIntoACyclicSortedList {
    /**
     * @param node a list node in the list
     * @param x an integer
     * @return the inserted new list node
     */
    public ListNode insert(ListNode node, int x) {
        // Write your code here
        if (node == null) {
            node = new ListNode(x);
            node.next = node;
            return node;
        }
        ListNode first = node;
        node = node.next;
        ListNode nextNode = node.next;
        while (! (((node.val <= x) && (x <= nextNode.val)) || (node == first))) {
            node = nextNode;
            nextNode = node.next;
        }
        ListNode newNode = new ListNode(x);
        node.next = newNode;
        newNode.next = nextNode;
        return node;
    }
}
