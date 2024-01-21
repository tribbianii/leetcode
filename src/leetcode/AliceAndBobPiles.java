package leetcode;

public class AliceAndBobPiles {
    //Alice picks first
    //winner = 0: draw
    //winner = 1: Alice wins
    //winner = -1: Bob wins
    public int findWinner(int[] piles) {
        int winner = 0;
        int left = 0;
        int right = 1;
        while (right < piles.length) {
            if (left >= 0 && piles[right] == piles[left]) {
                left --;
                right ++;
                winner = winner == 0 ? 1 : -winner;
            } else {
                left ++;
                piles[left] = piles[right];
                right ++;
            }
        }
        return winner;
    }
}
