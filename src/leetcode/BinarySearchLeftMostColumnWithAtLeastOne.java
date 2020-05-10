package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchLeftMostColumnWithAtLeastOne {
    class BinaryMatrix {
        public int get(int x, int y) {
            // or return 0
            return 1;
        }
        public List<Integer> dimensions() {
            // return [m, n] means matrix is m*n
            return new ArrayList<Integer>();
        }
    }
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        int rowMax = binaryMatrix.dimensions().get(0);
        int colMax = binaryMatrix.dimensions().get(1);
        int leftMost = -1;
        for (int i = 0; i < rowMax; i ++) {
            int index = search(binaryMatrix, i, colMax);
            if (index != -1) {
                leftMost = leftMost == -1 ? index : Math.min(leftMost, index);
            }
        }
        return leftMost;
    }
    public int search(BinaryMatrix binaryMatrix, int rowNum, int colMax) {
        int left = 0;
        int right = colMax - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (binaryMatrix.get(rowNum, mid) == 1) {
                right =  mid;
            } else {
                left = mid + 1;
            }
        }
        if (binaryMatrix.get(rowNum, left) == 1) {
            return left;
        }
        if (binaryMatrix.get(rowNum, right) == 1) {
            return right;
        }
        return -1;
    }
}