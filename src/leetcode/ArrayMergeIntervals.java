package leetcode;

import java.util.*;

class ArrayMergeIntervals {
    private static StringBuilder append;

    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int[] curr = intervals[0];
        for (int i = 1; i <= intervals.length; i ++) {
            curr = merge(curr, i == intervals.length ? null : intervals[i], list);
        }
        return list.toArray(new int[list.size()][2]);
    }
    public int[] merge(int[] curr, int[] next, List<int[]> list) {
        if (next == null || curr[1] < next[0]) {
            list.add(curr);
            return next;
        }
        return new int[]{Math.min(curr[0], next[0]), Math.max(curr[1], next[1])};
    }
}