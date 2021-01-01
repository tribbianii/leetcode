package leetcode;

import java.util.Arrays;

public class ArrayPrisonCell {
    public int[] prisonAfterNDays(int[] cells, int N) {
        int[] orig = new int[cells.length];
        boolean[] occupy = new boolean[cells.length];
        int cycle = 0;
        for (int i = 0; i < N; i ++) {
            for (int j = 1; j < cells.length - 1; j ++) {
                occupy[j] = cells[j - 1] == cells[j + 1];
            }
            boolean same = true;
            for (int k = 0; k < cells.length; k ++) {
                if (k == 0 || k == cells.length - 1) {
                    cells[k] = 0;
                } else {
                    cells[k] = occupy[k] ? 1 : 0;
                }
                same = (i > 0 && k > 0 && k < cells.length - 1) ? (same && cells[k] == orig[k]) : same;
            }
            if (i == 0) {
                orig = Arrays.copyOf(cells, cells.length);
            }
            if (i > 0 && same) {
                cycle = i;
                break;
            }
        }
        if (cycle == 0) {
            return cells;
        }
        for (int i = 0; i < (N - 1) % cycle; i ++) {
            for (int j = 1; j < cells.length - 1; j ++) {
                occupy[j] = orig[j - 1] == orig[j + 1];
            }
            for (int k = 0; k < cells.length; k ++) {
                if (k == 0 || k == cells.length - 1) {
                    orig[k] = 0;
                } else {
                    orig[k] = occupy[k] ? 1 : 0;
                }
            }
        }
        return orig;
    }
}
