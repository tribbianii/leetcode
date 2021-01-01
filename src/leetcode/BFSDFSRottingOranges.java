package leetcode;

public class BFSDFSRottingOranges {
    public int orangesRotting(int[][] grid) {
        int[][] time = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j ++) {
                if (grid[i][j] == 2 && time[i][j] == 0) {
                    dfs(grid, time, i, j, -1);
                }
            }
        }
        int minute = 0;
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j ++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
                minute = Math.max(time[i][j], minute);
            }
        }
        return minute;
    }
    public void dfs(int[][] grid, int[][] time, int col, int row, int prevTime) {
        // skip all empty cells and rotten ones that MUST NOT got 'infected' by previous one
        if (col < 0 || col >= grid.length || row < 0 || row >= grid[0].length || grid[col][row] == 0 || (grid[col][row] == 2 && time[col][row] < prevTime + 1)) {
            return;
        }
        grid[col][row] = 2;
        time[col][row] = prevTime + 1;
        dfs(grid, time, col - 1, row, prevTime + 1);
        dfs(grid, time, col + 1, row, prevTime + 1);
        dfs(grid, time, col, row - 1, prevTime + 1);
        dfs(grid, time, col, row + 1, prevTime + 1);
    }
}
