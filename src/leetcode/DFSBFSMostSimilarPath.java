package leetcode;

import java.util.ArrayList;
import java.util.List;

public class DFSBFSMostSimilarPath {
    public List<Integer> mostSimilar(int n, int[][] roads, String[] names, String[] targetPath) {
        List<Integer> res = new ArrayList<>();
        List<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i ++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int[] road : roads) {
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }
        int[][] minDist = new int[targetPath.length][n];
        boolean[][] visited = new boolean[targetPath.length][n];
        int[][] nextCity = new int[targetPath.length - 1][n];
        int min = Integer.MAX_VALUE;
        int start = 0;
        for (int j = 0; j < names.length; j ++) {
            int dist = dfs(j, 0, graph, minDist, visited, nextCity, names, targetPath);
            if (dist < min) {
                start = j;
                min = dist;
            }
        }
        res.add(start);
        for (int k = 0; k < nextCity.length; k ++) {
            start = nextCity[k][start];
            res.add(start);
        }
        return res;
    }
    public int dfs(int city, int index, List<ArrayList<Integer>> graph, int[][] minDist, boolean[][] visited, int[][] nextCity, String[] names, String[] targetPath) {
        if (visited[index][city]) {
            return minDist[index][city];
        }
        int minDistCurr = targetPath[index].equals(names[city]) ? 0 : 1;
        if (index == targetPath.length - 1) {
            return minDistCurr;
        }
        int minDistNext = Integer.MAX_VALUE;
        for (int next : graph.get(city)) {
            int nextDist = dfs(next, index + 1, graph, minDist, visited, nextCity, names, targetPath);
            if (minDistNext > nextDist) {
                minDistNext = nextDist;
                nextCity[index][city] = next;
                minDist[index][city] = minDistCurr + minDistNext;
            }
        }
        visited[index][city] = true;
        return minDist[index][city];
    }
}
