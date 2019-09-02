package leetcode;

public class ArrayBullsAndCows{
    public String getHint(String secret, String guess) {
        int[] dict = new int[10];
        int bulls = 0;
        int cows = 0;
        for (int i=0;i<secret.length();i++){
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if (s==g){
                bulls++;
            }
            else {
                if (dict[s-'0'] < 0){
                    cows++;
                }
                dict[s-'0']++;
                if (dict[g-'0'] > 0){
                    cows++;
                }
                dict[g-'0']--;
            }
        }
        return bulls+"A"+cows+"B";
    }
}