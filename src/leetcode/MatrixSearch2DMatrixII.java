package leetcode;

public class MatrixSearch2DMatrixII{
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int shorterDim = Math.min(matrix.length, matrix[0].length);
        for (int i = 0; i < shorterDim; i ++) {
            if (binarySearch(matrix, target, i, true) || binarySearch(matrix, target, i, false)) {
                return true;
            }
        }
        return false;
    }
    private boolean binarySearch(int[][] matrix, int target, int start, boolean checkRow) {
        int lo = start;
        int hi = checkRow ? matrix[0].length - 1 : matrix.length - 1;
        while (hi >= lo) {
            int mid = (lo + hi)/2;
            if (checkRow) {
                if (matrix[start][mid] == target) {
                    return true;
                } else if (matrix[start][mid] > target) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (matrix[mid][start] == target) {
                    return true;
                } else if (matrix[mid][start] > target) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
        }
        return false;
    }
}