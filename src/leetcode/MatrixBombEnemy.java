package leetcode;

public class MatrixBombEnemy{
    public int maxKilledEnemies(char[][] grid) {
        if (grid==null||grid.length==0||grid[0].length==0){
            return 0;
        }
        int res = 0;
        int[][] killRow = new int[grid.length][grid[0].length];
        int[][] killCol = new int[grid.length][grid[0].length];
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (grid[i][j]=='0'){
                    res = Math.max(res, killrow(i,j,grid,killRow)+killcol(i,j,grid,killCol));
                }
            }
        }
        return res;
    }
    public int killrow(int i, int j, char[][]grid, int [][]killRow){
        if (i>0 && grid[i-1][j]=='0'){
            killRow[i][j] = killRow[i-1][j];
            return killRow[i][j];
        }
        else {
            int nums = 0;
            int i_left = i-1;
            int i_right = i+1;
            while (i_left>=0 && grid[i_left][j]!='W'){
                if (grid[i_left][j]=='E'){
                    nums++;
                }
                i_left--;
            }
            while (i_right<grid.length && grid[i_right][j]!='W'){
                if (grid[i_right][j]=='E'){
                    nums++;
                }
                i_right++;
            }
            killRow[i][j] = nums;
            return nums;
        }
    }
    public int killcol(int i, int j, char[][]grid, int [][]killCol){
        if (j>0 && grid[i][j-1]=='0'){
            killCol[i][j] = killCol[i][j-1];
            return killCol[i][j];
        }
        else {
            int nums = 0;
            int j_up = j+1;
            int j_down = j-1;
            while (j_down>=0 && grid[i][j_down]!='W'){
                if (grid[i][j_down]=='E'){
                    nums++;
                }
                j_down--;
            }
            while (j_up<grid[0].length && grid[i][j_up]!='W'){
                if (grid[i][j_up]=='E'){
                    nums++;
                }
                j_up++;
            }
            killCol[i][j] = nums;
            return nums;
        }
    }
}