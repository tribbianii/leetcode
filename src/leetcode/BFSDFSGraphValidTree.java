package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BFSDFSGraphValidTree {
    int nodes;
    public boolean validTree(int n, int[][] edges) {
        if (n <= 1) {
            return true;
        }
        if (edges == null || edges.length != n - 1) {
            return false;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            map.put(edge[0], map.getOrDefault(edge[0], new ArrayList<>()));
            map.get(edge[0]).add(edge[1]);
            map.put(edge[1], map.getOrDefault(edge[1], new ArrayList<>()));
            map.get(edge[1]).add(edge[0]);
        }
        if (map.keySet().size() != n) {
            return false;
        }
        nodes = 1;
        boolean[] visited = new boolean[n];
        visited[0] = true;
        for (Integer next : map.get(0)) {
            if (!dfs(map, visited, 0, next)) {
                return false;
            }
        }
        return nodes == n;
    }
    public boolean dfs(Map<Integer, List<Integer>> map, boolean[] visited, int prev, int curr) {
        if (visited[curr]) {
            return true;
        }
        visited[curr] = true;
        for (Integer next : map.get(curr)) {
            if (next != prev && (visited[next] || !dfs(map, visited, curr, next))) {
                return false;
            }
        }
        nodes ++;
        return true;
    }
}
