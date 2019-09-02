package leetcode;

import java.util.HashSet;

//find the start of loop if exist
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head==null||head.next==null){
            return null;
        }
        HashSet<ListNode> set = new HashSet<>();
        while (head!=null){
            set.add(head);
            if (set.contains(head.next)){
                return head.next;
            }
            head = head.next;
        }
        return null;
    }
    //method 1 
    public ListNode DetectCycle(ListNode head){
        if (head==null||head.next==null){
            return null;
        }
        ListNode fast = head.next;
        ListNode slow_1 = head;
        ListNode slow_2 = head;
        while (fast!=null&&fast.next!=null){
            if(fast==slow_1){
                while (slow_1!=slow_2&&slow_1.next!=slow_2){
                    //note:slow_1.next!=slow_2
                    //to avoid eg.1<-->2 
                    slow_1 = slow_1.next;
                    slow_2 = slow_2.next;
                }
                return slow_2;
            }
            fast = fast.next.next;
            slow_1 = slow_1.next;
        }     
        return null;
    }
    //method 2
    //         a        b 
    //start ------->-------->meeting
    //             |         |
    //             <----------
    //                  c
    //assume fast and slow meets at k steps
    //k=a+b+r1(b+c) slow runs r1 cycles
    //2k=a+b+r2(b+c) fast runs r2 cycles
    //2k=a+b+r2(b+c)=2a+2b+2r1(b+c)
    //(b+c)(r2-2r1)=a+b => (b+c)n=a+b
    //a=(n-1)b+nc=(n-1)(b+c)+c which means when slow moves (n-1) cycles and c, start moves a
}