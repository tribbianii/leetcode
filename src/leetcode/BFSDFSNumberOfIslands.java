package leetcode;

public class BFSDFSNumberOfIslands{
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0){
            return 0;
        }   
        int num = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i ++){
            for (int j = 0; j < grid[0].length; j ++){
                if (grid[i][j] == '1' && !visited[i][j]){
                    num ++;
                    dfs(i, j, grid, visited);
                }
            }
        }
        return num;
    }
    public void dfs(int i, int j, char[][]grid, boolean[][] visited){
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0' || visited[i][j]){
            return;
        }
        visited[i][j] = true;
        dfs(i + 1, j, grid, visited);
        dfs(i, j + 1, grid, visited);
        dfs(i-1, j, grid, visited);
        dfs(i, j-1, grid, visited);
    }
    // method 2 even faster a bit
    public int num;
    public int NumIslands(char[][] grid) {
        if (grid == null || grid.length == 0){
            return 0;
        }
        num = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i ++){
            for (int j = 0; j < grid[0].length; j ++){
                dfs(i, j, grid, visited, false);
            }
        }
        return num;
    }
    public void dfs(int i, int j, char[][]grid, boolean[][] visited, boolean counted){
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0' || visited[i][j]){
            return;
        }
        num = counted ? num : num + 1;
        visited[i][j] = true;
        dfs(i + 1, j, grid, visited, true);
        dfs(i, j + 1, grid, visited, true);
        dfs(i-1, j, grid, visited, true);
        dfs(i, j-1, grid, visited, true);
    }
    //following is for max island area
    public int maxArea = 0;
    public int maxAreaOfIsland(char[][] grid) {
        if (grid==null || grid.length==0){
            return 0;
        }
        num = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i ++){
            for (int j = 0; j < grid[0].length; j ++){
                dfs(i, j, grid, visited);
            }
        }
        return num;
    }
    public int Dfs(int i, int j, char[][]grid, boolean[][] visited){
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0' || visited[i][j]){
            return 0;
        }
        visited[i][j] = true;
        int down = Dfs(i + 1, j, grid, visited);
        int right = Dfs(i, j + 1, grid, visited);
        int up = Dfs(i - 1, j, grid, visited);
        int left = Dfs(i, j - 1, grid, visited);
        int area = up + down + left + right + 1;
        maxArea = Math.max(area, maxArea);
        return area;
    }
}