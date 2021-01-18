package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class StackAndPQMaxSlidingWindow {
    class Node {
        int value;
        int index;
        Node (int i, int j) {
            this.value = i;
            this.index = j;
        }
    }
    // lazy deletion + max heap, Time: O((n - k) * log(k))
    // faster in leetcode test cases
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        PriorityQueue<Node> pq = new PriorityQueue<Node>((a, b) -> b.value - a.value);
        int res_index = 0;
        for (int i = 0; i < nums.length; i ++) {
            pq.add(new Node(nums[i], i));
            while (!pq.isEmpty() && pq.peek().index < i - (k - 1)) {
                pq.poll();
            }
            if (i > (k - 2)) {
                res[res_index ++] = pq.peek().value;
            }
        }
        return res;
    }
    // dequeue solution, Time: O(n)
    public int[] MaxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len == 0) {
            return nums;
        }
        int[] result = new int[len - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            if (!dq.isEmpty() && dq.peekFirst() < i - k + 1) {
                dq.pollFirst();
            }
            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.offerLast(i);
            if (i >= (k -1)) {
                result[i - k + 1] = nums[dq.peekFirst()];
            }
        }
        return result;
    }
}
