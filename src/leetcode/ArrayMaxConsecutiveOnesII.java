package leetcode;

public class ArrayMaxConsecutiveOnesII {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxStreak = 0;
        int streak = 0;
        int zeroLeft = 0;
        int zeroRight = 0;
        int index = 0;
        boolean flipped = false;
        while (index < nums.length) {
            if (nums[index] == 0) {
                maxStreak = Math.max((flipped ? 1 : 0) + zeroLeft + zeroRight, maxStreak);
                streak = zeroRight + 1;
                zeroLeft = zeroRight;
                zeroRight = 0;
                flipped = true;
            } else {
                streak ++;
                zeroRight ++;
            }
            index ++;
        }
        return Math.max(maxStreak, streak);
    }
}
