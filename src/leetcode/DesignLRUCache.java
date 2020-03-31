package leetcode;

import java.util.HashMap;
import java.util.Map;

class DesignLRUCache {
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
        /**
         * Always add the new node right after head.
         */
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
        
        map.put(node.key, node);
        
        size ++;
    }

    private void removeNode(DLinkedNode node){
        /**
         * Remove an existing node from the linked list.
         */
        DLinkedNode prev = node.prev;
        DLinkedNode next = node.next;

        prev.next = next;
        next.prev = prev;
        
        map.remove(node.key);
        
        size --;
    }

    private void moveToHead(DLinkedNode node){
        /**
         * Move certain node in between to the head.
         */
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
}