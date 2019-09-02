package leetcode;

//reverse every k nodes. the last n nodes(n<k) remain original order
//Given this linked list: 1->2->3->4->5
//For k = 2, you should return: 2->1->4->3->5
//For k = 3, you should return: 3->2->1->4->5
public class LinkedListReverseNodesinKGroup{
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head==null||head.next==null||k==1){
            return head;
        }
        ListNode orig = new ListNode(0);
        orig.next = head;
        ListNode prev = orig;
        while (prev!=null && prev.next!=null){
            prev = reverseNextKnodes(prev, k);
        }                    
        return orig.next;                                           
    }
    public ListNode reverseNextKnodes(ListNode prev, int k){
        ListNode curr = prev.next;
        ListNode head = curr;
        ListNode tail = head;
        for (int i=1;i<k;i++){
            curr = curr.next;
            if (curr==null){
                return null;
            }
        }
        ListNode after = curr.next;
        for (int i=0;i<k;i++){
            ListNode next = head.next;
            head.next = after;
            after = head;
            head = next;
        }
        prev.next = after;
        return tail;
    }
    public ListNode ReverseNextKnodes(ListNode prev, int k) {
        ListNode nexthead = prev;
        for (int i=0;i<=k;i++){
            nexthead = nexthead.next;
            if (i!=k && nexthead==null){
                return null;
            }
        }
        ListNode tail = prev.next;
        ListNode curr = prev.next.next;
        while (curr!=nexthead){
            ListNode temp = curr.next;
            curr.next = prev.next;
            prev.next = curr;
            tail.next = temp;
            curr = temp;
        }
        return tail; 
    }
}