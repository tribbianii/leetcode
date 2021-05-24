package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArrayLongestConsecutiveHours {
    public static int findLongest(Integer[] schedule) {
        Set<Integer> set = new HashSet<>(Arrays.asList(schedule));
        int maxLen = 1;
        for (Integer time : schedule) {
            if (set.contains(time)) {
                int len = 0;
                while (set.contains(time)) {
                    len ++;
                    set.remove(time);
                    time --;
                }
                time += (len + 1);
                while (set.contains(time)) {
                    len ++;
                    set.remove(time);
                    time ++;
                }
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {
        Integer[] schedule = {3, 1, 8, 5, 2, 12, 10, 4, 8, 9};
        System.out.println(findLongest(schedule));
    }
}
