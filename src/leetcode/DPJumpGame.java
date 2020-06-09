package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class DPJumpGame {
    public static boolean jump(int[] max) {
        boolean[] reach = new boolean[max.length];
        reach[reach.length - 1] = true;
        int pos = reach.length - 2;
        while (pos >= 0) {
            for (int i = max[pos]; i > 0; i --) {
                if (reach[pos + i]) {
                    reach[pos] = true;
                    break;
                }
            }
            pos --;
        }
        return reach[0];
    }

    public static boolean Jump(int[] max) {
        int len = max.length;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.offer(0);
        while (!stack.isEmpty()) {
            int pos = stack.poll();
            int steps = max[pos];
            if (pos + steps >= len - 1) {
                return true;
            }
            while (steps > 0) {
                stack.offer(pos + steps--);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] max_1 = new int[]{2,3,1,1,4};
        int[] max_2 = new int[]{3,2,1,0,4};
        System.out.println("1-1: " + jump(max_1));
        System.out.println("2-1: " + Jump(max_1));
        System.out.println("1-2: " + jump(max_2));
        System.out.println("2-2: " + Jump(max_2));
    }
}