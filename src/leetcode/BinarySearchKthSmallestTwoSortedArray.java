package leetcode;

public class BinarySearchKthSmallestTwoSortedArray {
    // wrong answer
    public static int findKthSmallest(int[] a, int[] b, int k) {
        int a_from = 0;
        int b_from = 0;
        int a_to = 0;
        int b_to = 0; 
        int num_a = 0;
        int num_b = 0;
        int side = 0;
        int size = k;
        while (size > 0) {
            if (size % 2 == 0) {
                a_to = a_from + size / 2 - 1;
                b_to = b_from + size / 2 - 1;
            } else {
                a_to = a_from + size / 2 - 1;
                b_to = b_from + size / 2;
            }
            num_a = a[a_to];
            num_b = b[b_to];
            if (num_a < num_b) {
                a_from = a_to + 1;
                side = 1;
            } else {
                b_from = b_to + 1;
                side = 0;
            }
            size = (size > 1 && size % 2 == 1 && side == 1) ? size / 2 + 1 : size / 2;
        }
        return side == 1 ? num_a : num_b;
        // return k % 2 == 0 ? Math.min(num_a, num_b) : Math.max(num_a, num_b);
    }
    public static void main(String[] args) {
        int[] a = new int[16];
        int[] b = new int[16];
        int num_a = 1;
        int num_b = 2;
        for (int i = 0; i < 16; i ++) {
            a[i] = num_a += 2;
            b[i] = num_b += 2;
        }
        System.out.println(findKthSmallest(a, b, 4));
    }
}