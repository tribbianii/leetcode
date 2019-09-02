package leetcode;

public class LinkedListRotateList{
    public ListNode rotateRight(ListNode head, int k) {
        if (head==null||head.next==null){
            return head;
        }
        int length = 1;
        ListNode tail = head;
        while (tail.next!=null){
            tail = tail.next;
            length++;
        }
        //find the length of list
        k = k%length;
        //find the equivalent rotate times
        if (k==0){
            return head;
        }
        ListNode prev = new ListNode(0);
        prev.next = head;
        ListNode newhead = head;
        while (length-k>=1){
            prev = prev.next;
            newhead = newhead.next;
            k++;
        }
        tail.next = head;
        //connenct the last with head
        prev.next = null;
        //cut the connection of newhead and previous
        return newhead;
    }
}