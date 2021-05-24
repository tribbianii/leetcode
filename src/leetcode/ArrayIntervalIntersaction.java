package leetcode;

import java.util.ArrayList;
import java.util.List;

public class ArrayIntervalIntersaction {
    public static int[][] meetingsIntersection(int[][] meetingsA, int[][] meetingsB){
        ArrayList<int []> intersection = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < meetingsA.length && j < meetingsB.length) {
            int start = Math.max(meetingsA[i][0], meetingsB[j][0]);
            int end = Math.min(meetingsA[i][1], meetingsB[j][1]);
            if (start < end)
                intersection.add(new int[]{start, end});
            if (meetingsA[i][1] < meetingsB[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        return intersection.toArray(new int[intersection.size()][]);
    }
}