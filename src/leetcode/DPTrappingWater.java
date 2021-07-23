package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class DPTrappingWater {
    // time: O(n)
    // space: O(n)
    public int trapp(int[] height) {
        int res = 0;
        int index = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        while (index < height.length) {
            while (!stack.isEmpty() && height[stack.peekLast()] < height[index]) {
                int low = height[stack.pollLast()];
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peekLast();
                int right = index;
                int distance = right - left - 1;
                res += (Math.min(height[left], height[right]) - low) * distance;
            }
            stack.offerLast(index ++);
        }
        return res;
    }
    // time: O(n)
    // space: O(1)
    public int Trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int l_max = 0;
        int r_max = 0;
        int res = 0;
        while (left <= right) {
            if (l_max <= r_max) {
                if (l_max > height[left]) {
                    res += l_max - height[left ++];
                } else {
                    l_max = height[left ++];
                }
            } else {
                if (r_max > height[right]) {
                    res += r_max - height[right --];
                } else {
                    r_max = height[right --];
                }
            }
        }
        return res;
    }
    // time: O(n)
    // space: O(n)
    public int trap(int[] height) {
        int res = 0;
        int[] l_max = new int[height.length];
        int[] r_max = new int[height.length];
        for (int i = 0; i < height.length; i ++) {
            l_max[i] = i == 0 ? height[0] : Math.max(l_max[i - 1], height[i]);
            r_max[height.length - 1 - i] = i == 0 ? height[height.length - 1] : Math.max(r_max[height.length - i], height[height.length - 1 - i]);
        }
        for (int j = 0; j < height.length; j ++) {
            res += Math.min(l_max[j], r_max[j]) - height[j];
        }
        return res;
    }

}