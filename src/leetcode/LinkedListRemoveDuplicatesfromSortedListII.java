package leetcode;

public class LinkedListRemoveDuplicatesfromSortedListII{
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        ListNode orig =new ListNode(-1);
        orig.next = head;
        ListNode prev = orig;
        ListNode curr = head;
        while (curr!=null){
            while (curr.next!=null&&curr.val==curr.next.val){
                curr = curr.next;
            }
            if (prev.next!=curr){
                prev.next = curr.next;
                //in case of head got deleted
                //prev.next need to point to new head
            }
            else {
                prev = prev.next;
            }
            curr = curr.next;
        }
        return orig.next;  
    }
}