package leetcode;

public class MatrixSparseMatrixMultiplication {
    public int[][] multiply(int[][] A, int[][] B) {
        int col = A.length;
        int row = B[0].length;
        int shared = A[0].length;
        int[][] res = new int[col][row];
        for (int i = 0; i < col; i ++) {
            for (int j = 0; j < row; j ++) {
                int index = 0;
                while (index < shared) {
                    res[i][j] +=  A[i][index] * B[index][j];
                    index ++;
                }
            }
        }
        return res;
    }
}