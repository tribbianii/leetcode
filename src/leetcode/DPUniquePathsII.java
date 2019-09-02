package leetcode;

public class DPUniquePathsII {
    public int WithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i+j==0&&obstacleGrid[i][j]==0){
                    obstacleGrid[i][j]=1;
                    continue;
                }
                if (obstacleGrid[i][j]==1) {
                    obstacleGrid[i][j]=0;
                    continue;
                }
                if (i*j==0 && (i+j)>0) {
                    if (i==0){
                        obstacleGrid[i][j] = obstacleGrid[i][j-1];
                        continue;
                    }
                    else{
                        obstacleGrid[i][j] = obstacleGrid[i-1][j];
                        continue;
                    }
                }
                obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
            }
        }
        return obstacleGrid[m-1][n-1];
    }
}
