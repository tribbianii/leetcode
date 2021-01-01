package leetcode;

import java.util.*;

public class GraphCriticalConnectionsInNetwork {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i ++) {
            graph[i] = new ArrayList<>();
        }
        for (List<Integer> conn : connections) {
            graph[conn.get(0)].add(conn.get(1));
            graph[conn.get(1)].add(conn.get(0));
        }
        int[] level = new int[n];
        level[0] = 1;
        List<List<Integer>> critical = new ArrayList<>();
        dfs(graph, level, 0, -1, critical);
        return critical;
    }
    // return the min level of curr and curr's neighbors
    private int dfs(List<Integer>[] graph, int[] level, int curr, int prev, List<List<Integer>> critical) {
        if (prev >= 0 && level[curr] > 0) {
            return level[curr];
        }
        if (prev >= 0) {
            level[curr] = level[prev] + 1;
        }
        int minNextLevel = Integer.MAX_VALUE;
        for (int next : graph[curr]) {
            if (next != prev) {
                int nextLevel = dfs(graph, level, next, curr, critical);
                minNextLevel = Math.min(minNextLevel, nextLevel);
            }
        }
        // if minNextLevel greater than level[curr] means all neighbors are visited AFTER current node
        // which makes prev to curr critical (edge)
        if (minNextLevel >= level[curr] && prev >= 0) {
            critical.add(Arrays.asList(prev, curr));
        }
        return Math.min(level[curr], minNextLevel);
    }
    // following is ood solution
    static class Node {
        int id;
        int level;
        List<Node> nexts;
        public Node(int num) {
            this.id = num;
            this.level = 0;
            this.nexts = new ArrayList<>();
        }
    }
    public List<List<Integer>> CriticalConnections(int n, List<List<Integer>> connections) {
        Map<Integer, Node> map = new HashMap<>();
        for (List<Integer> conn : connections) {
            int l = conn.get(0);
            int r = conn.get(1);
            map.putIfAbsent(l, new Node(l));
            map.putIfAbsent(r, new Node(r));
            map.get(l).nexts.add(map.get(r));
            map.get(r).nexts.add(map.get(l));
        }
        Node entry = map.get(0);
        entry.level = 1;
        List<List<Integer>> critical = new ArrayList<>();
        for (Node next : entry.nexts) {
            Dfs(entry, next, critical);
        }
        return critical;
    }
    public int Dfs(Node prev, Node curr, List<List<Integer>> critical) {
        if (curr.level > 0) {
            return curr.level;
        }
        curr.level = prev.level + 1;
        int minNextLevel = Integer.MAX_VALUE;
        for (Node next : curr.nexts) {
            if (next.id != prev.id) {
                minNextLevel = Math.min(minNextLevel, Dfs(curr, next, critical));
            }
        }
        if (minNextLevel >= curr.level) {
            critical.add(Arrays.asList(prev.id, curr.id));
        }
        return Math.min(curr.level, minNextLevel);
    }
}
