package leetcode;

import java.util.Stack;
//NOTE:the element has index of 0 will be the last to pop in Stack

public class StackAndPQImplementQueueUsingStack {
    Stack<Integer> stack = new Stack<Integer>();
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int x = stack.elementAt(0);
        stack.remove(stack.elementAt(0));
        return x;
    }
    
    /** Get the front element. */
    public int peek() {
        return stack.elementAt(0);
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty(); 
    }
}