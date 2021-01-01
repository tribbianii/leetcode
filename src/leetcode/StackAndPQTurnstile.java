package leetcode;

import java.util.*;

public class StackAndPQTurnstile {
    static class Visitor{
        int id;
        int dir;
        int time;
        Visitor(int id, int dir, int time) {
            this.id = id;
            this.dir = dir;
            this.time = time;
        }
    }
    public int[] getTimes(int[] times, int[] directions) {
        int[] res = new int[times.length];
        int lastDir = 1;
        int timeStamp = 0;
        PriorityQueue<Visitor> enterQueue = new PriorityQueue<>((o1, o2) -> o1.time == o2.time ? o1.id - o2.id : o1.time - o2.time);
        PriorityQueue<Visitor> exitQueue = new PriorityQueue<>((o1, o2) -> o1.time == o2.time ? o1.id - o2.id : o1.time - o2.time);
        for (int i = 0; i < times.length; i ++) {
            if (directions[i] == 1) {
                exitQueue.offer(new Visitor(i, 1, times[i]));
            } else {
                enterQueue.offer(new Visitor(i, 0, times[i]));
            }
        }
        while (!(enterQueue.isEmpty() && exitQueue.isEmpty())) {
            int nextEnterTime = enterQueue.isEmpty() ? Integer.MAX_VALUE : enterQueue.peek().time;
            int nextExitTime = exitQueue.isEmpty() ? Integer.MAX_VALUE : exitQueue.peek().time;
            if (nextEnterTime > timeStamp && nextExitTime > timeStamp) {
                lastDir = 1;
            } else if (nextEnterTime <= timeStamp && nextExitTime <= timeStamp) {
                Visitor v = lastDir == 1 ? exitQueue.poll() : enterQueue.poll();
                res[v.id] = timeStamp;
            } else {
                Visitor v = nextEnterTime <= timeStamp ? enterQueue.poll() : exitQueue.poll();
                res[v.id] = timeStamp;
                lastDir = v.dir;
            }
            timeStamp ++;
        }
        return res;
    }
}
