package leetcode;

import java.util.PriorityQueue;

public class DesignMedianOfDataStream {
    PriorityQueue<Integer> highHalf;
    PriorityQueue<Integer> lowHalf;
    /** initialize your data structure here. */
    public DesignMedianOfDataStream() {
        this.highHalf = new PriorityQueue<Integer>();
        this.lowHalf = new PriorityQueue<Integer>((a, b) -> b - a);
    }

    public void addNum(int num) {
        lowHalf.offer(num);
        highHalf.offer(lowHalf.poll());
        if (highHalf.size() > lowHalf.size()) {
            lowHalf.offer(highHalf.poll());
        }
    }

    public double findMedian() {
        return lowHalf.size() > highHalf.size() ? lowHalf.peek() : ((double)(lowHalf.peek() + highHalf.peek())) / 2;
    }
}
