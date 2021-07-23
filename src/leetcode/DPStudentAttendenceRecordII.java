package leetcode;

public class DPStudentAttendenceRecordII {
    public int checkRecord(int n) {
        return dfs(n - 1, 0, 0, new int[n][2][3], new boolean[n][2][3], (int)Math.pow(10, 9) + 7);
    }
    public int dfs(int days, int num_a, int num_conse_l, int[][][] cache, boolean[][][] visited, int mod) {
        if (days < 0) {
            return 1;
        }
        if (visited[days][num_a][num_conse_l]) {
            return cache[days][num_a][num_conse_l];
        }
        int result = 0;
        if (num_a == 0) {
            result += dfs(days - 1, 1, 0, cache, visited, mod);
            result %= mod;
        }
        if (num_conse_l < 2) {
            result += dfs(days - 1, num_a, num_conse_l + 1, cache, visited, mod);
            result %= mod;
        }
        result += dfs(days - 1, num_a, 0, cache, visited, mod);
        result %= mod;
        visited[days][num_a][num_conse_l] = true;
        cache[days][num_a][num_conse_l] = result;
        return result;
    }
}
