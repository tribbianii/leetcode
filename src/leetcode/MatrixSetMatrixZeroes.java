package leetcode;

public class MatrixSetMatrixZeroes{
    public void setZeroes(int[][] matrix) {
        if (matrix==null||matrix.length==0||matrix[0].length==0){
            return;
        }
        boolean firstRowis0=false;
        boolean firstColis0=false;
        for (int i=0;i<matrix.length;i++){
            if (matrix[i][0]==0){
                firstColis0=true;
                break;
            }
        }
        for (int j=0;j<matrix[0].length;j++){
            if (matrix[0][j]==0){
                firstRowis0=true;
                break;
            }
        }
        for (int i=1;i<matrix.length;i++){
            for (int j=1;j<matrix[0].length;j++){
                if (matrix[i][j]==0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int i=1;i<matrix.length;i++){
            if (matrix[i][0]==0){
                for (int j=1;j<matrix[0].length;j++){
                    matrix[i][j]=0;
                }
            }
        }
        for (int j=1;j<matrix[0].length;j++){
            if (matrix[0][j]==0){
                for (int i=1;i<matrix.length;i++){
                    matrix[i][j]=0;
                }
            }
        }
        if (firstRowis0){
            for (int j=0;j<matrix[0].length;j++){
                matrix[0][j]=0;
            }
        }
        if (firstColis0){
            for (int i=0;i<matrix.length;i++){
                matrix[i][0]=0;
            }
        }
    }
}