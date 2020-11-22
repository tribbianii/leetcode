package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
public class StackAndPQMinStack {
    //my method is great
    static class Node{
        int value;
        Node prev;
        Node bigger;
        Node(int val) {
            this.value = val;
        }
    }

    Node root;
    Node peek;
    Node min;
    int size;

    public StackAndPQMinStack(){
        this.root = new Node(0);
        this.peek = root;
        this.min = root;
        this.size = 0;
    }

    public void push(int x) {
        Node node = new Node(x);
        if (x <= this.min.value || size == 0) {
            node.bigger = min;
            min = node;
        }
        node.prev = peek;
        peek = node;
        size ++;
    }

    public void pop() {
        if (size > 0) {
            if (peek == min) {
                min = min.bigger;
            }
            peek = peek.prev;
            size --;
        } else {
            throw new IllegalArgumentException("Stack is empty");
        }
    }

    public int top() {
        if (size > 0) {
            return peek.value;
        } else {
            throw new IllegalArgumentException("Stack is empty");
        }
    }

    public int getMin() {
        if (size > 0) {
            return min.value;
        } else {
            throw new IllegalArgumentException("Stack is empty");
        }
    }
    /*
    Deque<Integer> sequential;
    Deque<Integer> ascending;
    public StackAndPQMinStack() {
        this.sequential = new ArrayDeque<Integer>();
        this.ascending = new ArrayDeque<Integer>();
    }

    public void push(int x) {
        sequential.offerLast(x);
        if (ascending.isEmpty() || x <= ascending.peekLast()){
            ascending.offerLast(x);
        }
    }

    public void pop() {
        int x = sequential.pollLast();
        if (x == ascending.peekLast()){
            ascending.pollLast();
        }
    }

    public int top() {
        return sequential.peekLast();
    }

    public int getMin() {
        return ascending.peekLast();
    }
    */
}