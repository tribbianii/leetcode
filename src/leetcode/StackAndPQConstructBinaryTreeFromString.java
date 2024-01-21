package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackAndPQConstructBinaryTreeFromString {
    public TreeNode str2tree(String s) {
        if (s.isEmpty()) {
            return null;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        int index = 0;
        int value = 0;
        int digit = 0;
        int sign = 1;
        while (index < s.length()) {
            // case 1: digit --> offer a new tree node into deque
                value = 0;
                digit = 0;
                sign = 1;
                if (s.charAt(index) == '-') {
                    sign = -1;
                    index ++;
                }
                while (index < s.length() && Character.isDigit(s.charAt(index))) {
                    value = value * 10 + (int)(s.charAt(index) - '0');
                    index ++;
                    digit ++;
                }
                if (digit > 0) {
                    deque.offerLast(new TreeNode(value * sign));
                    continue;
                }
            // case 2: ( --> skip
                if (s.charAt(index) == '(') {
                    index ++;
                    continue;
                }
            // case 3: ) --> poll a tree node and connect it with parent
                TreeNode node = deque.pollLast();
                if (deque.peekLast().left == null) {
                    deque.peekLast().left = node;
                } else {
                    deque.peekLast().right = node;
                }
                index ++;
        }
        return deque.pollLast();
    }
}
