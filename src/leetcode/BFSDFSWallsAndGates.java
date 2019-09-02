package leetcode;

public class BFSDFSWallsAndGates{
    private static int[] d = {0, 1, 0, -1, 0};
    public void WallsAndGates(int[][] rooms) {
        for (int i = 0; i < rooms.length; i++){
            for (int j = 0; j < rooms[0].length; j++){
                if (rooms[i][j] == 0) {
                    dfs(rooms, i, j);
                }
            }
        }
    }
    public void dfs(int[][] rooms, int i, int j) {
        for (int k = 0; k < 4; ++k) {
            int p = i + d[k];
            int q = j + d[k + 1];
            if (p>=0 && p < rooms.length && q>=0 && q < rooms[0].length && rooms[p][q] > rooms[i][j] + 1) {
                rooms[p][q] = rooms[i][j] + 1;
                dfs(rooms, p, q);
            }
        }
    }
}