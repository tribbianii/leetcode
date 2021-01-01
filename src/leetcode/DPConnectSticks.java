package leetcode;

import java.util.PriorityQueue;

public class DPConnectSticks {
    public int connectSticks(int[] sticks) {
        int totalCost = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int stick : sticks) {
            pq.add(stick);
        }
        while (pq.size() > 1) {
            int stick1 = pq.remove();
            int stick2 = pq.remove();
            int cost = stick1 + stick2;
            totalCost += cost;
            pq.add(stick1 + stick2);
        }
        return totalCost;
    }
    // exceeded the time limited
    public int ConnectSticks(int[] sticks) {
        int[][] dp = new int[sticks.length][sticks.length];
        for (int i = 0; i < dp.length; i ++) {
            for (int j = 0; j <= i; j ++) {
                if (j == 0) {
                    dp[i - j][i] = sticks[i];
                    continue;
                }
                int min = Integer.MAX_VALUE;
                for (int k = 1; k <= j; k ++) {
                    min = Math.min(min, dp[i - j][i - k] + dp[i - k + 1][i] + sum(sticks, i - j, i - k) + sum(sticks, i - k + 1, i));
                }
                dp[i - j][i] = min;
            }
        }
        return dp[0][dp.length - 1];
    }
    public int sum(int[] sticks, int from, int end) {
        if (from >= end) {
            return 0;
        }
        int sum = 0;
        while (from <= end) {
            sum += sticks[from ++];
        }
        return sum;
    }
}
