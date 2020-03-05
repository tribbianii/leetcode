package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class MatrixShortestDistanceFromAllBuildings {
    final int[] shift = new int[] {0, 1, 0, -1, 0};
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid[0].length == 0) {
            return 0;
        }
        int maxRow  = grid.length;
        int maxCol = grid[0].length;
        int[][] distance = new int[maxRow][maxCol];
        //each cell(space, because only space considered)'s value means the sum of distance between that cell and all BUILDINGs that cell can reach
        int[][] reach = new int[maxRow][maxCol];
        //each cell(space, because only space considered)'s value means the number of BUILDINGs that cell can reach
        int buildingNum = 0;
        for (int i = 0; i < maxRow; i++) {
            for (int j =0; j < maxCol; j++) {
                if (grid[i][j] == 1) {
                    buildingNum++;
                    bfs(grid, i, j, maxRow, maxCol, distance, reach);
                }
            }
        }
        int shortest = Integer.MAX_VALUE;
        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxCol; j++) {
                if (grid[i][j] == 0 && reach[i][j] == buildingNum) {
                    //must be space and must have access to all buildings
                    shortest = Math.min(shortest, distance[i][j]);
                }
            }
        }
        return shortest == Integer.MAX_VALUE ? -1 : shortest;
    }
    public void bfs(int[][] grid, int i, int j, int maxRow, int maxCol, int[][] distance, int[][] reach) {
        Queue<int[]> myQueue = new LinkedList<int[]>();
        myQueue.offer(new int[] {i,j});
        boolean[][] isVisited = new boolean[maxRow][maxCol];
        int level = 1;
        //initial step set to 1, will increment later
        while (!myQueue.isEmpty()) {
            int qSize = myQueue.size();
            //pop out all SPACE which are reached from BUILDING grid[i][j] by SAME steps
            for (int q = 0; q < qSize; q++) {
                int[] curr = myQueue.poll();
                for (int k = 0; k < 4; k++) {
                    //move to all four directions
                    int nextRow = curr[0] + shift[k];
                    int nextCol = curr[1] + shift[k + 1];
                    if (nextRow >= 0 && nextRow < maxRow && nextCol >= 0 && nextCol < maxCol && grid[nextRow][nextCol] == 0 && !isVisited[nextRow][nextCol]){
                        //must be not visited inbound space
                        distance[nextRow][nextCol] += level;
                        //means SUM of distance between SPACE grid[nextRow][nextCol] and BUIDLDING grid[i][j] plus all BUILDINGs before grid[i][j]
                        reach[nextRow][nextCol]++;
                        //means grid[nextRow][nextCol] can reach one more building   
                        isVisited[nextRow][nextCol] = true;
                        myQueue.offer(new int[] {nextRow, nextCol});
                    }
                }
            }
            level ++;
            //headed to next round so step+1
        }
    }
}