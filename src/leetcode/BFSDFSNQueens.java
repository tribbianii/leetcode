package leetcode;

import java.util.HashSet;
import java.util.Set;

public class BFSDFSNQueens {
    public int Num = 0;
    public int totalNQueens(int n) {
        Set<Integer> blackset_1 = new HashSet<>();
        Set<Integer> blackset_2 = new HashSet<>();
        Set<Integer> blackset_3 = new HashSet<>();
        helper(0, n, blackset_1, blackset_2, blackset_3);
        return Num;
    }
    private void helper(int rowNum, int n, Set<Integer> blackset_1, Set<Integer> blackset_2, Set<Integer> blackset_3) {
        if (rowNum == n){
            Num ++;
            return;
        }
        for (int j = 0; j < n; j ++) {
            if (!blackset_1.contains(j) && !blackset_2.contains(j - rowNum) && !blackset_3.contains(j + rowNum)){
                blackset_1.add(j);
                blackset_2.add(j - rowNum);
                blackset_3.add(j + rowNum);
                helper(rowNum + 1, n, blackset_1, blackset_2, blackset_3);
                blackset_1.remove(j);
                blackset_2.remove(j - rowNum);
                blackset_3.remove(j + rowNum);
            }
        }
    }
}