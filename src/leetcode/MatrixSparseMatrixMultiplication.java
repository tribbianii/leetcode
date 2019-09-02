package leetcode;

import java.util.ArrayList;
import java.util.List;

public class MatrixSparseMatrixMultiplication {
    public int[][] multiply(int[][] A, int[][] B) {
        int h1 = A.length;
        int w2 = B[0].length;
        int[][] res = new int[h1][w2];
        for (int i=0;i<h1;i++){
            for (int j=0;j<w2;j++){
                for (int k=0;k<w2;k++){
                    res[i][j] = res[i][j]+A[i][k]*B[k][j]; 
                }
            }
        }
        return res;
    }
    //original method regarding the rules of matrix multiplicaton
    public int[][] Multiply(int[][] A, int[][] B) {
        int m = A.length, n = A[0].length, nB = B[0].length;
        int[][] result = new int[m][nB];
        List[] indexA = new ArrayList[m];
        for(int i = 0; i < m; i++) {
            List<Integer> numsA = new ArrayList<>();
            for(int j = 0; j < n; j++) {
                if(A[i][j] != 0){
                    numsA.add(j); 
                    numsA.add(A[i][j]);
                }
            }
            indexA[i] = numsA;
        }
        //generate array filled with lists
        //each list contain pairs of numbers representing--
        //A's each row's non-zero number index and value
        //for simplifying computing
        for(int i = 0; i < m; i++) {
            List<Integer> numsA = indexA[i];
            for(int p = 0; p < numsA.size() - 1; p += 2) {
                int colA = numsA.get(p);
                int valA = numsA.get(p + 1);
                for(int j = 0; j < nB; j ++) {
                    int valB = B[colA][j];
                    //row number of valB should be column number of valA
                    result[i][j] += valA * valB;
                    //only non-zero numbers of A get involved
                }
            }
        }
        return result;   
    }
}