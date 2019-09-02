package leetcode;

//use iterative insertion to sort list
public class LinkedListInsertionSortList{
    public ListNode insertionSortList(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        ListNode prev = new ListNode(0);
        prev.next = head;
        ListNode node = head;
        while (node!=null&&node.next!=null){
            if (node.val<=node.next.val){
                node = node.next;
            }
            else {
                ListNode curr = node.next;
                ListNode temp1 = prev;
                while (temp1.next.val < curr.val){
                    temp1 = temp1.next;
                }
                ListNode temp2 = curr.next;
                node.next = temp2;
                curr.next = temp1.next;
                temp1.next = curr;
            }
        }
        return prev.next;   
    }
}