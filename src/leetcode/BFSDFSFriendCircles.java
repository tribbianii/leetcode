package leetcode;

public class BFSDFSFriendCircles {
    public int findCircleNum(int[][] M) {
        int groups = 0;
        boolean[] visited = new boolean[M.length];
        for (int i = 0; i < M.length; i ++) {
            if (!visited[i]) {
                groups ++;
                dfs(M, visited, i);
            }
        }
        return groups;
    }
    public void dfs(int[][] M, boolean[] visited, int person) {
        for (int j = 0; j < M.length; j ++) {
            if (!visited[j] && M[person][j] == 1) {
                visited[j] = true;
                dfs(M, visited, j);
            }
        }
    }
}
