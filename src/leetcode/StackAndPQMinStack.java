package leetcode;

import java.util.Stack;

public class StackAndPQMinStack {
    Stack<Integer> stack_1;
    Stack<Integer> stack_2;
    
    public void push(int x) {
        stack_1.push(x);
        if (stack_2.isEmpty() || x<=stack_2.peek()){
            stack_2.push(x);
        }
    }
    
    public void pop() {
        int x = stack_1.pop();
        if (x==stack_2.peek()){
            stack_2.pop();
        }
    }
    
    public int top() {
        return stack_1.peek();
    }
    
    public int getMin() {
        return stack_2.peek();
    }
}