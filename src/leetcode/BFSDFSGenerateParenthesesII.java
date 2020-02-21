package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BFSDFSGenerateParenthesesII {
    //Get all valid permutations of l pairs of (), m pairs of <> and n pairs of {}
    public List<String> validParentheses(int l, int m, int n) {
        ArrayList<String> res = new ArrayList<String>();
        Stack<Character> stack = new Stack<>();
        dfs(res, stack, "", 2 * (l + m + n), l, l, m, m, n, n);
        return res;
    }

    private void dfs(ArrayList<String> res, Stack<Character> stack, String str, int len, int l_l, int l_r, int m_l,
            int m_r, int n_l, int n_r) {
        if (str.length() == len) {
            res.add(str);
            return;
        }
        if (l_l > 0) {
            stack.push('(');
            dfs(res, stack, str + '(', len, l_l - 1, l_r, m_l, m_r, n_l, n_r);
            stack.pop();
        }
        if (m_l > 0) {
            stack.push('<');
            dfs(res, stack, str + '<', len, l_l, l_r, m_l - 1, m_r, n_l, n_r);
            stack.pop();
        }
        if (n_l > 0) {
            stack.push('{');
            dfs(res, stack, str + '{', len, l_l, l_r, m_l, m_r, n_l - 1, n_r);
            stack.pop();
        }
        if (!stack.isEmpty()) {
            if (l_r > 0 && stack.peek() == '(') {
                stack.pop();
                dfs(res, stack, str + ")", len, l_l, l_r - 1, m_l, m_r, n_l, n_r);
                stack.push('(');
            }
            if (m_r > 0 && stack.peek() == '<') {
                stack.pop();
                dfs(res, stack, str + ">", len, l_l, l_r, m_l, m_r - 1, n_l, n_r);
                stack.push('<');
            }
            if (n_r > 0 && stack.peek() == '{') {
                stack.pop();
                dfs(res, stack, str + "}", len, l_l, l_r, m_l, m_r, n_l, n_r - 1);
                stack.push('{');
            }
        }
    }
}