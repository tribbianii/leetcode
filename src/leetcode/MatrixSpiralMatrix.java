package leetcode;

import java.util.ArrayList;
import java.util.List;

//output elements form matrix
public class MatrixSpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if (matrix==null||matrix.length==0||matrix[0].length==0){
            return res;
        }
        int top =0;
        int bottom = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;
        while (top<bottom && left<right){
            for (int i=left;i<right;i++) { res.add(matrix[top][i]); }
            for (int i=top;i<bottom;i++) { res.add(matrix[i][right]); }
            for (int i=right;i>left;i--) { res.add(matrix[bottom][i]); }
            for (int i=bottom;i>top;i--) { res.add(matrix[i][left]); }
            top++;
            bottom--;
            left++;
            right--;
        }
        //job may not get done after while loop due to matrix ratio
        if (top==bottom){
            for (int i=left;i<=right;i++) { res.add(matrix[top][i]); }
        }
        else if(left==right){
            for (int i=top;i<=bottom;i++){ res.add(matrix[i][left]); }
        }
        return res;
    }
    //Note following method only applies to square
    public List<Integer> spiralOrderRecursion(int[][] matrix) {
        int len = matrix[0].length;
        List<Integer> res = new ArrayList<Integer>();
        cycle(res, matrix, len, 0, len);
        return res;
    }
    private void cycle (List<Integer> res, int[][] matrix, int len, int offset, int size) {
        if (size <= 1) {
            if(size == 1) { 
                res.add(matrix[offset][offset]); 
            }
            return;
        }
        for (int i = 0; i < size - 1; i++) {
            res.add(matrix[offset][i + offset]);
        }
        for (int j = 0; j < size - 1; j++) {
            res.add(matrix[j + offset][len - offset - 1]);
        }
        for (int m = 0; m < size - 1; m++) {
            res.add(matrix[len - offset - 1][len - offset - m - 1]);
        }
        for (int n = 0; n < size - 1; n++) {
            res.add(matrix[len - offset - n - 1][offset]);
        }
        cycle(res, matrix, len, offset+1, size-2);
    }
}