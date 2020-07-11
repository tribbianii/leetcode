package leetcode;

public class MathPower {
    public double myPow(double x, int n) {
        if (n < 0) {
            // 'cause n can be -(2^31) to 2^31 - 1, so -n can reach 2^31 which exceeds the limit of int
            // we use long type to cover but cannot do "long N = -n" according to [TWO's Complement]
            // -2^31 = 10000...0(31s 0), to directly negate this number we have 10000...0(31s 0) again which is -2^31
            // so first we have to convert n to long type then to negate it
            long N = n;
            return (double)(1 / pow(x, -N));
        }
        return pow(x, n);
    }
    public double pow(double x, long n) {
        if (n == 0) {
            return 1;
        }
        double half = pow(x, n/2);
        if (n % 2 == 1) {
            return half * half * x;
        }
        return  half * half;
    }
}
