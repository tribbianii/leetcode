package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackAndPQValidParentheses {
    public boolean isValid(String s){
        if (s.length() == 0){
            return true;
        }
        if (s.length() % 2 == 1){
            return false;
        }
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i ++){
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.offerLast(c);
                continue;
            } else if (stack.isEmpty()) {
                return false;
            }
            char d = stack.peekLast();
            if ((c == ')' && d != '(')
                    || (c == ']' && d != '[')
                    || (c == '}' && d != '{')) {
                return false;
            } else {
                stack.pollLast();
            }
        }
        return stack.isEmpty();
    }
}