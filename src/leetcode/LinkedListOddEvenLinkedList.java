package leetcode;

public class LinkedListOddEvenLinkedList{
    public ListNode oddEvenList(ListNode head) {
        if(head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenhead = even;
        while (even!=null){
            odd.next = even.next;
            odd = odd.next;
            //order in odd nodes group
            even.next = odd.next;
            even = even.next;
            //order in even nodes group
        }
        odd.next = evenhead;
        //connect odd group's tail to even group's head
        return head;
    }
}