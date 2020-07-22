package leetcode;

public class BinarySearchKthSmallestTwoSortedArray {
    // This is an awesome solution
    // O(log(k))
    // every time rule out k/2 portion which must not contain solution
    // a_left and b_left start from 0
    public static int findKthSmallest(int[] a, int[] b, int a_left, int b_left, int k) {
        if (a_left >= a.length) {
            return b[b_left + k - 1];
        }
        if (b_left >= b.length) {
            return a[a_left + k - 1];
        }
        if (k == 1) {
            return Math.min(a[a_left], b[b_left]);
        }
        int a_half_kth = a_left + k / 2 - 1 < a.length ? a[a_left + k / 2 - 1] : Integer.MAX_VALUE;
        int b_half_kth = b_left + k / 2 - 1 < b.length ? b[b_left + k / 2 - 1] : Integer.MAX_VALUE;
        if (a_half_kth < b_half_kth) {
            return findKthSmallest(a, b, a_left + k / 2, b_left, k - k / 2);
        } else {
            return findKthSmallest(a, b, a_left, b_left + k / 2, k - k / 2);
        }
    }
}