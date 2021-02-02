package leetcode;

public class BitManipulationFindTheDuplicate {
    // 2 <= n <= 3 * 10^4
    public int findDuplicate(int[] nums) {
        int[] dic = new int[1000];
        for (int num : nums) {
            int row = num / 32;
            int col = num % 32;
            if (((dic[row] >> col) & 1) == 1) {
                return num;
            } else {
                dic[row] = dic[row] | (1 << col);
            }
        }
        return -1;
    }
}
