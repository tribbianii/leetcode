package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackAndPQValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>();
        int push = 0;
        int pop = 0;
        while (pop < popped.length) {
            if (push == pushed.length && (stack.isEmpty() || stack.peekLast() != popped[pop])) {
                return false;
            }
            if (!stack.isEmpty() && stack.peekLast() == popped[pop]) {
                stack.pollLast();
                pop ++;
            } else {
                stack.offerLast(pushed[push]);
                push ++;
            }
        }
        return true;
    }
}
