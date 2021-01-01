package leetcode;

import java.util.HashMap;
import java.util.Map;

public class DesignLFUCache {
    static class Node{
        int key;
        int val;
        int fre;
        Node prev;
        Node next;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.fre = 1;
        }
    }

    Node head;
    Node tail;
    int size;
    int cap;
    Map<Integer, Node> map;

    public DesignLFUCache(int capacity) {
        this.cap = capacity;
        this.size = 0;
        this.map = new HashMap<Integer, Node>();
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key) && map.get(key) != null) {
            Node node = map.get(key);
            node.fre = node.fre + 1;
            reorder(key);
            return map.get(key).val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (!map.containsKey(key) || map.get(key) == null) {
            if (!cutLFU()) {
                return;
            }
            Node node = new Node(key, value);
            tail.prev.next = node;
            node.prev = tail.prev;
            node.next = tail;
            tail.prev = node;
            map.put(key, node);
            size ++;
        } else {
            Node node = map.get(key);
            node.val = value;
            node.fre = node.fre + 1;
        }
        reorder(key);
    }

    public void reorder(int key) {
        Node node = map.get(key);
        if (node.prev != head && node.prev.fre <= node.fre) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            Node prev = node;
            while (prev != head && prev.fre <= node.fre) {
                prev = prev.prev;
            }
            prev.next.prev = node;
            node.next = prev.next;
            prev.next = node;
            node.prev = prev;
        }
    }

    public boolean cutLFU() {
        try {
            if (size == cap) {
                Node node = tail.prev;
                node.prev.next = tail;
                tail.prev = node.prev;
                map.put(node.key, null);
                size --;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
