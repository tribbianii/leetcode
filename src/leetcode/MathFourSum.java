package leetcode;

import java.util.HashMap;
import java.util.Map;

public class MathFourSum {
    //Time: O(n^2)
    //only have to find one combination
    public boolean existed(int[] arr, int target) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int j = 1; j < arr.length; j ++) {
            for (int i = 0; i < j; i ++) {
                int pairSum = arr[i] + arr[j];
                if (map.containsKey(target - pairSum) && map.get(target - pairSum)[1] < i) {
                    return true;
                }
                if (!map.containsKey(pairSum)) {
                    map.put(pairSum, new int[]{i, j});
                }
            }
        }
        return false;
    }
}
