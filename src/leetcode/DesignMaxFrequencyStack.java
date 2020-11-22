package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class DesignMaxFrequencyStack {
    Map<Integer, Integer> freq;
    Map<Integer, Deque<Integer>> group;
    int maxfreq;

    public DesignMaxFrequencyStack() {
        freq = new HashMap();
        group = new HashMap();
        maxfreq = 0;
    }

    public void push(int x) {
        int f = freq.getOrDefault(x, 0) + 1;
        freq.put(x, f);
        if (f > maxfreq)
            maxfreq = f;

        group.computeIfAbsent(f, z-> new ArrayDeque()).offerLast(x);
    }

    public int pop() {
        int x = group.get(maxfreq).pollLast();
        freq.put(x, freq.get(x) - 1);
        if (group.get(maxfreq).size() == 0)
            maxfreq--;
        return x;
    }
}
