package leetcode;

public class BFSDFSNumberOfIslands{
    public int numIslands(char[][] grid) {
        if (grid==null || grid.length==0){
            return 0;
        }   
        int res = 0;
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (grid[i][j]=='1'){
                    res++;
                    dfs(i,j,grid);
                }
            }
        }
        return res;
    }
    public void dfs(int i, int j, char[][]grid){
        if (i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]=='0'){
            return;
        }
        grid[i][j]='0';
        dfs(i+1,j,grid);
        dfs(i,j+1,grid);
        dfs(i-1,j,grid);
        dfs(i,j-1,grid);
    }
    //general idea is to firstly find a '1'
    //then count increment by 1
    //then change all adjacent(4 directions) '1' to '0' as they're considered as one island
    //finally cycle end by meeting water
    //another cycle begins to find next '1'
}