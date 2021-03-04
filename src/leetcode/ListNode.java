package leetcode;

public class ListNode {
    ListNode next;
    ListNode random;
    int val;
    ListNode(int x){
        val=x;
    }
    ListNode(int x, ListNode next) {
        this.val = x;
        this.next = next;
    }
}
