package leetcode;

public class LinkedListReverseLinkedList{
    //iteration solution
    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while (curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    //null-->1-->2-->3
    //null<--1-->2-->3
    //null<--1<--2-->3
    //null<--1<--2<--3
    
    //recursion solution
    public ListNode reverselist(ListNode head){
        if (head==null || head.next==null){
            return head;
        }
        ListNode curr = head;
        ListNode tail = reverselist(head.next);
        curr.next.next = head;
        curr.next = null;
        return tail;
    }
    //---------------------------------------------
    //(from)          |
    //        node1-->|node2-->node3-->node4-->null
    //        (curr)  |(next)
    //---------------------------------------------
    //(to)            |
    // null<--node1<--|node2<--node3<--node4
    //        (curr)  |(next)
    //---------------------------------------------
    //base case: head==null || head.next==null
    //What does it do to solve every subproblem?
    // 1:next.next = curr
    // 2:curr.next = null
    // Note: keep tail as new head and return it

    //recursive idea solve follow-up question
    public ListNode reverseListBypair(ListNode head){
        if (head==null || head.next==null){
            return head;
        }
        ListNode newhead = reverseListBypair(head.next.next);
        ListNode temp = head.next;
        temp.next = head;
        head.next = newhead;
        return temp;
    }
}