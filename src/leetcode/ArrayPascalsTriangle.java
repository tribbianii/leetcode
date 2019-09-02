package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayPascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        if (numRows<1){
            return res;
        }
        res.add(Arrays.asList(1));
        for (int i=2;i<=numRows;i++){
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j=1;j<i-1;j++){
                List<Integer> prevRow = res.get(res.size()-1);
                row.add(prevRow.get(j-1) + prevRow.get(j));
            }
            row.add(1);
            res.add(row);
        }
        return res;
    }
}