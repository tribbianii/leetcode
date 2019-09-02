package leetcode;

import java.util.Stack;

public class StackAndPQEvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0){
            return 0;
        } 
        int left, right;
        Stack<Integer> stack = new Stack<Integer>();
        for(String s : tokens){
            if(s.equals("+")){
                stack.add(stack.pop() + stack.pop());
            }else if(s.equals("-")){
                right = stack.pop();
                left = stack.pop();
                stack.add(left - right);
            }else if(s.equals("*")){
                stack.add(stack.pop() * stack.pop());
            }else if(s.equals("/")){
                right = stack.pop();
                left = stack.pop();
                stack.add(left / right);
            }else{
                stack.add(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
}