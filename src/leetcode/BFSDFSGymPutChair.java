package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

// Put a chair in gym to have shortest total distance to all the equipments
// Obstacles cannot be crossed
class BFSDFSGymPutChair {
    public static void main(String[] args) {
        int[] res = chairPos();
        if (res[2] == Integer.MAX_VALUE) {
            System.out.println("Unreachable equipment exists");
        } else {
            System.out.println("Put chair at [" + res[0] + ", " + res[1] + "], total distance: " + res[2]);
        }
    }

    public static int[][] gym = new int[][]{{1, 2, 1, 0, 1},
    /* 1: vacancy */                        {1, 0, 1, 1, 2},
    /* 2: equipment */                      {1, 1, 0, 1, 1},
    /* 0: obstacle */                       {1, 1, 1, 1, 0},
                                            {1, 2, 1, 1, 1}};

    public static int[][] distances = new int[gym.length][gym[0].length];

    public static int[] chairPos() {
        List<int[]> equips = find("equipment");
        for (int[] equip : equips) {
            dijkstra(equip);
        }
        int[] res = new int[]{0, 0, Integer.MAX_VALUE};
        for (int i = 0; i < distances.length; i ++) {
            for (int j = 0; j < distances[0].length; j ++) {
                if (gym[i][j] == 1 && distances[i][j] < res[2]) {
                    res[0] = i;                 // chair row
                    res[1] = j;                 // chair col
                    res[2] = distances[i][j];   // total distance
                }
            }
        }
        return res;
    }
    public static List<int[]> find(String item) {
        int code = 0;
        switch(item) {
            case "vacancy": code = 1; break;
            case "equipment": code = 2; break;
            case "obstacle": code = 0; break;
        }
        ArrayList<int[]> pos = new ArrayList<>();
        for (int i = 0; i < gym.length; i ++) {
            for (int j = 0; j < gym[0].length; j ++) {
                if (gym[i][j] == code) {
                    System.out.println("equip: [" + i + ", " + j + "]");
                    pos.add(new int[]{i, j});
                }
            }
        }
        return pos;
    }
    public static class Station {
        int row;
        int col;
        int distance;
        Station(int x, int y, int dis) {
            this.row = x;
            this.col = y;
            this.distance = dis;
        }
    }
    public static void dijkstra(int[] from) {
        boolean[][] visited = new boolean[gym.length][gym[0].length];
        int unvisited = gym.length * gym[0].length;
        PriorityQueue<Station> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        pq.offer(new Station(from[0], from[1], 0));
        while (unvisited > 0) {
            Station curr = pq.poll();
            int x = curr.row;
            int y = curr.col;
            int distance = curr.distance;
            if (!visited[x][y]) {
                visited[x][y] = true;
                unvisited --;
                // if obstacle || unreachable vacancy || unreachable equipment
                if (gym[x][y] == 0 || distances[x][y] == Integer.MAX_VALUE || distance == Integer.MAX_VALUE) {
                    distances[x][y] = Integer.MAX_VALUE;
                    distance = Integer.MAX_VALUE;
                } else {
                    distances[x][y] += distance;
                }
                int new_distance = distance == Integer.MAX_VALUE ? Integer.MAX_VALUE : distance + 1;
                if (x + 1 < gym.length && !visited[x + 1][y]) {
                    pq.offer(new Station(curr.row + 1, curr.col, new_distance));
                }
                if (x - 1 >= 0 && !visited[x - 1][y]) {
                    pq.offer(new Station(curr.row - 1, curr.col, new_distance));
                }
                if (y + 1 < gym[0].length && !visited[x][y + 1]) {
                    pq.offer(new Station(curr.row, curr.col + 1, new_distance));
                }
                if (y - 1 >= 0 && !visited[x][y - 1]) {
                    pq.offer(new Station(curr.row, curr.col - 1, new_distance));
                }
            }
        }
        System.out.println("distances:");
        for (int[] row : distances) {
            System.out.println(Arrays.toString(row));
        }
    }
}