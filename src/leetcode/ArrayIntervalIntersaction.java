package leetcode;

import java.util.ArrayList;
import java.util.List;

public class ArrayIntervalIntersaction {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> list = new ArrayList<>();
        int index_1 = 0;
        int index_2 = 0;
        while (index_1 < firstList.length && index_2 < secondList.length) {
            if (merge(firstList[index_1], secondList[index_2], list)) {
                index_2 ++;
            } else {
                index_1 ++;
            }
        }
        return list.toArray(new int[list.size()][]);
    }
    public boolean merge(int[] first, int[] second, List<int[]> list) {
        int left = Math.max(first[0], second[0]);
        int right = Math.min(first[1], second[1]);
        if (left <= right) {
            list.add(new int[]{left, right});
        }
        return first[1] >= second[1];
    }
}