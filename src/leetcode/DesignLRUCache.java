package leetcode;

import java.util.HashMap;
import java.util.Map;

class DesignLRUCache {
    class DListNode {
        int key;
        int value;
        DListNode prev;
        DListNode next;
        DListNode (int key, int val) {
            this.key = key;
            this.value = val;
            this.prev = null;
            this.next = null;
        }
    }
    // Design a cache with records stored in between head and tail
    // most recently read cache stored next to head
    Map<Integer, DListNode> map;
    DListNode head;
    DListNode tail;
    int capacity;
    int size;
    // initialize cache
    public DesignLRUCache(int capacity) {
        this.map = new HashMap<Integer, DListNode>();
        this.head = new DListNode(0, 0);
        this.tail = new DListNode(0, 0);
            head.next = tail;
            tail.prev = head;
        this.capacity = capacity;
        this.size = 0;
    }
    // read cache
    public int get(int key) {
        if (map.containsKey(key)) {
            prioritize(key, false);
            return map.get(key).value;
        }
        return -1;
    }
    // update/insert cache
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.get(key).value = value;
            prioritize(key, false);
        } else {
            if (size == capacity) {
                cutLast();
            }
            map.put(key, new DListNode(key, value));
            prioritize(key, true);
            size ++;
        }
    }
    // prioritize most recently read cache
    // by moving it next to head
    public void prioritize(int key, boolean new_added) {
        DListNode node = map.get(key);
        if (node != head.next) {
            if (!new_added) {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
            DListNode first = head.next;
            node.next = first;
            first.prev = node;
            head.next = node;
            node.prev = head;
        }
    }
    // remove least recently used cache
    public void cutLast() {
        DListNode last = tail.prev;
        map.remove(last.key);
        tail.prev = last.prev;
        last.prev.next = tail;
        size--;
    }
    //another solution with more divided functionalities
    /*
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
    }

    private Map<Integer, DLinkedNode> map = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head;
    private DLinkedNode tail;

    public DesignLRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;

        head = new DLinkedNode();
        tail = new DLinkedNode();

        head.next = tail;
        tail.prev = head;
    }
    
    private void addNode(DLinkedNode node) {

        // Always add the new node right after head.

        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
        
        map.put(node.key, node);
        
        size ++;
    }

    private void removeNode(DLinkedNode node){

        // Remove an existing node from the linked list.

        DLinkedNode prev = node.prev;
        DLinkedNode next = node.next;

        prev.next = next;
        next.prev = prev;
        
        map.remove(node.key);
        
        size --;
    }

    private void moveToHead(DLinkedNode node){

        // Move certain node in between to the head.

        removeNode(node);
        addNode(node);
    }

    public int get(int key) {
        DLinkedNode node = map.get(key);
        if (node == null) {
            return -1;
        }
        // move the accessed node to the head;
        moveToHead(node);

        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = map.get(key);

        if(node == null) {
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;

            addNode(newNode);

            if(size > capacity) {
                removeNode(tail.prev);
            }
        } else {
            // update the value.
            node.value = value;
            moveToHead(node);
        }
    }
    */
}