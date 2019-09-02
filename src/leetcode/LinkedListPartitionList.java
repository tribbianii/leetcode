package leetcode;

//given a list, and an integer x
//al nodes with value less than x should be arranged before ones
//with values greater or equal to x
//within each partition, original order should remain
//Input: head = 1->4->3->2->5->2, x = 3
//Output: 1->2->2->4->3->5
public class LinkedListPartitionList{
    public ListNode partition(ListNode head, int x) {
        ListNode Lhead = new ListNode(0);
        ListNode Rhead = new ListNode(0);
        ListNode Ltail = Lhead;
        ListNode Rtail = Rhead;
        while (head!=null){
            if (head.val < x){
                Ltail.next = head;
                Ltail = Ltail.next;
            }
            else{
                Rtail.next = head;
                Rtail = Rtail.next;
            }
            head = head.next;
        }
        Ltail.next = Rhead.next;
        Rtail.next = null;
        return Lhead.next;   
    }
}