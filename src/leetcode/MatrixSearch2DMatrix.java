package leetcode;

public class MatrixSearch2DMatrix{
    public boolean searchMatrix(int[][] matrix, int target){
        if (matrix==null||matrix.length==0||matrix[0].length==0){
            return false;
        }  
        int height = matrix.length;
        int width = matrix[0].length;
        if (target<matrix[0][0] || target>matrix[height-1][width-1]){
            return false;
        }
        int end  = height*width-1;
        int start = 0;
        while (start!=end){
            int mid = start+(end-start)/2;
            int i = mid/width;
            int j = mid%width;
            if (matrix[i][j]==target){
                return true;
            }
            if (matrix[i][j]>target){
                end = mid;
            }
            else {
                start = mid+1;
            }
        }
        int i = start/width;
        int j = start%width;
        return matrix[i][j]==target;
    }
}