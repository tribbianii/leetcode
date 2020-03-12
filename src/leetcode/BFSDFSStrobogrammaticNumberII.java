package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class BFSDFSStrobogrammaticNumberII {
    public List<String> findStrobogrammatic(int n) {
        if (n == 1) {
            return new ArrayList<String>(Arrays.asList("0","1","8"));
        }
        List<String> res = new ArrayList<>();
        char[] num = new char[n];
        char[] set = new char[]{'0','1','8','6','9','6','9','8','1','0'};
        dfs(res, num, 0, set, n);
        return res;
    }
    public void dfs(List<String> res, char[] num, int index, char[] set, int len) {
        if (index >= len - index) {
            res.add(new String(num));
            return;
        }
        for (int j = 0; j < set.length / 2; j ++) {
            if (index + j == 0) {
                continue;
            }
            if (2 * index == len - 1 && j > 2) {
                return;
            }
            num[index] = set[j];
            num[len - 1 - index] = len - 1 == 2 * index ? set[j] : set[set.length - 1 - j];
            dfs(res, num, index + 1, set, len);
        }
    }
}