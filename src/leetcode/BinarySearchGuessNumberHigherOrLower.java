package leetcode;

public class BinarySearchGuessNumberHigherOrLower{
    public int guessNumber(int n) {
        int start = 1;
        int end = n;
        while (start!=end){
            int mid = start+(end-start)/2;
            if (guess(mid)==0){
                return mid;
            }
            else if (guess(mid)<0){
                end = mid;
            }
            else {
                start = mid+1;
            }
        }
        return start;   
    }
    public int ans;
    private int guess(int num){
        if (num==ans){
            return 0;
        }
        return num>ans?-1:1;
    }
}