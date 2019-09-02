package leetcode;

public class LinkedListRemoveDuplicatesfromSortedList{
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode pre = head;
        ListNode cur = head.next;;
        while (cur!=null){
            if(cur.val==pre.val){
                if(cur.next==null){
                    pre.next=null;
                    break;
                }
                else{
                    cur = cur.next;
                }
            }
            else{
                pre.next = cur;
                pre = pre.next;
                cur = cur.next;
            }
        }
        return head;
    }
    //my method
    public ListNode DeleteDuplicates(ListNode head) {
        ListNode node = head;
        while (node != null && node.next != null) {
            if (node.val == node.next.val){
                node.next = node.next.next;
            } 
            else{
                node = node.next;
            } 
        }
        return head;
    }
    //concise method
}