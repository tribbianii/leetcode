package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Deque;

class DFSRemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        int extra_l = 0;
        int extra_r = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                extra_l++;
            } else if (s.charAt(i) == ')') {
                if (extra_l != 0) {
                    extra_l--;
                } else {
                    extra_r++;
                }
            }
        }
        Set<String> res = new HashSet<>();
        dfs(s, 0, res, new StringBuilder(), extra_l, extra_r, 0);
        return new ArrayList<String>(res);
    }

    public void dfs(String s, int i, Set<String> res, StringBuilder sb, int extra_l, int extra_r, int open) {
        if (extra_l < 0 || extra_r < 0 || open < 0) {
            return;
        }
        if (i == s.length()) {
            if (extra_l == 0 && extra_r == 0 && open == 0) {
                res.add(sb.toString());
            }        
            return;
        }
        char c = s.charAt(i); 
        if (c == '(') {
            dfs(s, i + 1, res, sb.append(c), extra_l, extra_r, open + 1);
            sb.deleteCharAt(sb.length() - 1); 
            dfs(s, i + 1, res, sb, extra_l - 1, extra_r, open);
        } else if (c == ')') {
            dfs(s, i + 1, res, sb.append(c), extra_l, extra_r, open - 1);
            sb.deleteCharAt(sb.length() - 1); 
            dfs(s, i + 1, res, sb, extra_l, extra_r - 1, open);
        } else {
            dfs(s, i + 1, res, sb.append(c), extra_l, extra_r, open);	
            sb.deleteCharAt(sb.length() - 1); 
        }
              
    }
    //my method exceeded time limit
    public List<String> RemoveInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        int[] extra = check(s);
        dfs(s, set, 0, extra[0], extra[1]);
        for (String str: set) {
            res.add(str);
        }
        return res;
    }
    public void dfs(String s, Set<String> set, int index, int extra_l, int extra_r) {
        if (extra_l == 0 && extra_r == 0) {
            if (isValid(s)) {
                set.add(s);
                return;
            }
        }
        for (int i = index; i < s.length(); i++) {
            if (i != index && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }
            StringBuilder sb = new StringBuilder(s);
            if (s.charAt(i) == '(' && extra_l > 0) {
                sb.deleteCharAt(i);
                dfs(sb.toString(), set, index, extra_l - 1, extra_r);
            } else if (s.charAt(i) == ')' && extra_r > 0) {
                sb.deleteCharAt(i);
                dfs(sb.toString(), set, index, extra_l, extra_r - 1);
            }
        }
    }
    public int[] check(String s) {
        int[] extra = new int[2];
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                    continue;
                }
                stack.push(')');
            } else if (s.charAt(i) == '(') {
                stack.push('(');
            }
        }
        while (!stack.isEmpty()) {
            if (stack.pop() == '(') {
                extra[0] ++;
                continue;
            }
            extra[1] ++;
        }
        return extra;
    }
    public boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
            }
            if (count < 0) {
                return false;
            }
        }
        return count == 0;
    }
}