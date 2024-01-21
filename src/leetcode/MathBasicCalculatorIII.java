package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

//apply to basic calculator I, II, and III
public class MathBasicCalculatorIII {
    public int calculate(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('(', -1);
        map.put('+', 0);
        map.put('-', 0);
        map.put('*', 1);
        map.put('/', 1);

        Deque<Integer> operands = new ArrayDeque<>();
        Deque<Character> operators = new ArrayDeque<>();

        int index = 0;
        while (index < s.length()) {
            char c = s.charAt(index);
            if (c == ' ') {
                continue;
            }
            if (Character.isDigit(c)) {
                int val = (int)(s.charAt(index + 1) - '0');
                while (index + 1 < s.length() && Character.isDigit(s.charAt(index + 1))) {
                    val = val * 10 + (int)(s.charAt(index + 1) - '0');
                    index ++;
                }
                operands.offerLast(val);
            } else if (c == '(') {
                operators.offerLast(c);
            } else if (c == ')') {
                while (operators.peekLast() != '(') {
                    operands.offerLast(operate(operands, operators));
                }
                operators.pollLast();
            } else {
                while (!operators.isEmpty() && map.get(c) - map.get(operators.peekLast()) <= 0) {
                    operands.offerLast(operate(operands, operators));
                }
                operators.offerLast(c);
            }
            index ++;
        }
        while (!operators.isEmpty()) {
            operands.offerLast(operate(operands, operators));
        }
        return operands.pollLast();
    }

    private int operate(Deque<Integer> operands, Deque<Character> operators) {
        int a = operands.pollLast();
        int b = operands.pollLast();
        char c = operators.pollLast();

        switch(c) {
            case '+' : return a + b;
            case '-': return b - a;
            case '*': return a * b;
            case '/': return b / a;
            default: return 0;
        }
    }
}
