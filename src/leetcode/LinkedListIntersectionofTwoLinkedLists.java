package leetcode;

import java.util.HashSet;

//A:          a1 → a2
//                   ↘
//                     c1 → c2 → c3
//                   ↗            
//B:     b1 → b2 → b3
//function should return c1
public class LinkedListIntersectionofTwoLinkedLists{
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA==null||headB==null){
            return null;
        }   
        ListNode A = headA;
        ListNode B = headB;
        while (headA!=headB){
            headA = headA==null?B:headA.next;
            headB = headB==null?A:headB.next;
        }
        return headA;
    }
    //for two pointers, if they meet, they must visited same hops
    //             <-----------------------             
    //            |                      |
    //A:          a1 → a2                |
    //                   ↘               |
    //                     c1 → c2 → c3-->
    //                   ↗               |
    //B:     b1 → b2 → b3                |
    //       |                           |
    //        <----------------------------
    public ListNode GetIntersectionNode(ListNode headA, ListNode headB) {
        if (headA==null||headB==null){
            return null;
        }
        ListNode preA = new ListNode(0);
        preA.next=headA;
        ListNode preB = new ListNode(0);
        preB.next=headB;
        HashSet<ListNode> set = new HashSet<>();
        while (!set.contains(headA)&&!set.contains(headB)){
            if (preA!=null){
                set.add(preA.next);
                preA=preA.next==null?new ListNode(0):preA;
            }
            if (preB!=null){
                set.add(preB.next);
            }
        }
        return set.contains(headA)?headA:headB;
    }
}