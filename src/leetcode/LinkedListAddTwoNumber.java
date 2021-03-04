package leetcode;

public class LinkedListAddTwoNumber {
    // recursion
    public int carry = 0;
    public ListNode AddTwoNumbers(ListNode l1, ListNode l2) {
        boolean isNull1 = l1 == null;
        boolean isNull2 = l2 == null;
        if (carry == 0 && (isNull1 || isNull2)) {
            return l1 == null ? l2 : l1;
        }
        int val = carry + (isNull1 ? 0 : l1.val) + (isNull2 ? 0 : l2.val);
        ListNode node = new ListNode(val % 10);
        carry = val / 10;
        node.next = addTwoNumbers(isNull1 ? null : l1.next, isNull2 ? null : l2.next);
        return node;
    }
    // iterative one
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode l3 = res;
        int sum = 0;
        while (l1!=null||l2!=null){
            sum /=10;
            sum = sum+(l1==null?0:l1.val)+(l2==null?0:l2.val);
            ListNode temp = new ListNode(sum%10);
            l3.next = temp;
            l1=l1==null?null:l1.next;
            l2=l2==null?null:l2.next;
            l3=temp;
            if (sum>=10&&l1==null&&l2==null){
                ListNode highest = new ListNode(1);
                l3.next = highest;
            }
        }
        return res.next;
    }
    //note: the value of node can't be modified once initialized
    //new node should be initialized with new value and appended after current one
}
