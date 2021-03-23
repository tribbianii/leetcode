package leetcode;

import java.util.*;

public class BFSDFSJumpGameIV {
    public int minJumps(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int i = arr.length - 1; i >= 0; i --) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], new LinkedList<>());
            }
            map.get(arr[i]).add(i);
        }
        int step = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offerLast(0);
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size > 0) {
                int curr = deque.pollFirst();
                if (curr == arr.length - 1) {
                    return step;
                }
                if (map.containsKey(arr[curr + 1])) {
                    deque.offerLast(curr + 1);
                }
                if (curr > 0 && map.containsKey(arr[curr - 1])) {
                    deque.offerLast(curr - 1);
                }
                if (map.containsKey(arr[curr])) {
                    for (int next : map.remove(arr[curr])) {
                        if (next != curr) {
                            deque.offerLast(next);
                        }
                    }
                }
                size --;
            }
            step ++;
        }
        return step;
    }
}
