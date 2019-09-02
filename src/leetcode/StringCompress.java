package leetcode;

public class StringCompress{
    public String compress(String input) {
        String str = "";
        int slow = 0;
        int fast = 1;
        while (fast < input.length()){
            while (fast < input.length() && input.charAt(fast) == input.charAt(slow)){
                fast++;
            }
            str += input.charAt(slow);
            str = (fast-slow) > 1 ? str + String.valueOf(fast-slow) : str;
            slow = fast;
            fast++;
        }
        if (slow == input.length() - 1){
            str += input.charAt(slow);
        }
        return str;
    }
}