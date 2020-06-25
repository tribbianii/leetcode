package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class StringMinRemoveToValid {
    public String minRemoveToMakeValid(String s) {
        int state = 0;
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.offerLast(i);
                state ++;
            } else if (c == ')') {
                if (!stack.isEmpty() && state > 0) {
                    stack.pollLast();
                    state --;
                } else {
                    stack.offerLast(i);
                }
            }
        }
        Set<Integer> set = new HashSet<>(stack);
        StringBuilder res = new StringBuilder();
        for (int j = 0; j < s.length(); j ++) {
            if (!set.contains(j)) {
                res.append(s.charAt(j));
            }
        }
        return res.toString();
    }
}