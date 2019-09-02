package leetcode;

//Given 1->2->3->4->5, reorder it to 1->5->2->4->3
public class LinkedListReorderList{
    public void reorderList(ListNode head) {
        if (head==null||head.next==null||head.next.next==null) {
            return;
        }
        ListNode slow = head; 
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;                                                                                                                                                                                                                    
        }
        //1->2->3->4->3->2->1(original)
        //1->2->3->4(slow)->3->2->1->null(fast)
        ListNode mid = reverse(slow.next);
        //head: 1->2->3->4(slow)->3->2->1
        //mid: 1->2->3->null
        slow.next = null;
        //head: 1->2->3->4->null
        //note: key step! without it result would be:
        //1->1->2->2->3->3->4(slow)->3->2->1(wrong answer)
        //should be 1->1->2->2->3->3->4(true answer)
        while (head != null && mid != null) {
        //Or while (head != null && mid != null)
        //because mid list must no longer than head    
            ListNode temp1 = head.next;
            ListNode temp2 = mid.next;
            mid.next = temp1;
            head.next = mid;
            head = temp1;                                             
            mid = temp2;             
        }
    }
    private ListNode reverse(ListNode head){
        ListNode prev = null;
        while (head!=null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}