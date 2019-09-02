package leetcode;

public class MatrixSearch2DMatrixII{
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix==null||matrix.length==0||matrix[0].length==0){
            return false;
        }   
        int height = matrix.length;
        int width = matrix[0].length;
        if (target<matrix[0][0] || target>matrix[height-1][width-1]){
            return false;
        }
        int height_max = search(0,height-1,0,0,matrix,target);
        if (matrix[height_max][0]==target) {
            return true;
        }
        int width_max = search(0,width-1,1,0,matrix,target);
        if (matrix[0][width_max]==target) {
            return true;
        }
        for (int i=height_max;i>=0;i--){
            int j = search(0,width_max,1,i,matrix,target);
            if (matrix[i][j]==target){
                return true;
            }
        }
        return false;
    }
    public int search(int start, int end, int dir, int fixed, int[][]matrix, int target){
        if (start==end){
            return start;
        }
        if (dir==0){
            //search matrix[x][0]
            while (start!=end){
                int mid = start+(end-start)/2;
                if (matrix[mid][fixed]==target){
                    return mid;
                }
                else if (matrix[mid][fixed]>target){
                    end = mid;
                }
                else {
                    start = mid+1;
                }
            }
        }
        else {
            //search matrix[0][y]
            while (start!=end){
                int mid = start+(end-start)/2;
                if (matrix[fixed][mid]==target){
                    return mid;
                }
                else if (matrix[fixed][mid]>target){
                    end = mid;
                }
                else {
                    start = mid+1;
                }
            }
        }
        return start;
    }
    //my method accepted at first submission!
}