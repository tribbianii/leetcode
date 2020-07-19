package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Deque;

public class BFSDFSGenerateParenthesesII {
    //Get all valid permutations of l pairs of (), m pairs of <> and n pairs of {}
    public static List<String> generateValidParentheses(int l, int m, int n) {
        ArrayList<String> res = new ArrayList<String>();
        Deque<Character> stack = new ArrayDeque<>();
        dfs(res, stack, new StringBuilder(), 2 * (l + m + n), new int[]{l, m, n}, new int[]{l, m, n});
        return res;
    }

    private static void dfs(ArrayList<String> res, Deque<Character> stack, StringBuilder str, int len, int[] lefts, int[] rights) {
        if (len == 0) {
            res.add(new String(str));
            return;
        }
        if (lefts[0] > 0) {
            stack.push('(');
            lefts[0] --;
            dfs(res, stack, str.append('('), len - 1, lefts, rights);
            str.deleteCharAt(str.length() - 1);
            lefts[0] ++;
            stack.pop();
        }
        if (lefts[1] > 0) {
            stack.push('<');
            lefts[1] --;
            dfs(res, stack, str.append('<'), len - 1, lefts, rights);
            str.deleteCharAt(str.length() - 1);
            lefts[1] ++;
            stack.pop();
        }
        if (lefts[2] > 0) {
            stack.push('{');
            lefts[2] --;
            dfs(res, stack, str.append('{'), len - 1, lefts, rights);
            str.deleteCharAt(str.length() - 1);
            lefts[2] ++;
            stack.pop();
        }
        if (!stack.isEmpty()) {
            if (rights[0] > 0 && stack.peek() == '(') {
                stack.pop();
                rights[0] --;
                dfs(res, stack, str.append(')'), len - 1, lefts, rights);
                str.deleteCharAt(str.length() - 1);
                rights[0] ++;
                stack.push('(');
            }
            if (rights[1] > 0 && stack.peek() == '<') {
                stack.pop();
                rights[1] --;
                dfs(res, stack, str.append('>'), len - 1, lefts, rights);
                str.deleteCharAt(str.length() - 1);
                rights[1] ++;
                stack.push('<');
            }
            if (rights[2] > 0 && stack.peek() == '{') {
                stack.pop();
                rights[2] --;
                dfs(res, stack, str.append('}'), len - 1, lefts, rights);
                str.deleteCharAt(str.length() - 1);
                rights[2] ++;
                stack.push('{');
            }
        }
    }
}