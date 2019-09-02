package leetcode;

import java.util.ArrayList;
import java.util.List;

public class MatrixBestMeetingPoint{
    //following is wrong answer, which is mine
    public int minTotalDistance(int[][] grid) {
        if (grid==null||grid.length==0||grid[0].length==0){
            return 0;
        }
        int sum_i=0;
        int sum_j=0;
        int people=0;
        ArrayList<Integer> home = new ArrayList<>();
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (grid[i][j]==1){
                    home.add(i);
                    home.add(j);
                    sum_i=sum_i+i;
                    sum_j=sum_j+j;
                    people++;
                }
            }
        }
        int best_i = sum_i/people;
        int best_j = sum_j/people;
        return calculate(best_i, best_j, home);
    }
    public int calculate(int i, int j, ArrayList<Integer> home){
        int dis = 0;
        for (int k=0;k<home.size()-2;k=k+2){
            int dis_i = home.get(k)-i>0?home.get(k)-i:i-home.get(k);
            int dis_j = home.get(k+1)-j>0?home.get(k+1)-j:j-home.get(k+1);
            dis = dis + dis_i + dis_j;
        }
        return dis;
    }
    //following is solution
    public int MinTotalDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        List<Integer> I = new ArrayList<Integer>();
        List<Integer> J = new ArrayList<Integer>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    I.add(i);
                }
            }
        }
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i ++) {
                if (grid[i][j] == 1) {  
                    J.add(j);
                }
            }
        }
        return Calculate(I) + Calculate(J);
    }
    public int Calculate(List<Integer> home) {
        int i = 0, j = home.size() - 1, sum = 0;
        while (i < j) {
            sum += home.get(j--) - home.get(i++);
        }
        return sum;
    }
}