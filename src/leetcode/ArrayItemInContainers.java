package leetcode;

import java.util.Arrays;

public class ArrayItemInContainers {
    public int[] getItems(String s, int[] startIndex, int[] endIndex) {
        char[] strArr = s.toCharArray();
        int[] numInLeft = new int[s.length()];
        int[] idxNearestLeftBoard = new int[s.length()];
        int[] idxNearestRightBoard = new int[s.length()];
        Arrays.fill(idxNearestLeftBoard, -1);
        Arrays.fill(idxNearestRightBoard, strArr.length);
        int lastRightBoard = 0;
        for (int i = 0; i < strArr.length; i ++) {
            if (strArr[i] == '*') {
                numInLeft[i] = i == 0 ? 1 : numInLeft[i - 1] + 1;
                idxNearestLeftBoard[i] = idxNearestLeftBoard[i - 1];
            } else {
                idxNearestLeftBoard[i] = i;
                while (lastRightBoard <= i) {
                    idxNearestRightBoard[lastRightBoard ++] = i;
                }
            }
        }
        int[] res = new int[startIndex.length];
        for (int j = 0; j < res.length; j ++) {
            int startBoard = idxNearestRightBoard[startIndex[j]];
            int endBoard = idxNearestLeftBoard[endIndex[j]];
            if (startBoard == strArr.length || endBoard == -1) {
                res[j] = 0;
            } else {
                res[j] = numInLeft[endBoard] - numInLeft[startBoard];
            }
        }
        return res;
    }
}
