package leetcode;

public class MathKthGrammar {
    public int kthGrammar(int N, int K) {
        if (K < 3) {
            return K == 1 ? 0 : 1;
        }
        int half = (int)Math.pow(2, N - 2);
        boolean inFirstHalf = K <= half;
        int index = inFirstHalf ? K : K - half;
        return inFirstHalf ? kthGrammar(N - 1, index) : Math.abs(kthGrammar(N - 1, index) - 1);
    }
}
