package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayInsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int[] curr = newInterval;
        for (int index = 0; index <= intervals.length; index ++) {
            curr = merge(curr, index == intervals.length ? null : intervals[index], list);
        }
        return list.toArray(new int[list.size()][]);
    }
    public int[] merge(int[] curr, int[] next, List<int[]> list) {
        if (next == null || curr[1] < next[0]) {
            list.add(curr);
            return next;
        }
        if (next[1] < curr[0]) {
            list.add(next);
            return curr;
        }
        return new int[]{Math.min(curr[0], next[0]), Math.max(curr[1], next[1])};
    }
}
