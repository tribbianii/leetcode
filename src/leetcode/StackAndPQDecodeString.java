package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackAndPQDecodeString{
    public String decodeString(String s) {
        Deque<Integer> num_stack = new ArrayDeque<>();
        Deque<StringBuilder> str_stack = new ArrayDeque<>();
        str_stack.offerLast(new StringBuilder());
        int times = 0;
        char[] arr = s.toCharArray();
        for (char c : arr) {
            if (Character.isDigit(c)) {
                times = times * 10 + (int)(c - '0');
            } else if (c == '[') {
                num_stack.offerLast(times);
                str_stack.offerLast(new StringBuilder());
                times = 0;
            } else if (c == ']') {
                times = num_stack.pollLast();
                StringBuilder sb = str_stack.pollLast();
                while (times > 0) {
                    str_stack.peekLast().append(new String(sb));
                    times --;
                }
            } else {
                str_stack.peekLast().append(c);
            }
        }
        return new String(str_stack.pollLast());
    }
}