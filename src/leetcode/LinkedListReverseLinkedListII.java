package leetcode;

public class LinkedListReverseLinkedListII{
    //following solution is little bit slower but easier to understand
    //step 1: set mm.next pointing to the node after reverse part
    //step 2: reverse mm to nn
    //step 3: set before.next pointing to new head of reverse part
    //             ———————————————————————————>
    //             |                          |   
    // aa ——> bb   mm <—— jj <—— kk <—— nn   zz ——> null
    //        |                          |                   
    //        ———————————————————————————>
    public ListNode ReverseBetween(ListNode head, int m, int n){
        if (head==null||head.next==null||m==n){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode mm = dummy;
        ListNode nn = dummy;
        //find the node before reverse part: before
        //find the node starting reverse: mm
        for (int i=0;i<m-1;i++){
            mm = mm.next;
        }
        ListNode before = mm;
        mm = mm.next;
        //find the node ending reverse: nn
        //find the node after reverse part: after
        for (int i=0;i<n;i++){
            nn = nn.next;
        }
        ListNode after = nn.next;
        //set nn.next pointing to after
        //reverse node from nn to mm
        while (m<=n){
            ListNode next = mm.next;
            mm.next = after;
            after = mm;
            mm = next;
            m++;
        }
        //set before.next pointing to new head of reverse part: after
        before.next = after;
        return dummy.next;
    }
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m>n||head==null){
            return null;
        }
        if (m==n){
            return head;
        }
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode prev = temp;
        ListNode mm = head;
        ListNode nn = head;
        for (int i=1;i<m;i++){
            mm = mm.next;
            prev = prev.next;
        }   
        for (int i=1;i<n;i++){
            nn = nn.next;
        }
        while (mm!=nn){
            prev.next = mm.next;
            mm.next = nn.next;
            nn.next = mm;
            mm = prev.next;
            //general idea is to insert mm behind nn till they meet
            //1-->2-->3-->4-->5(eg.m=2,n=4)
            //1(prev)-->2(mm)-->3-->4(nn)-->5
            //1(prev)-->3(mm)-->4(nn)-->2-->5
            //1(prev)-->4(mm,nn)-->3-->2-->5
        }
        return temp.next;
        //OR we can return m==1?mm:head
        //if m==1 means the new list's head will be different
        //note: can't return head 'cause new head may be different
        //head always refers to orignal head and temp.next refers to new one
    } 
}