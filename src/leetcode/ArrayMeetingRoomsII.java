package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ArrayMeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        // Min heap
        PriorityQueue<Integer> earliestEnd = new PriorityQueue<>();
        // Sort the intervals by start time
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(final int[] a, final int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });
        // Add the first meeting
        earliestEnd.add(intervals[0][1]);
        // Iterate over remaining intervals
        for (int i = 1; i < intervals.length; i ++) {
            // If the room due to free up the earliest is free, assign that room to this meeting.
            if (intervals[i][0] >= earliestEnd.peek()) {
                earliestEnd.poll();
            }
            // If a new room is to be assigned, then also we add to the heap,
            // If an old room is allocated, then also we have to add to the heap with updated end time.
            earliestEnd.add(intervals[i][1]);
        }
        // The size of the heap tells us the minimum rooms required for all the meetings.
        return earliestEnd.size();
    }
}
