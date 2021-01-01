package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayInsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int newStart = newInterval[0];
        int newEnd = newInterval[1];
        int idx = 0;
        int n = intervals.length;
        LinkedList<int[]> output = new LinkedList<int[]>();
        while (idx < n && intervals[idx][0] < newStart) {
            output.add(intervals[idx++]);
        }
        int[] interval = new int[2];
        if (output.isEmpty() || output.getLast()[1] < newStart) {
            output.add(newInterval);
        } else {
            interval = output.removeLast();
            interval[1] = Math.max(interval[1], newEnd);
            output.add(interval);
        }
        while (idx < n) {
            interval = intervals[idx++];
            int start = interval[0];
            int end = interval[1];
            if (output.getLast()[1] >= start) {
                interval = output.removeLast();
                interval[1] = Math.max(interval[1], end);
            }
            output.add(interval);
        }
        return output.toArray(new int[output.size()][2]);
    }
}
