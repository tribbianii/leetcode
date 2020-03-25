package leetcode;

import java.util.Stack;

class StringLongestValidParentheses {
    public int longestValidParentheses(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }
    //my slow method
    public int LongestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < s.length(); i ++) {
            if (!stack.isEmpty() && s.charAt(stack.peek()) == '(' && s.charAt(i) == ')') {
                stack.pop();
                continue;
            }
            stack.push(i);
        }
        int max = 0;
        stack.push(s.length());
        while (!stack.isEmpty()) {
            int end = stack.pop();
            int start = stack.isEmpty() ? -1 : stack.peek();
            max = Math.max(max, end - start - 1);
        }
        return max;
    }
}