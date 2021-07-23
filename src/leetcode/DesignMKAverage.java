package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.TreeMap;

public class DesignMKAverage {
    Deque<Integer> stream;
    int stream_threshold;
    TreeMap<Integer, Integer> max_k;
    int max_size;
    int max_cap;
    TreeMap<Integer, Integer> min_k;
    int min_size;
    int min_cap;
    TreeMap<Integer, Integer> middle;
    long middle_sum;
    public DesignMKAverage(int m, int k) {
        this.stream_threshold = m;
        this.max_size = 0;
        this.max_cap = k;
        this.min_size = 0;
        this.min_cap = k;
        this.middle_sum = 0;
        this.stream = new ArrayDeque<>();
        this.max_k = new TreeMap<>();
        this.min_k = new TreeMap<>();
        this.middle = new TreeMap<>();
    }

    public void addElement(int num) {
        this.stream.offerLast(num);
        this.middle.put(num, this.middle.getOrDefault(num, 0) + 1);
        this.middle_sum += num;
        if (this.stream.size() >= this.stream_threshold) {
            if (this.stream.size() > this.stream_threshold) {
                int element = this.stream.pollFirst();
                removeElement(element);
            }
            exchangeMiddleAndMax();
            exchangeMiddleAndMin();
        }
    }

    public void removeElement(int element) {
        if (this.max_k.containsKey(element)) {
            removeEleFromMap(this.max_k, element);
            this.max_size --;
        } else if (this.middle.containsKey(element)) {
            removeEleFromMap(this.middle, element);
            this.middle_sum -= element;
        } else {
            removeEleFromMap(this.min_k, element);
            this.min_size --;
        }
    }

    public void removeEleFromMap(Map<Integer, Integer> map, int element) {
        map.put(element, map.get(element) - 1);
        if (map.get(element) == 0) {
            map.remove(element);
        }
    }

    public void exchangeMiddleAndMax() {
        int element = 0;
        while (this.max_size < this.max_cap) {
            element = this.middle.lastKey();
            removeEleFromMap(this.middle, element);
            this.middle_sum -= element;
            this.max_k.put(element, this.max_k.getOrDefault(element, 0) + 1);
            this.max_size ++;
        }
        if (this.max_k.firstKey() < this.middle.lastKey()) {
            this.middle_sum += (this.max_k.firstKey() - this.middle.lastKey());
            element = this.middle.lastKey();
            removeEleFromMap(this.middle, element);
            this.max_k.put(element, this.max_k.getOrDefault(element, 0) + 1);
            element = this.max_k.firstKey();
            removeEleFromMap(this.max_k, element);
            this.middle.put(element, this.middle.getOrDefault(element, 0) + 1);
        }
    }

    public void exchangeMiddleAndMin() {
        int element = 0;
        while (this.min_size < this.min_cap) {
            element = this.middle.firstKey();
            removeEleFromMap(this.middle, element);
            this.middle_sum -= element;
            this.min_k.put(element, this.min_k.getOrDefault(element, 0) + 1);
            this.min_size ++;
        }
        if (this.min_k.lastKey() > this.middle.firstKey()) {
            this.middle_sum += (this.min_k.lastKey() - this.middle.firstKey());
            element = this.middle.firstKey();
            removeEleFromMap(this.middle, element);
            this.min_k.put(element, this.min_k.getOrDefault(element, 0) + 1);
            element = this.min_k.lastKey();
            removeEleFromMap(this.min_k, element);
            this.middle.put(element, this.middle.getOrDefault(element, 0) + 1);
        }
    }

    public int calculateMKAverage() {
        return this.stream.size() < this.stream_threshold ? -1 : (int)(this.middle_sum / (this.stream_threshold - this.max_cap - this.min_cap));
    }
}
