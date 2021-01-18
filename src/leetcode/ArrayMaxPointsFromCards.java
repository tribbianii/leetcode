package leetcode;

public class ArrayMaxPointsFromCards {
    public int maxScore(int[] cardPoints, int k) {
        int totalSum = 0;
        for (int point : cardPoints) {
            totalSum += point;
        }
        int len = cardPoints.length;
        int sum = 0;
        int minSum = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        while (right < len) {
            if (right - left == len - k) {
                minSum = Math.min(sum, minSum);
                sum += (cardPoints[right++] - cardPoints[left++]);
            } else {
                sum += cardPoints[right++];
            }
        }
        minSum = Math.min(sum, minSum);
        return totalSum - minSum;
    }
}
