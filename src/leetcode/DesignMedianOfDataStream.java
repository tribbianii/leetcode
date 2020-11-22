package leetcode;

public class DesignMedianOfDataStream {
    static class Node{
        int value;
        Node next;
        Node prev;
        Node(int val) {
            this.value = val;
        };
    }

    Node head;
    Node tail;
    Node med;
    int size;

    /** initialize your data structure here. */
    public DesignMedianOfDataStream() {
        this.size = 0;
    }

    public void insertNode(int num) {
        Node curr = med;
        Node node = new Node(num);
        if (med.value >= num) {
            while (curr != null && curr.value >= num) {
                curr = curr.prev;
            }
            if (curr == null) {
                node.next = head;
                head.prev = node;
                head = node;
            } else {
                node.next = curr.next;
                node.next.prev = node;
                curr.next = node;
                node.prev = curr;
            }
            med = size % 2 == 1 ? med.prev : med;
        } else {
            while (curr != null && curr.value < num) {
                curr = curr.next;
            }
            if (curr == null) {
                node.prev = tail;
                tail.next = node;
                tail = node;
            } else {
                node.prev = curr.prev;
                node.prev.next = node;
                curr.prev = node;
                node.next = curr;
            }
            med = size % 2 == 0 ? med.next : med;
        }
        size ++;
    }

    public void addNum(int num) {
        if (size == 0) {
            head = new Node(num);
            med = head;
            tail = head;
            size ++;
            return;
        }
        insertNode(num);
    }

    public double findMedian() {
        if (size % 2 == 0) {
            return (double)(med.value + med.next.value) / 2;
        }
        return med.value;
    }
}
