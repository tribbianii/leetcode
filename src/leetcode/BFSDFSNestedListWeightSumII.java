package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class BFSDFSNestedListWeightSumII {
    // lc #364
    public static class NestedInteger {
        public Integer integer;
        public List<NestedInteger> list;
        public Integer getInteger() {
            return  integer;
        }
        public boolean isInteger() {
            return integer == null;
        }
        public List<NestedInteger> getList() {
            return list;
        }
    }
    public int depthSumInverse(List<NestedInteger> nestedList) {
        Deque<List<NestedInteger>> deque = new ArrayDeque<>();
        int levelsSum = 0;
        int totalSum = 0;
        deque.offerLast(nestedList);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size;  i ++) {
                List<NestedInteger> list = deque.pollFirst();
                for (NestedInteger ni : list) {
                    if (ni.isInteger()) {
                        levelsSum += ni.getInteger();
                    } else {
                        deque.offerLast(ni.getList());
                    }
                }
            }
            totalSum += levelsSum;
        }
        return totalSum;
    }
}
