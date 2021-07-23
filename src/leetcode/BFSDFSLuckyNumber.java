package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BFSDFSLuckyNumber {
    public static int combinationOfLuckyNumber(int target, Integer[] lucky) {
        int digit = findDigit(target);
        Arrays.sort(lucky);
        List<Integer> combinationsByLucky = new ArrayList<Integer>();
        dfs(combinationsByLucky, digit, lucky, 0);
        int index = findEqualOrLess(target, combinationsByLucky);
        int found = combinationsByLucky.get(index);
        if (found <= target) {
            return found;
        }
        int numberWithLessDigits = 0;
        while (digit > 1) {
            numberWithLessDigits = numberWithLessDigits * 10 + lucky[lucky.length - 1];
            digit --;
        }
        return numberWithLessDigits;
    }
    public static int findDigit(int value) {
        int digit = 0;
        while (value != 0) {
            digit ++;
            value /= 10;
        }
        return digit;
    }
    public static int findEqualOrLess(int target, List<Integer> range) {
        int left = 0;
        int right = range.size() - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (range.get(mid) <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return range.get(right) <= target ? right : left;
    }
    public static void dfs(List<Integer> combinations, int digit, Integer[] lucky, int value) {
        if (digit == 0) {
            combinations.add(value);
            return;
        }
        value *= 10;
        for (int i = 0; i < lucky.length; i ++) {
            dfs(combinations, digit - 1, lucky, value + lucky[i]);
        }
    }
    public static void main(String[] args) {
        int target = 753;
        Integer[] lucky = new Integer[]{2,4,8};
        int result = combinationOfLuckyNumber(target, lucky);
        System.out.println("target: " + target);
        System.out.println("lucky: " + Arrays.asList(lucky));
        List<Integer> combin = new ArrayList<Integer>();
        dfs(combin, findDigit(target), lucky, 0);
        System.out.println("combinations: " + combin);
        System.out.println("result: " + result);
    }
}
