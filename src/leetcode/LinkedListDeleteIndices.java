package leetcode;

public class LinkedListDeleteIndices{
    public ListNode deleteNodes(ListNode head, int[] indices) {
        int len = getlength(head);
        int offset = 0;
        for (int index:indices){
            if (index-offset >= len){
                return head;
            }
            else {
                head = deleteone(head,index-offset);
                offset++;
                len--;
            }
        }
        return head;
    }
    public ListNode deleteone(ListNode head, int index){
        if (head==null){
            return null;
        }
        else {
            int i = 0;
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode prev = dummy;
            while (i<index){
                prev = prev.next;
                i++;
            }
            prev.next = prev.next.next;
            return dummy.next;
        }
    }
    public int getlength(ListNode head){
        int len = 0;
        while (head!=null){
            len++;
            head = head.next;
        }
        return len;
    }
}