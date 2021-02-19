package leetcode;

import java.util.ArrayList;
import java.util.List;

public class ArrayPascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        if (rowIndex > 0) {
            List<Integer> lastRow = getRow(rowIndex - 1);
            for (int i = 0; i < lastRow.size() - 1; i ++) {
                res.add(lastRow.get(i) + lastRow.get(i + 1));
            }
            res.add(1);
        }
        return res;
    }
}