package leetcode;

import java.util.Stack;

public class StackAndPQLargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i=0;i<=len;i++) {
            int h = (i==len ? 0 : heights[i]);
            //append 0 to array to calculate the last height
            if (stack.isEmpty() || h>=heights[stack.peek()]) {
                stack.push(i);
            }else {
                int curHeight = heights[stack.pop()];
                int rightBoundary = i-1;
                int leftBoundary = stack.isEmpty() ? -1 : stack.peek();
                //set leftboundary to -1 to claculate valid width
                int width = rightBoundary - leftBoundary;
                maxArea = Math.max(maxArea, (curHeight * width));
                i--;
                //stay at this index to find all previous heights lower than this one
            }
        }
        return maxArea;
    }
}