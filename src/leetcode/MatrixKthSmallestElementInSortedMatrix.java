package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MatrixKthSmallestElementInSortedMatrix{
    public class cell{
        int x;
        int y;
        int val;
        public cell(int i, int j, int value){
            x = i;
            y = j;
            val = value;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null||matrix.length == 0){
            return 0;
        }
        int x_boundary = matrix.length;
        int y_boundary = matrix[0].length;
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        //instantiate a priorityqueue of cell(in this case, minHeap)
        //cell with smallest value gets poll first
        PriorityQueue<cell> pq = new PriorityQueue<cell>(new Comparator<cell>(){
            @Override
            public int compare(cell a, cell b){
                if (a.val == b.val) {
                    return 0;
                }
                return a.val > b.val ? 1 : -1;
            } 
        });
        pq.add(new cell(0, 0, matrix[0][0]));
        visited[0][0] = true;
        cell node = null;
        int elements_polled = 0;
        while (elements_polled < k) {
            node = pq.poll();
            elements_polled ++;
            int x = node.x;
            int y = node.y;
            if (x + 1 < x_boundary && y < y_boundary && !visited[x + 1][y]) {
                pq.add(new cell(x + 1, y, matrix[x + 1][y]));
                visited[x + 1][y] = true;
            }
            if (x < x_boundary && y + 1 < y_boundary && !visited[x][y + 1]) {
                pq.add(new cell(x, y + 1, matrix[x][y + 1]));
                visited[x][y + 1] = true;
            }
        }
        return node.val;
    }
}