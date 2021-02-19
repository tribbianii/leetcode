package leetcode;

//Input: 1->2->4, 1->3->4
//Output: 1->1->2->3->4->4
public class LinkedListMergeTwoSortedLists{
    public ListNode MergeTwoLists(ListNode node1, ListNode node2) {
        if (node1 != null && node2 != null) {
            if (node1.val <= node2.val) {
                node1.next = mergeTwoLists(node1.next, node2);
                return node1;
            } else {
                node2.next = mergeTwoLists(node1, node2.next);
                return node2;
            }
        } else {
            return node1 != null ? node1 : node2;
        }
    }
    //recursive method
    public ListNode mergeTwoLists(ListNode node1, ListNode node2) {
        if (node1 == null || node2 == null) {
            return node1 == null ? node2 : node1;
        }
        ListNode res = new ListNode(0);
        ListNode pre = res;
        while (node1 != null && node2 != null) {
            if (node1.val <= node2.val) {
                pre.next = new ListNode(node1.val);
                node1 = node1.next;
            } else {
                pre.next = new ListNode(node2.val);
                node2 = node2.next;
            }
            pre = pre.next;
        }
        pre.next = node1 == null ? node2 : node1;
        return res.next;
    }
    //my method
}