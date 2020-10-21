package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Comparator;

public class StackAndPQTopKFrequentElement {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums){
            if (!map.containsKey(num)){
                map.put(num, 0);
            }
            map.put(num, map.get(num) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return Integer.compare(o1.getValue(), o2.getValue());
            }
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (pq.size() == k) {
                if (entry.getValue() > pq.peek().getValue()) {
                    pq.poll();
                    pq.offer(entry);
                }
                continue;
            }
            pq.offer(entry);
        }
        int index = 0;
        while (!pq.isEmpty()){
            res[index ++] = pq.poll().getKey();
        }
        return res;
    }
}