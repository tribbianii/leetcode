package leetcode;

//reverse every k nodes. the last n nodes(n<k) remain original order
//Given this linked list: 1->2->3->4->5
//For k = 2, you should return: 2->1->4->3->5
//For k = 3, you should return: 3->2->1->4->5
public class LinkedListReverseNodesinKGroup{
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        // find the first one of next k nodes
        // do nothing if less than k nodes remain
        ListNode nextHead = head;
        for (int i = 0; i < k; i ++) {
            nextHead = nextHead.next;
            if (i < k - 1 && nextHead == null) {
                return head;
            }
        }
        // reverse from head to the node before nextHead
        ListNode prev = head;
        ListNode curr = prev.next;
        while (curr != nextHead) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        // connect the original head which became tail of this k nodes
        // to the new head of next k nodes
        head.next = reverseKGroup(nextHead, k);
        return prev;
    }
}