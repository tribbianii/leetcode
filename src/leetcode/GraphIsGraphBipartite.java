package leetcode;

import java.util.LinkedList;
import java.util.Queue;

class GraphIsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        int[] visited = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            //we are actually doing BFS inside a for loop
            //because the graph might not be closely connected like:
            /*
                input: [[1],[0],[3],[2]]
                    0 ------ 1

                    2 ------ 3

                if we have graph above and only use BFS without iteration, we will stop at node 1
            */
            if (visited[i] == 0 && graph[i].length > 0){
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                visited[i] = 1;
                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    for (int neighbor : graph[node]) {
                        if (visited[neighbor] == 0) {
                            visited[neighbor] = visited[node] == 1 ? 2 : 1;
                            queue.offer(neighbor); 
                        } else if (visited[neighbor] == visited[node]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}