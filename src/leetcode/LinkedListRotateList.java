package leetcode;

public class LinkedListRotateList{
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int len = 1;
        ListNode tail = head;
        while (tail.next != null) {
            len ++;
            tail = tail.next;
        }
        int realK = k % len;
        if (realK == 0) {
            return head;
        }
        tail.next = head;
        while (len > realK + 1) {
            head = head.next;
            realK ++;
        }
        ListNode newHead = head.next;
        head.next = null;
        return newHead;
    }
}