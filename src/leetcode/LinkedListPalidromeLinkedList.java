package leetcode;

//Input: 1->2
//Output: false
//Input: 1->2->2->1
//Output: true

public class LinkedListPalidromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode left = head;
        ListNode right = reverse(slow.next);
        while (left != null && right != null) {
            if (left.val != right.val) {
                return false;
            } else {
                left = left.next;
                right = right.next;
            }
        }
        return true;
    }

    // general idea: 1->2->3->4->3->2->1->null(original)
    // find the head of right half and reverse that part:
    // 1->2->3->4->1->2->3->null(modified)
    // two pointers: one from head and one from head of right half, compare their
    // values
    // note: get familiar about how to reverse a linked list
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}