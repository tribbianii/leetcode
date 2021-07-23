package leetcode;

public class BFSDFSSurroundedRegions{
    public void solve(char[][] board) {
        boolean[][] keep = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[0].length; j ++) {
                if (i * j == 0 || i == board.length - 1 || j == board[0].length - 1) {
                    dfs(board, keep, i, j);
                }
            }
        }
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[0].length; j ++) {
                if (board[i][j] == 'O' && !keep[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }
    public void dfs(char[][] board, boolean[][] keep, int row, int col) {
        if (row < 0 || row == board.length || col < 0 || col == board[0].length || board[row][col] == 'X' || keep[row][col]) {
            return;
        }
        keep[row][col] = true;
        dfs(board, keep, row + 1, col);
        dfs(board, keep, row - 1, col);
        dfs(board, keep, row, col + 1);
        dfs(board, keep, row, col - 1);
    }
}