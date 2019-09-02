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
            for (int i=left;i<right;i++){
                res.add(matrix[top][i]);
            }
            for (int i=top;i<bottom;i++){
                res.add(matrix[i][right]);
            }
            for (int i=right;i>left;i--){
                res.add(matrix[bottom][i]);
            }
            for (int i=bottom;i>top;i--){
                res.add(matrix[i][left]);
            }
            top++;
            bottom--;
            left++;
            right--;
        }
        //job may not get done after while loop due to matrix ratio
        if (top==bottom){
            for (int i=left;i<=right;i++){
                res.add(matrix[top][i]);
            }
        }
        else if(left==right){
            for (int i=top;i<=bottom;i++){
                res.add(matrix[i][left]);
            }
        }
        return res;
    }
}