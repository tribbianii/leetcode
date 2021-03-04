package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LinkedListRemoveNthNodeFromEndOfList{
    //my genius solution
    public int index;
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            index = 0;
            return null;
        }
        head.next = removeNthFromEnd(head.next, n);
        index ++;
        return index == n ? head.next : head;
    }
    //my method. really shouldn't have used map
    public ListNode RemoveNthFromEnd(ListNode head, int n){
        ListNode orig = new ListNode(0);
        orig.next = head;
        ListNode curr = head;
        ListNode prev = orig;
        for (int i=1;i<=n;i++){
            curr = curr.next;
        }
        while (curr!=null){
            curr = curr.next;
            prev = prev.next;
        }
        prev.next = prev.next.next;
        return orig.next;
    }
    //the final step must be k.next=k.next.next
    //there must be (n-1) nodes between k and tail
    //create two pointers having (n-1) nodes in between
    //move them forward till fast one reach null
}