package leetcode;

public class BFSDFSWordSearch{
    public int[] dirs = new int[]{1, 0, -1, 0, 1};
    public boolean exist(char[][] board, String word) {
        char[] arr = word.toCharArray();
        char c = arr[0];
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[0].length; j ++) {
                if (board[i][j] == arr[0]) {
                    if (dfs(board, arr, 0, i, j, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, char[] word, int index, int x, int y, boolean[][] visited) {
        if (index == word.length) {
            return true;
        }
        if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && !visited[x][y] && board[x][y] == word[index]) {
            visited[x][y] = true;
            for (int i = 0; i < dirs.length - 1; i ++) {
                int newX = x + dirs[i];
                int newY = y + dirs[i + 1];
                if (dfs(board, word, index + 1, newX, newY, visited)) {
                    return true;
                }
            }
            // backtracking
            visited[x][y] = false;
        }
        return false;
    }
}