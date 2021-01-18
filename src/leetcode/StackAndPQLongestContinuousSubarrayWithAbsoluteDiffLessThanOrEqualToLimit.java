package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class StackAndPQLongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {
    //my dumb solution
    static class Node {
        int value;
        int index;
        public Node(int val, int idx) {
            this.value = val;
            this.index = idx;
        }
    }
    public int longestSubarray(int[] nums, int limit) {
        int maxLen = 0;
        int from = 0;
        int end = 0;
        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> a.value - b.value);
        PriorityQueue<Node> maxHeap = new PriorityQueue<>((a, b) -> b.value - a.value);
        while (end < nums.length) {
            Node node = new Node(nums[end], end);
            minHeap.add(node);
            maxHeap.add(node);
            while (findPeek(maxHeap, from, end) - findPeek(minHeap, from, end) > limit) {
                from ++;
            }
            maxLen = Math.max(maxLen, (end - from + 1));
            end ++;
        }
        return maxLen;
    }
    public int findPeek(PriorityQueue<Node> Heap, int from, int end) {
        while (Heap.peek().index < from) {
            Heap.poll();
        }
        return Heap.peek().value;
    }
    //optimal solution
    public int LongestSubarray(int[] A, int limit) {
        int maxLen = 0;
        Deque<Integer> max_dq = new ArrayDeque<>();
        Deque<Integer> min_dq = new ArrayDeque<>();
        int left = 0;
        int right = 0;
        while (right < A.length) {
            while (!max_dq.isEmpty() && A[right] > max_dq.peekLast()) {
                max_dq.pollLast();
            }
            while (!min_dq.isEmpty() && A[right] < min_dq.peekLast()) {
                min_dq.pollLast();
            }
            max_dq.add(A[right]);
            min_dq.add(A[right]);
            while (max_dq.peek() - min_dq.peek() > limit) {
                if (max_dq.peekFirst() == A[left]) {
                    max_dq.pollFirst();
                }
                if (min_dq.peekFirst() == A[left]) {
                    min_dq.pollFirst();
                }
                left ++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right ++;
        }
        return maxLen;
    }
}
