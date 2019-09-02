package leetcode;

import java.util.Stack;

public class StackAndPQBasicCaculatorII {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int number = 0;
        int result = 0;
        char sign = '+';
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (Character.isDigit(c)){
                number = 0;
                while (i<s.length() && Character.isDigit(s.charAt(i))){
                    number = number*10 + s.charAt(i)-'0';
                    i++;
                }
                i--;
                if (sign=='+'){
                    stack.push(number);
                }
                if (sign=='-'){
                    stack.push(-number);
                }
                if (sign=='*'){
                    stack.push(stack.pop() * number);
                }
                if (sign=='/'){
                    stack.push(stack.pop() / number);
                }
            }else if (c!=' '){
                sign = c;
            }
        }
        while (!stack.isEmpty()){
            result += stack.pop();
        }
        return result;
    }
}