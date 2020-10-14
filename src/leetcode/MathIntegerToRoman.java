package leetcode;

import java.util.HashMap;
import java.util.Map;

public class MathIntegerToRoman {
    public String intToRoman(int num) {
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "");
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");
        map.put(4, "IV");
        map.put(9, "IX");
        map.put(40, "XL");
        map.put(90, "XC");
        map.put(400, "CD");
        map.put(900, "CM");
        StringBuilder sb = new StringBuilder();
        int digit = 0;
        while (num > 0) {
            StringBuilder sf = new StringBuilder();
            int remainder = (num % 10) * (int) Math.pow(10, digit);
            if ((remainder >= 9 && remainder < 20) || (remainder >= 90 && remainder < 200) || (remainder >= 900 && remainder < 2000)
                    ||(remainder >= 4 && remainder < 6) || (remainder >= 40 && remainder < 60) || (remainder >= 400 && remainder < 600)) {
                sf.append(map.get(remainder));
            } else {
                int step = (int) Math.pow(10, digit);
                int base = (remainder / step) < 4 ? 0 :5 * step;
                int step_count = (remainder / step) - (base / step);
                sf.append(map.get(base));
                while (step_count -- > 0) {
                    sf.append(map.get(step));
                }
            }
            num /= 10;
            digit ++;
            sf.append(sb);
            sb = sf;
        }
        return new String(sb);
    }
}
