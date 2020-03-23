package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class ArrayMergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] cur,int[] nex){
                if (cur[0] == nex[0]) {
                    return cur[1] - nex[1];
                }
                return cur[0] - nex[0];
            }
        });
        int cur_head = intervals[0][0];
        int cur_tail = intervals[0][1];
        int nex_head = intervals[1][0];
        int nex_tail = intervals[1][1];
        ArrayList<int[]> res = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            nex_head = intervals[i][0];
            nex_tail = intervals[i][1];
            if (cur_tail < nex_head) {
                res.add(new int[]{cur_head, cur_tail});
                cur_head = nex_head;
            }
            cur_tail = Math.max(cur_tail, nex_tail);
        }
        res.add(new int[]{cur_head, cur_tail});
        return res.toArray(new int[res.size()][2]);
    }
}