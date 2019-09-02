package leetcode;

public class MatrixWordSearch{
    public boolean exist(char[][] board, String word) {
        if (board==null||board.length==0||board[0].length==0){
            return false;
        }
        boolean[][] used = new boolean[board.length][board[0].length];
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                if (board[i][j]==word.charAt(0)){
                    if (exist(i,j,board,0,used,word)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean exist(int i, int j, char[][] matrix, int curr_len, boolean[][] used, String word){
        if (curr_len==word.length()){
            return true;
        }
        if (i<0||i>matrix.length-1||j<0||j>matrix[0].length-1){
            return false;
        }
        if (used[i][j]){
            return false;
        }
        if (matrix[i][j]==word.charAt(curr_len)){
            used[i][j]=true;;
            curr_len++;
            if (exist(i-1,j,matrix,curr_len,used,word)){
                return true;
            }
            if (exist(i+1,j,matrix,curr_len,used,word)){
                return true;
            }
            if (exist(i,j-1,matrix,curr_len,used,word)){
                return true;
            }
            if (exist(i,j+1,matrix,curr_len,used,word)){
                return true;
            }
        }
        used[i][j]=false;
        //backtracking
        return false;
    }
}