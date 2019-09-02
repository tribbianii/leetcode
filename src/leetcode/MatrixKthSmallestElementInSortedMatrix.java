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
        if (matrix==null||matrix.length==0){
            return 0;
        }
        int n = matrix.length;
        PriorityQueue<cell> pq = new PriorityQueue<cell>(new Comparator<cell>(){
            @Override
            public int compare(cell a, cell b){
                if (a.val == b.val) {
                    return 0;
                }
                return a.val > b.val ? 1 : -1;
            } 
        });
        for (int i=0;i<n;i++){
            pq.add(new cell(i,0,matrix[i][0]));
        }
        for (int m=0;m<k-1;m++){
            cell curr  = pq.poll();
            int i = curr.x;
            int j = curr.y;
            if (j==n-1){
                continue;
            }
            pq.add(new cell(i, j+1, matrix[i][j+1]));
        }
        return pq.poll().val;
    }
    //following solution slower but easier to understand
    public int KthSmallest(int[][] matrix, int k){
        if (matrix==null||matrix.length==0){
            return 0;
        }
        int n = matrix.length;
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<cell> pq = new PriorityQueue<cell>(new Comparator<cell>(){
            @Override
            public int compare(cell a, cell b){
                if (a.val == b.val) {
                    return 0;
                }
                return a.val > b.val ? 1 : -1;
            } 
        });
        pq.offer(new cell(0,0,matrix[0][0]));
        int count = 1;
        while (count < k){
            cell curr = pq.poll();
            count++;
            int i = curr.x;
            int j = curr.y;
            if (i < n-1 && !visited[i+1][j]){
                visited[i+1][j] = true;
                pq.offer(new cell(i+1,j,matrix[i+1][j]));
            }
            if (j < n-1 && !visited[i][j+1]){
                visited[i][j+1] = true;
                pq.offer(new cell(i,j+1,matrix[i][j+1]));
            }
        }
        return pq.poll().val;
    }
}