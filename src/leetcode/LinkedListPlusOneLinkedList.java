package leetcode;

//Input: [1,2,3]
//Output: [1,2,4]

public class LinkedListPlusOneLinkedList{
    public ListNode plusOne(ListNode head) {
        if (head==null){
            return null;
        }
        ListNode orig = new ListNode(0);
        orig.next = head;
        ListNode lastnot9 = orig;
        ListNode node =head;
        while (node!=null){
            if (node.val!=9){
                lastnot9 = node;
            }
            node = node.next;
        }
        lastnot9.val++;
        node = lastnot9.next;
        while (node!=null){
            node.val=0;
            node=node.next;
        }
        return orig.val==0?orig.next:orig;
    }
}