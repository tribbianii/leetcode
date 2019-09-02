package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BFSDFSNQueens {
    //my backtracking method does work!!!
    public List<List<String>> solveNQueens(int n) {
        ArrayList<List<String>> res = new ArrayList<List<String>>();
        ArrayList<String> puzzle = new ArrayList<String>();
        Set<Integer> invalid_0 = new HashSet<>();
        Set<Integer> invalid_45 = new HashSet<>();
        Set<Integer> invalid_135 = new HashSet<>();
        helper(res, puzzle, 0, n,invalid_0,invalid_45,invalid_135);
        return res;
    }
    private void helper(ArrayList<List<String>> res,ArrayList<String> puzzle,int rowNum,int n,Set<Integer> invalid_0,Set<Integer> invalid_45,Set<Integer> invalid_135){
        if (rowNum==n){
            res.add(new ArrayList<String>(puzzle));
            return;
        }
        StringBuilder row = new StringBuilder(n);
        for (int i=0;i<n;i++){
            row.append('.');
        }
        for (int j=0;j<n;j++){
            if (!invalid_0.contains(j) && !invalid_45.contains(j-rowNum) && !invalid_135.contains(j+rowNum) && row.charAt(j)=='.'){
                row.setCharAt(j, 'Q');
                invalid_0.add(j);
                invalid_45.add(j-rowNum);
                invalid_135.add(j+rowNum);
                String Row = row.toString();
                puzzle.add(new String(Row));
                helper(res, puzzle, rowNum+1, n, invalid_0,invalid_45,invalid_135);
                row.setCharAt(j, '.');
                invalid_0.remove(j);
                invalid_45.remove(j-rowNum);
                invalid_135.remove(j+rowNum);
                puzzle.remove(Row);
            }
        }
    }
}