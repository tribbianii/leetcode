package leetcode;

import java.util.ArrayList;

public class LinkedListSortList{
    //top-down method to merge two sorted halves
    //which are merged from two 1/4 list, and so on...
    //time complexity: O(nlog(n))
    //space complexity: O(log(n))
    public ListNode sortList(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        ListNode slow = head; 
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        return MergeTwoLists(sortList(head),sortList(mid));
    }
    public ListNode MergeTwoLists(ListNode node1, ListNode node2) {
        if (node1==null||node2==null){                 
            return node1==null?node2:node1;
        }
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        while (node1!=null&&node2!=null){
            if (node1.val<=node2.val){
                prev.next = node1;
                node1 = node1.next;
            }
            else {
                prev.next = node2; 
                node2 = node2.next;
            }
            prev = prev.next;
        }
        prev.next = node1==null?node2:node1;
        return dummy.next;
    }
    //bottom-up
    //first, size=1, sort (1,2),(3,4),(5,6)...
    //then, size=2, sort (1,2,3,4),(5,6,7,8)...
    //...
    ///finally, sort (half_1,half_2)
    //time complexity: O(nlog(n))
    //space complexity: O(1) 
    public ListNode SortList(ListNode head){
        if (head==null||head.next==null){
            return head;
        }
        int len = 0;
        ListNode curr = head;
        while (curr!=null){
            curr = curr.next;
            len++;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        for (int n=1;n<len;n=n*2){
            curr = dummy.next;
            ListNode tail = dummy;
            while (curr!=null){
                ListNode left = curr;
                ListNode right = split(left,n);
                curr = split(right,n);
                ArrayList<ListNode> merged = merge(left,right);
                tail.next = merged.get(0);
                tail = merged.get(1);
            }
        }
        return dummy.next;
    }
    private ListNode split(ListNode head, int n){
        while (n>1&&head!=null){
            head = head.next;
            n--;
        }
        ListNode half = head==null?null:head.next;
        if (head!=null){
            head.next = null;
        }
        return half;
    }
    private ArrayList<ListNode> merge(ListNode half1, ListNode half2){
        ArrayList<ListNode> res = new ArrayList<>();
        ListNode dummy = new ListNode(0);
        ListNode tail  = dummy;
        while (half1!=null && half2!=null){
            if (half1.val <= half2.val){
                tail.next = half1;
                half1 = half1.next;
            }
            else {
                tail.next = half2;
                half2 = half2.next;
            }
            tail = tail.next;
        }
        tail.next = half1==null?half2:half1;
        while (tail.next!=null){
            tail = tail.next;
        }
        res.add(dummy.next);
        res.add(tail);
        return res;
    }
}