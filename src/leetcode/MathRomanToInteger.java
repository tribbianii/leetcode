package leetcode;

import java.util.HashMap;
import java.util.Map;

public class MathRomanToInteger {
    public int romanToInt(String symbols) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int value = map.get(symbols.charAt(symbols.length() - 1));
        for (int i = symbols.length() - 2; i >= 0; i --) {
            if (map.get(symbols.charAt(i)) >= map.get(symbols.charAt(i + 1))){
                value = value + map.get(symbols.charAt(i));
            } else {
                value = value - map.get(symbols.charAt(i));
            }
        }
        return value;
    }
}
