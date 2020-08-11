package leetcode;

import java.util.HashMap;
import java.util.Map;

public class DesignStreamFirstNonRepeating {
    static class Number {
        int value;
        Number next;
        Number prev;
        Number(int val) {
            this.value = val;
            this.next = null;
            this.prev = null;
        }
    }

    private int[] dataStream;
    private int[] FNR;
    private Map<Integer, Number> map;
    private Number head;
    private Number tail;

    DesignStreamFirstNonRepeating(int[] stream) {
        this.dataStream = stream;
        this.FNR = new int[dataStream.length];
        this.map = new HashMap<>();
        this.head = new Number(0);
        this.tail = new Number(0);
        head.next = tail;
        tail.prev = head;
    }

    public int[] generateFNR() {
        int index = 0;
        for (int value : dataStream) {
            if (map.containsKey(value)) {
                remove(map.get(value));
            } else {
                add(new Number(value));
            }
            FNR[index ++] = head.next == tail ? Integer.MAX_VALUE : head.next.value;
        }
        return FNR;
    }

    public void add(Number num) {
        Number last = tail.prev;
        last.next = num;
        num.prev = last;
        num.next = tail;
        tail.prev = num;
        map.put(num.value, num);
    }

    public void remove(Number num) {
        if (num != null) {
            num.prev.next = num.next;
            num.next.prev = num.prev;
            map.put(num.value, null);
        }
    }
}