package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Comparator;

public class StackAndPQTopKFrequentElement {
    public class pair{
        int num;
        int fre;
        pair(int number, int frequency){
            num = number;
            fre = frequency;
        }
    }
    class PairComparator implements Comparator<pair>{
        @Override
        public int compare(pair a, pair b){
            if (a.fre == b.fre) {
                return 0;
            }
            return a.fre > b.fre ? 1 : -1;
            //not using "a.fre - b.fre" to avoid overflow like a.fre is WAY greater than b.fre
        }
    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i:nums){
            if (map.containsKey(i)){
                map.put(i, map.get(i)+1);
            }
            else {
                map.put(i, 1);
            }
        }
        PairComparator cmp = new PairComparator();
        PriorityQueue<pair> pq = new PriorityQueue<>(cmp);
        for (int key:map.keySet()){
            pair p = new pair(key,map.get(key));
            pq.add(p);
            if (pq.size()>k){
                pq.poll();
            }
        }
        while (!pq.isEmpty()){
            res.add(0,pq.poll().num);
        }
        return res;
    }
}