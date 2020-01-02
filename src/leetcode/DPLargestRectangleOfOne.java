package leetcode;

public class DPLargestRectangleOfOne {
    public int largest (int[][] arr) {
        if (arr == null || arr.length == 0) {
          return 0;
        }
        lengthOfConsecutiveOne(arr);
        int maxArea = 0;
        for (int i = 0; i < arr.length; i++) {
          for (int j = 0; j < arr[0].length; j++) {
            maxArea = Math.max(maxArea, maxOfOneCellAsRightDown (arr, i, j));
          }
        }
        return maxArea;
      }
    private void lengthOfConsecutiveOne (int[][] arr) {
      for (int i = 0; i <arr.length; i++) {
        for (int j = 0; j < arr[0].length; j++) {
          arr[i][j] = j == 0 ? arr[i][j] : (arr[i][j - 1] + 1) * arr[i][j];
        }
      }
    }
    private int maxOfOneCellAsRightDown (int[][] arr, int i, int j) {
      if (arr[i][j] != 0) {
        int maxArea = 0;
        int minLen = arr[i][j];
        int height = 1;
        while (i >= 0 && arr[i][j] != 0) {
          minLen = Math.min(minLen, arr[i--][j]);
          maxArea = Math.max(maxArea, height++ * minLen);
        }
        return maxArea;
      }
      return 0;
    }
  }