package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class BFSDFSNestedListWeightSum {
    // lc #339
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
    public int depthSum(List<NestedInteger> nestedList) {
        int res = 0;
        int level = 0;
        Deque<List<NestedInteger>> deque = new ArrayDeque<>();
        deque.offerLast(nestedList);
        while (!deque.isEmpty()) {
            level ++;
            int size = deque.size();
            for (int i = 0; i < size; i ++) {
                List<NestedInteger> list = deque.pollFirst();
                for (NestedInteger ni : list) {
                    if (ni.isInteger()) {
                        res += (level * ni.getInteger());
                    } else {
                        deque.offerLast(ni.getList());
                    }
                }
            }
        }
        return res;
    }
}
