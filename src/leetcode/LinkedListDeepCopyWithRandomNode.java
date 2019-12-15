package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LinkedListDeepCopyWithRandomNode {
    public ListNode deepCopy (ListNode root) {
        if (root == null) {
            return null;
        }
        Map<ListNode, ListNode> map = new HashMap<>();
        ListNode newhead = new ListNode(root.val);
        map.put(root, newhead);
        ListNode curr = newhead;
        while (root != null) {
            if (root.next != null) {
                if (!map.containsKey(root.next)) {
                    map.put(root.next, new ListNode(root.next.val));
                }
                curr.next = map.get(root.next);
            }
            if (root.random != null) {
                if (!map.containsKey(root.random)) {
                    map.put(root.random, new ListNode(root.random.val));
                }
                curr.random = map.get(curr.random);
            }
            root = root.next;
            curr = curr.next;
        }
        return newhead;
    }
    //recursion solution
    HashMap<ListNode, ListNode> visited = new HashMap<>();
    public ListNode recursiveCopy (ListNode root) {
        if (root == null) {
            return null;
        }
        if (!visited.containsKey(root)) {
            visited.put(root, new ListNode(root.val));
        }
        ListNode copy = visited.get(root);
        copy.next = recursiveCopy (root.next);
        copy.random = recursiveCopy (root.random);
        return visited.get(root);
    }
}