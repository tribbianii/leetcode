package leetcode;

import java.util.HashSet;

public class LinkedListCycle{
    public boolean hasCycle(ListNode head) {
        if (head==null||head.next==null){
            return false;
        }
        HashSet<ListNode> set = new HashSet<>();
        while (head!=null){
            set.add(head);
            if (set.contains(head.next)){
                return true;
            }
            head = head.next;
        }
        return false;
    }
    //method 1 use hashset(extra space) to store and determine
    //whether a certain node has already been visited
    public boolean HasCycle(ListNode head){
        if (head==null||head.next==null){
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast!=null&&fast.next!=null){
            if(fast==slow){
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }
    //method 2 use two pointer(ListNode) to visit the list
    //if no cycle, then fast one should get to null firstly
    //if cycle exist, then sooner or later two pointers will meet
    //slow move one step each time and fast move two 
}