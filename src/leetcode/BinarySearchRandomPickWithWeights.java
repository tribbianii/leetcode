package leetcode;

import java.util.*;

public class BinarySearchRandomPickWithWeights {
    int[] presum;
    int total_sum;
    public BinarySearchRandomPickWithWeights(int[] w) {
        this.presum = new int[w.length];
        this.total_sum = 0;
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < w.length; i ++) {
            this.total_sum += w[i];
            this.presum[i] = this.total_sum;
        }
    }

    Map<Integer, Integer> map = new TreeMap<>();

    public int pickIndex() {
        int pick = (int)(Math.random() * this.total_sum);
        return findFirstGreater(pick);
    }

    public int findFirstGreater(int target) {
        int left = 0;
        int right = this.presum.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (this.presum[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return this.presum[left] > target ? left : right;
    }
}
