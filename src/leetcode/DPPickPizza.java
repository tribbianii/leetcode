package leetcode;

public class DPPickPizza {
    public int pickLargestPizza(int[] pizza) {
        int len = pizza.length;
        int[][] dp = new int[len][len];
        boolean[][] visited = new boolean[len][len];
        for (int i = 0; i < len; i ++) {
            dp[i][i] = pizza[i];
            visited[i][i] = true;
            if (i < len - 1) {
                dp[i][i + 1] = Math.max(pizza[i], pizza[i + 1]);
                visited[i][i + 1] = true;
            }
        }
        dfs(pizza, dp, visited, 0, len - 1);
        return dp[0][len - 1];
    }
    public void dfs(int[] pizza, int[][] dp, boolean[][] visited, int i, int j) {
        if (visited[i][j]) {
            return;
        }
        if (!visited[i + 1][j - 1]) {
            dfs(pizza, dp, visited, i + 1, j - 1);
            visited[i + 1][j - 1] = true;
        }
        if (!visited[i + 2][j]) {
            dfs(pizza, dp, visited, i + 2, j);
            visited[i + 2][j] = true;
        }
        if (!visited[i][j - 2]) {
            dfs(pizza, dp, visited, i, j - 2);
            visited[i][j - 2] = true;
        }
        dp[i][j] = Math.max(pizza[i] + (pizza[i + 1] < pizza[j] ? dp[i + 1][j - 1] : dp[i + 2][j]),
                            pizza[j] + (pizza[i] < pizza[j - 1] ? dp[i][j - 2] : dp[i + 1][j - 1]));
    }
}
