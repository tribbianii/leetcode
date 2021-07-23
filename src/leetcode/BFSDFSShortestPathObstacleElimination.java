package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BFSDFSShortestPathObstacleElimination {
    int rows;
    int cols;
    int[][] directions = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    class Node {
        int row;
        int col;
        int distance;
        int steps;
        int tools;
        Node (int row_num, int col_num, int step, int tool) {
            this.row = row_num;
            this.col = col_num;
            this.distance = rows - row_num - 1 + cols - col_num - 1;
            this.steps = step;
            this.tools = tool;
        }
    }

    public int shortestPath(int[][] grid, int k) {
        this.rows = grid.length;
        this.cols = grid[0].length;
        int[][] record = new int[rows][cols];
        for (int[] record_row : record) {
            Arrays.fill(record_row, -1);
        }
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>(){
            @Override
            public int compare(Node o1, Node o2) {
                return o1.steps == o2.steps ? o1.distance - o2.distance : o1.steps - o2.steps;
            }
        });
        pq.add(new Node(0, 0, 0, k));
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (node.distance == 0) {
                return node.steps;
            }
            for (int[] dir : directions) {
                int row = node.row + dir[0];
                int col = node.col + dir[1];
                if (row >= 0 && row < rows && col >= 0 && col < cols) {
                    if (grid[row][col] == 1) {
                        if (node.tools - 1 > record[row][col]) {
                            pq.add(new Node(row, col, node.steps + 1, node.tools - 1));
                            record[row][col] = node.tools - 1;
                        }
                    } else {
                        if (node.tools > record[row][col]) {
                            pq.add(new Node(row, col, node.steps + 1, node.tools));
                            record[row][col] = node.tools;
                        }
                    }
                }
            }
        }
        return -1;
    }
}
