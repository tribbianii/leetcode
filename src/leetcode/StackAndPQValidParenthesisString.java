package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackAndPQValidParenthesisString {
    //新建一种数据，表示符号及其坐标
    class Node {
        char ch;
        int idx;
        Node(char ch, int idx) {
            this.ch = ch;
            this.idx = idx;
        } 
    }
    public boolean checkValidString(String s) {
        //用来记录括号及其位置，并且过程中消除相邻的 ‘(’ & ‘)’
        Deque<Node> s_1 = new ArrayDeque<>();
        //用来记录 * 及其位置
        Deque<Node> s_2 = new ArrayDeque<>();
        //遍历字符串
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (c == '*') {
                s_2.push(new Node(c, i));
                continue;
            }
            if (c == ')') {
                //过程中抵消相邻的 ‘(’ & ‘)’
                if (!s_1.isEmpty() && s_1.peek().ch == '(') {
                    s_1.pop();
                    continue;
                //出现靠左的 ')' 并且其左边没有 *, 意味着无法为其匹配 '(', 那么一定不合法
                } else if (s_1.isEmpty() && s_2.isEmpty()) {
                    return false;
                }
            }
            //遇到 '(', 加入栈即可
            s_1.push(new Node(c, i));
        }
        while (!s_2.isEmpty()) {
            //抵消完了, 合法
            if (s_1.isEmpty()) {
                return true;
            }
            //推出栈最靠右的元素
            Node node = s_1.pop();
            char c = node.ch;
            int idx_1 = node.idx;
            //推出最靠右的 * 的坐标
            int idx_2 = s_2.pop().idx;
            //如果最靠右的元素是 '('
                //如果在此 '(' 右边存在 * , 意味着可以把 * 匹配成 ')' 来抵消 --> 继续
                //如果在此 '(' 右边没有 * , 意味着这个 '(' 无法被匹配 --> 不合法
            if (c == '(') {
                if(idx_2 < idx_1) {
                    return false;
                }
                continue;
            }
            //如果最靠右的元素是 ')'
                //如果在这个 ')' 左边存在 * , 意味着可以把 * 匹配成 '(' 来抵消 --> 继续
                //如果在这个 ')' 左边没有 * , 意味着这个 ')' 无法被匹配 --> 不合法
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