package leetcode;

import java.util.HashSet;
import java.util.Set;

public class MathHappyNumber {
    public Set<Integer> set;
    public boolean isHappy(int n) {
        set = new HashSet<>();
        int val = n;
        while (!set.contains(1)) {
            val = calculate(val);
            if (set.contains(val)) {
                break;
            }
            set.add(val);
        }
        return set.contains(1);
    }
    public int calculate(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10) * (n % 10);
            n = n / 10;
        }
        return sum;
    }
}