package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
//NOTE:the element has index of 0 will be the last to pop in Deque

public class StackAndPQImplementQueueUsingStack {
    Deque<Integer> stack = new ArrayDeque<Integer>();
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int x = stack.peek();
        stack.remove(stack.peek());
        return x;
    }
    
    /** Get the front element. */
    public int peek() {
        return stack.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty(); 
    }
}