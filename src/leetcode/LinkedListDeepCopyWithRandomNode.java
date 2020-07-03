package leetcode;

import java.util.HashMap;
import java.util.Map;
//refer to more general problem -> graphDeepCopy
public class LinkedListDeepCopyWithRandomNode {
    // BFS much faster
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
                curr.random = map.get(root.random);
            }
            root = root.next;
            curr = curr.next;
        }
        return newhead;
    }
    //DFS solution
    static HashMap<ListNode, ListNode> visited = new HashMap<>();
    public static ListNode recursiveCopy (ListNode root) {
        if (root == null) {
            return null;
        }
        if (!visited.containsKey(root)) {
            visited.put(root, new ListNode(root.val));
            ListNode copy = visited.get(root);
            copy.next = recursiveCopy (root.next);
            copy.random = recursiveCopy (root.random);
        }
        return visited.get(root);
    }
    //leetcode Node class implementation
    static class Node {
        public int val;
        public Node next;
        public Node random;
    
        public Node() {}
    
        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }
    //another DFS solution
    static HashMap<Node, Node> visitedd = new HashMap<Node, Node>();
    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (visitedd.containsKey(head)) {
            return visitedd.get(head);
        }
        Node node = new Node(head.val, null, null);
        visitedd.put(head, node);
        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);
        return node;
    }

    public static void main(String[] args) {
        Node node = new Node(0, null, null);
        node.next = new Node(1, null, null);
        node.random = new Node(2, null, null);
        node.next.next = node.random;
        node.random.next = new Node(3, null, null);
        System.out.println(copyRandomList(node).random.val);
    }
}