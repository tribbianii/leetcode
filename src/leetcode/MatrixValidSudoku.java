package leetcode;

import java.util.Arrays;

public class MatrixValidSudoku{
    public boolean isValidSudoku(int[][] board) {
        if (board==null||board.length==0){
            return false;
        }

        boolean[] used = new boolean[9];//这个的index是0-8
        //true means this number have already existed
        //false means this number hasn't been used

        //for every column check
        for (int i=0;i<9;i++){
            Arrays.fill(used, false);
            for (int j=0;j<9;j++){
                if (exist(i,j,board,used)==false){
                    return false;
                }
            }
        }
        //for every row check
        for (int j=0;j<9;j++){
            Arrays.fill(used, false);
            for (int i=0;i<9;i++){
                if (exist(i,j,board,used)==false){
                    return false;
                }
            }
        }
        //for every 3*3 square check
        for (int i=0;i<7;i+=3){
            for (int j=0;j<7;j+=3){
                Arrays.fill(used, false);
                for (int m=i;m<i+3;m++){
                    for (int n=j;n<j+3;n++){
                        if (exist(m,n,board,used)==false){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
    public boolean exist(int i, int j, int[][]board, boolean[]used){
        if (board[i][j]=='.'){
            return true;
        }
        //没有引号
        //如果你的输入是int[][]，那你减去的应该是整数
        //这个应该是对的
        //你的输入应在1-9
        //else {
            if (used[board[i][j]-1]==true){
                return false;
            }
            else {
                used[board[i][j]-1] = true;
                return true;
            }
        //}
    }
}