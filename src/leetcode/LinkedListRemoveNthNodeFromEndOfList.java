package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LinkedListRemoveNthNodeFromEndOfList{
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int i =0;
        Map<Integer, ListNode> table = new HashMap<>();
        ListNode node = head;
        while (node!=null){
            i++;
            table.put(i, node);
            node=node.next;
        }
        if (i==1){
            return null;
        }
        if (i==n){
            return head.next;
        }
        ListNode pre = table.get(i-n);
        if (n==1){
            pre.next = null;
        }
        else{
            pre.next = pre.next.next;
        }
        return table.get(1);
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