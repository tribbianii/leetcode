package leetcode;

import java.util.Stack;

public class StackAndPQValidParenthesisString {
    class Node {
        char ch;
        int idx;
        Node(char ch, int idx) {
            this.ch = ch;
            this.idx = idx;
        } 
    }
    public boolean checkValidString(String s) {
        Stack<Node> s_1 = new Stack<>();
        Stack<Node> s_2 = new Stack<>();
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (c == '*') {
                s_2.push(new Node(c, i));
                continue;
            }
            if (c == ')') {
                if (!s_1.isEmpty() && s_1.peek().ch == '(') {
                    s_1.pop();
                    continue;
                } else if (s_1.isEmpty() && s_2.isEmpty()) {
                    return false;
                }
            }
            s_1.push(new Node(c, i));
        }
        while (!s_2.isEmpty()) {
            if (s_1.isEmpty()) {
                return true;
            }
            Node node = s_1.pop();
            char c = node.ch;
            int idx_1 = node.idx;
            int idx_2 = s_2.pop().idx;
            if (c == '(') {
                if(idx_2 < idx_1) {
                    return false;
                }
                continue;
            }
            while (idx_2 > idx_1 && !s_2.isEmpty()) {
                idx_2 = s_2.pop().idx;
            }
            if (idx_2 > idx_1) {
                return false;
            }
        }
        return s_1.isEmpty();
    }
}