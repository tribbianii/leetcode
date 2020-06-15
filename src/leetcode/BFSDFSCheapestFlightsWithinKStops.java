package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class BFSDFSCheapestFlightsWithinKStops {
    //dfs
    public int minPrice = Integer.MAX_VALUE;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] flight : flights) {
            map.putIfAbsent(flight[0], new ArrayList<int[]>());
            map.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }
        dfs(map, src, dst, 0, 0, K);
        return minPrice == Integer.MAX_VALUE ? -1 : minPrice;
    }
    public void dfs(Map<Integer, List<int[]>> map, int from, int dest, int cost, int flew, int limit) {
        if (flew > limit || cost >= minPrice) {
            return;
        }
        if (map.containsKey(from)) {
            for (int[] flight : map.get(from)) {
                if (flight[0] == dest) {
                    minPrice = Math.min(minPrice, cost + flight[1]);
                    continue;
                }
                dfs(map, flight[0], dest, cost + flight[1], flew + 1, limit);
            }
        }
    }
    //bfs faster
    public int FindCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] flight : flights) {
            map.putIfAbsent(flight[0], new ArrayList<int[]>());
            map.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        if (map.containsKey(src)) {
            for (int[] flight : map.get(src)) {
                pq.offer(flight);
            }
        }
        int min = Integer.MAX_VALUE;
        while (!pq.isEmpty() && K >= 0) {
            int len = pq.size();
            List<int[]> level = new ArrayList<>();
            for (int i = 0; i < len; i ++) {
                int[] flight = pq.poll();
                if (flight[1] >= min) {
                    continue;
                }
                if (flight[0] == dst) {
                    min = Math.min(min, flight[1]);
                    continue;
                }
                if (map.containsKey(flight[0])) {
                    for (int[] next : map.get(flight[0])) {
                        if (flight[1] + next[1] >= min) {
                            continue;
                        }
                        level.add(new int[]{next[0], flight[1] + next[1]});
                    }
                }
            }
            for (int[] stop : level) {
                pq.offer(stop);
            }
            K --;
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}