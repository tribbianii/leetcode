package leetcode;

import java.util.*;

public class StringPartitionLabels {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        char[] arr = S.toCharArray();
        int[][] range = new int[26][2];
        for (int[] ran : range) {
            Arrays.fill(ran, -1);
        }
        for (int i = 0; i < arr.length; i ++) {
            if (range[arr[i] - 'a'][0] == -1) {
                range[arr[i] - 'a'][0] = i;
            }
            range[arr[i] - 'a'][1] = i;
        }
        merge(range, res);
        return res;
    }
    public void merge(int[][] range, List<Integer> res) {
        Arrays.sort(range, (cur, nex) -> {
            if (cur[0] == nex[0]) {
                return cur[1] - nex[1];
            }
            return cur[0] - nex[0];
        });
        for (int i = 0; i < range.length; i ++) {
            if (range[i][0] != -1) {
                int cur_head = range[i][0];
                int cur_tail = range[i][1];
                for (int j = i + 1; j < range.length; j ++) {
                    int nex_head = range[j][0];
                    int nex_tail = range[j][1];
                    if (cur_tail < nex_head) {
                        res.add(cur_tail - cur_head + 1);
                        if (nex_head - cur_tail > 1) {
                            res.add(nex_head - cur_tail - 1);
                        }
                        cur_head = nex_head;
                    }
                    cur_tail = Math.max(cur_tail, nex_tail);
                }
                res.add(cur_tail - cur_head + 1);
                break;
            }
        }
    }
}
