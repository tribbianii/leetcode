package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackAndPQBasicCalculator {
    public int calculate(String s) {
        Deque<Integer> values = new ArrayDeque<>();
        Deque<Integer> signs = new ArrayDeque<>();
        int sign = 1;
        int value = 0;
        int number = 0;
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                number = number * 10 + (int)(c - '0');
            } else if (c == '+' || c == '-') {
                value += number * sign;
                number = 0;
                sign = c == '+' ? 1 : -1;
            } else if (c == '(') {
                values.offerLast(value);
                signs.offerLast(sign);
                value = 0;
                number = 0;
                sign = 1;
            } else if (c == ')'){
                value += number * sign;
                value = values.pollLast() + value * signs.pollLast();
                number = 0;
            }
        }
        return value + number * sign;
    }
}