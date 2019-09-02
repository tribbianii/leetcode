package leetcode;

public class BFSDFSSurroundedRegions{
    public void solve(char[][] board) {
        if (board==null || board.length==0){
            return;
        }
        for (int i=0;i<board.length;i=board.length==1?i+1:i+board.length-1){
            for (int j=0;j<board[0].length;j++){
                if (board[i][j]=='O'){
                    dfs(i,j,board,false);
                }
            }
        }
        for (int j=0;j<board[0].length;j=board[0].length==1?j+1:j+board[0].length-1){
            for (int i=0;i<board.length;i++){
                if (board[i][j]=='O'){
                    dfs(i,j,board,false);
                }   
            }
        }
        for (int i=1;i<board.length-1;i++){
            for (int j=1;j<board[0].length-1;j++){
                if (board[i][j]=='O'){
                    dfs(i,j,board,true);
                }
            }
        }
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                if (board[i][j]=='Y'){
                    board[i][j]='O';
                }
            }
        }
    }
    private void dfs(int i, int j, char[][]board, boolean validO){
        if (i<0||j<0||i>=board.length||j>=board[0].length||board[i][j]=='X'||board[i][j]=='Y'){
            return;
        }
        board[i][j]=validO?'X':'Y';
        dfs(i+1,j,board,validO);
        dfs(i,j+1,board,validO);
        dfs(i-1,j,board,validO);
        dfs(i,j-1,board,validO);
    }
}