package leetcode;

public class LinkedListAddTwoNumber {
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
