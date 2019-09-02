package leetcode;

public class LinkedListRemoveLinkedListElements{
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while (pre.next != null) {
            if (pre.next.val == val){
                pre.next = pre.next.next;
            }
            else{
                pre = pre.next;
            } 
        }
        return dummy.next;
    }
}