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
        int[] res = new int[nums.length - k + 1];
        Deque<Node> deque = new ArrayDeque<Node>();
        int res_index = 0;
        for (int i = 0; i < nums.length; i ++) {
            int val = nums[i];
            while (!deque.isEmpty() && deque.peekFirst().value <= val) {
                deque.pollFirst();
            }
            if (!deque.isEmpty() && i > (k - 1) && deque.peekLast().index < i - (k - 1)) {
                deque.pollLast();
            }
            deque.offerFirst(new Node(val, i));
            if (i > (k - 2)) {
                res[res_index ++] = deque.peekLast().value;
            }
        }
        return res;
    }
}
