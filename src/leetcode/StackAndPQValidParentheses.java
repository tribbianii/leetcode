package leetcode;

import java.util.Stack;

public class StackAndPQValidParentheses {
    public boolean isValid(String s){
        if (s.length()==0){
            return true;
        }
        if (s.length()%2==1){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{'){
                stack.push(s.charAt(i));
            }
            else if (stack.isEmpty()){
                return false;
            }
            else if (s.charAt(i)==')'&&stack.peek()=='('){
                stack.pop();
            }
            else if (s.charAt(i)==']'&&stack.peek()=='['){
                stack.pop();
            }
            else if (s.charAt(i)=='}'&&stack.peek()=='{'){
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}