package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class MathBaseballGame {
    public int calPoints(String[] ops) {
        Deque<Integer> dq = new ArrayDeque<>();
        int sum = 0;
        for (int i = 0; i < ops.length; i ++) {
            try {
                dq.offerLast(Integer.valueOf(ops[i]));
                sum += dq.peekLast();
            } catch (Exception e) {
                if (ops[i].equals("C")) {
                    sum -= dq.pollLast();
                } else if (ops[i].equals("+")) {
                    int a = dq.pollLast();
                    int b = dq.peekLast();
                    dq.offerLast(a);
                    dq.offerLast(a + b);
                    sum += dq.peekLast();
                } else {
                    dq.offerLast(dq.peekLast() * 2);
                    sum += dq.peekLast();
                }
            }
        }
        return sum;
    }
}
