package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class StackAndPQExclusiveTimeOfFuntions {
    public int[] exclusiveTime(int n, List <String> logs) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int[] res = new int[n];
        String[] s = logs.get(0).split(":");
        stack.offerLast(Integer.parseInt(s[0]));
        int prev = Integer.parseInt(s[2]);
        for (int i = 1; i < logs.size(); i ++) {
            s = logs.get(i).split(":");
            if (s[1].equals("start")) {
                if (!stack.isEmpty()) {
                    // excution time before next function starts
                    res[stack.peekLast()] += Integer.parseInt(s[2]) - prev;
                }
                stack.offerLast(Integer.parseInt(s[0]));
                prev = Integer.parseInt(s[2]);
            } else {
                // excution time till this funtion ends
                res[stack.peekLast()] += Integer.parseInt(s[2]) - prev + 1;
                stack.pollLast();
                prev = Integer.parseInt(s[2]) + 1;
            }
        }
        return res;
    }
}