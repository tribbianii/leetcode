package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class BFSDFSReconstructionByHeight {
    //conventional dfs exceeded time limit
    public static int[][] reconstructQueue(int[][] people) {
        if (people.length <= 1) {
            return people;
        }
        int[][] res = new int[people.length][people[0].length];
        boolean[] visited = new boolean[people.length];
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] one, int[] two) {
                return one[1] - two[1];
            }
        });
        dfs(people, new int[people.length][people[0].length], visited, 0, res);
        return res;
    }
    public static void dfs(int[][] people, int[][] curr, boolean[] visited, int index, int[][] res) {
        if (index == people.length) {
            for (int j = 0; j < people.length; j++) {
                res[j] = curr[j];
            }
            return;
        }
        for (int i = 0; i < people.length; i++) {
            if (index < people[i][1]) {
                return;
            }
            if (!visited[i] && isValid(curr, people[i], index)) {
                curr[index] = people[i];
                visited[i] = true;
                dfs(people, curr, visited, index + 1, res);
                visited[i] = false;
            } 
        }
    }
    public static boolean isValid(int[][] curr, int[] next, int index) {
        int count = 0;
        for (int i = 0; i < index; i++) {
            count = curr[i][0] >= next[0] ? count + 1 : count;
            if (count > next[1]) {
                return false;
            }
        }
        return count == next[1];
    }

    //tricky
    public int[][] ReconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
          @Override
          public int compare(int[] o1, int[] o2) {
            return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
          }
        });
        List<int[]> output = new LinkedList<int[]>();
        for(int[] p : people){
          output.add(p[1], p);
        }
        int n = people.length;
        return output.toArray(new int[n][2]);
      }
}