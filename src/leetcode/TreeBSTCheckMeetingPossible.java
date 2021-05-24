package leetcode;

public class TreeBSTCheckMeetingPossible {
    static class Meeting {
        int start_time;
        int end_time;
        Meeting prev_meeting;
        Meeting next_meeting;
        Meeting(int start, int end) {
            this.start_time = start;
            this.end_time = end;
        }
    }
    public Meeting arrange(Meeting node, Meeting meeting) {
        if (node == null) {
            return meeting;
        }
        if (meeting.start_time >= node.end_time) {
            node.next_meeting = arrange(node.next_meeting, meeting);
            return node.next_meeting == null ? null : node;
        }
        if (meeting.end_time <= node.start_time) {
            node.prev_meeting = arrange(node.prev_meeting, meeting);
            return node.prev_meeting == null ? null : node;
        }
        return null;
    }
    public boolean checkIfPossible(int[][] schedules) {
        Meeting prev = null;
        for (int[] schedule : schedules) {
            prev = arrange(prev, new Meeting(schedule[0], schedule[1]));
            if (prev == null) {
                return false;
            }
        }
        return true;
    }
}
