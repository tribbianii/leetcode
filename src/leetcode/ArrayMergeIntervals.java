package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class ArrayMergeIntervals {
    public int[][] mergeMeetings(int[][] meetingTimes){
        Arrays.sort(meetingTimes, Comparator.comparingInt(a -> a[0]));

        ArrayList<int[]> merged = new ArrayList<>();
        for (int[] meeting: meetingTimes){
            int size = merged.size();
            if(size == 0 || merged.get(size - 1)[1] < meeting[0]){
                merged.add(meeting);
            }
            else{
                merged.get(size - 1)[1] = Math.max(merged.get(size - 1)[1], meeting[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}