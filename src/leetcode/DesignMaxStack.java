package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class DesignMaxStack {
    static class Node {
        int val;
        Node prev;
        Node next;
        Node(int value) {
            this.val = value;
        }
    }
    // TreeMap sort entry by the natural sorting of key
    TreeMap<Integer, List<Node>> map;
    Node head;
    Node tail;

    public DesignMaxStack() {
        this.map = new TreeMap<Integer, List<Node>>();
        this.head = new Node(0);
        this.tail = new Node(0);
        head.next = tail;
        tail.prev = head;
    }

    public void push(int x) {
        Node node = new Node(x);
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
        if (!map.containsKey(x)) {
            map.put(x, new ArrayList<Node>());
        }
        map.get(x).add(node);
    }

    public int pop() {
        int val = tail.prev.val;
        delete(val);
        return val;
    }

    public int top() {
        return tail.prev.val;
    }

    public int peekMax() {
        return map.lastKey();
    }

    public int popMax() {
        int max = map.lastKey();
        delete(max);
        return max;
    }

    public void delete(int value) {
        List<Node> list = map.get(value);
        Node node = list.remove(list.size() - 1);
        if (list.isEmpty()) {
            map.remove(node.val);
        }
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
