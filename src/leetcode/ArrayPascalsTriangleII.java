package leetcode;

import java.util.ArrayList;
import java.util.List;

public class ArrayPascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        for (int i = 0; i < rowIndex; i++) {
            for (int j = 0; j < res.size() - 1; j++) {
                res.set(j, res.get(j) + res.get(j + 1));
            }
            res.add(0, 1);
        }
        return res;
    }
}