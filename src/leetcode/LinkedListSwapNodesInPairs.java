package leetcode;

//Given 1->2->3->4, you should return the list as 2->1->4->3
public class LinkedListSwapNodesInPairs{
    public ListNode swapPairs(ListNode head) {
        if (head==null){
            return null;
        }
        ListNode orig = new ListNode(0);
        orig.next = head;
        //use orig.next to track changing head of list
        ListNode cur = orig;
        while (cur.next!=null&&cur.next.next!=null){
            swap(cur);
            cur = cur.next.next;
        }
        return orig.next;
    }
    public static void swap(ListNode prev){
        ListNode temp = prev.next;
        prev.next = temp.next;
        temp.next = temp.next.next;
        prev.next.next = temp;
    }
}