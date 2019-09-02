package leetcode;

import java.util.Stack;

public class StackAndPQBasicCaculator{
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0;
        int sign = 1;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                int number = 0;
                while (i<s.length() && Character.isDigit(s.charAt(i))){
                    number = number*10 + s.charAt(i)-'0';
                    i++;
                }
                result += number * sign;
                i--;
            }else if(c == '+'){
                sign = 1;
            }else if(c == '-'){
                sign = -1;
            }else if(c == '('){
                stack.push(result);
                stack.push(sign);
                sign = 1;   
                result = 0;
            }else if(c == ')'){
                result *= stack.pop();
                result += stack.pop();   
            }
        }
        return result;
    }
    //another solution
    public int Calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0;
        int number = 0;
        int sign = 1;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                number = 0;
                while (i<s.length() && Character.isDigit(s.charAt(i))){
                    number = number*10 + s.charAt(i)-'0';
                    i++;
                }
                i--;
            }else if(c == '+'){
                result += number * sign;
                sign = 1;
            }else if(c == '-'){
                result += number * sign;
                sign = -1; 
            }else if(c == '('){
                stack.push(result);
                stack.push(sign);
                sign = 1;   
                result = 0;
            }else if(c == ')'){
                result += number * sign;
                result *= stack.pop();
                result += stack.pop(); 
                number=0;
            }
        }
        return number==0?result:result+number*sign;
    }
}