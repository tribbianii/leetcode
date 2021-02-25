package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListInsertIntoCyclicSortedList {
    Set<ListNode> visited = new HashSet<ListNode>();
    public ListNode insert(ListNode head, int insertVal) {
        if (head == null) {
            ListNode ListNode = new ListNode(insertVal, null);
            ListNode.next = ListNode;
            return ListNode;
        }
        if (visited.contains(head)) {
            return new ListNode(insertVal, head);
        }
        if (insertVal >= head.val && insertVal <= head.next.val
                || insertVal >= head.val && head.val > head.next.val
                || insertVal <= head.next.val && head.val > head.next.val) {
            head.next = new ListNode(insertVal, head.next);
            return head;
        }
        visited.add(head);
        head.next = insert(head.next, insertVal);
        return head;
    }
}
