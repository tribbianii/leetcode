package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackAndPQValidParentheses {
    public boolean isValid(String s){
        if (s.length()==0){
            return true;
        }
        if (s.length()%2==1){
            return false;
        }
        Deque<Character> stack = new ArrayDeque<>();
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