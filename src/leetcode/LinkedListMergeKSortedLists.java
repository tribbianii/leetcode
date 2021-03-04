package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LinkedListMergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null||lists.length==0){
            return null;
        }
        if (lists.length==1){
            return lists[0];
        }
        ListNode res = lists[0];
        for(int i=1;i<lists.length;i++){
            res = MergeTwoLists(res, lists[i]);
        }    
        return res;
    }
    public ListNode MergeTwoLists(ListNode node1, ListNode node2) {
        if (node1 != null && node2 != null) {
            ListNode node = node1.val <= node2.val ? node1 : node2;
            node.next = node == node1 ? MergeTwoLists(node1.next, node2) : MergeTwoLists(node1, node2.next);
            return node;
        }
        return node1 == null ? node2 : node1;
    }
    //this method merge lists one by one, slow

    //following are couple of ways to implement Comparator to order elements
    //so that ones with lower value has higher priority which means to get polled earlier
    
    //class NodeComparator implements Comparator<ListNode>{
    //    @Override
    //    public int compare(ListNode a, ListNode b){
    //        return a.val - b.val;
            //ascending order
    //    }
        //above function compare equals to following
        //change the positions of a and b will cause descending order
        //public int compare(ListNode a, ListNode b) { 
        //    if (a.val < b.val){
        //        return -1;
        //    } 
        //    else if (a.val > b.val){
        //        return 1;
        //    }
        //    return 0; 
        //    }
    //}
    public ListNode mergeKlists(ListNode[] lists){
        if (lists == null||lists.length == 0){
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>(){
            @Override
            public int compare(ListNode a, ListNode b){
                if (a.val == b.val) {
                    return 0;
                }
                return a.val > b.val ? 1 : -1;
            }
        });
        for (int i = 0;i < lists.length;i ++){
            if (lists[i] != null){
                pq.add(lists[i]);
            }
        }
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            prev.next = node;
            prev = prev.next;
            if (node.next != null){
                pq.add(node.next);
            }
        }
        return dummy.next;
    }
    //this method use priority queue
    //to order nodes according to thier value
    //min get pop out first then min.next get added
}