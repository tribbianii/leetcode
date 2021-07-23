package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackAndPQLargestRectangle {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> deque = new ArrayDeque<>();
        int res = 0;
        int index = 0;
        while (index <= heights.length) {
            int curr_h = index == heights.length ? 0 : heights[index];
            while (!deque.isEmpty() && curr_h < heights[deque.peekLast()]) {
                int prev_h = heights[deque.pollLast()];
                int leftBound = deque.isEmpty() ? -1 : deque.peekLast();
                int rightBound = index - 1;
                res = Math.max(res, prev_h * (rightBound - leftBound));
            }
            deque.offerLast(index);
            index ++;
        }
        return res;
    }
}