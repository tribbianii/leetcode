package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class LinkedListFlattenMultilevelDoublyLinkedList {
    static class Node {
        int val;
        Node prev;
        Node next;
        Node child;
    }
    Deque<Node> parentsNext = new ArrayDeque<>();
    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        if (head.next == null && head.child == null) {
            head.next = flatten(parentsNext.pollLast());
        } else if (head.next == null || head.child == null) {
            head.next = flatten(head.child == null ? head.next : head.child);
        } else {
            parentsNext.offerLast(head.next);
            head.next = flatten(head.child);
        }
        if (head.next != null) {
            head.next.prev = head;
        }
        head.child = null;
        return head;
    }
}
