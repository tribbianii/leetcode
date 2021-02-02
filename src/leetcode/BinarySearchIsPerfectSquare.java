package leetcode;

public class BinarySearchIsPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }
        int left = 1;
        int right = num;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid > num / mid) {
                right = mid - 1;
            } else if (mid < num / mid || mid * mid < num) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
