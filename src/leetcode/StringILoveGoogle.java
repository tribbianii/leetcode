package leetcode;

public class StringILoveGoogle{
    public String reverseWords(String input){
        char[] res = input.toCharArray();
        for (int i=0;i<res.length;i++){
            if (res[i]!=' '){
                int j = i+1;
                while (j<res.length && res[j]!=' '){
                    j++;
                }
                reverse(res, i, j-1);
                i = j; 
            }
        }
        reverse(res, 0, res.length-1);
        return new String(res);
    }
    private void reverse(char[] input, int start, int end){
        if (input==null || input.length==0){
            return;
        }
        int left = start;
        int right = end;
        while (left < right){
            char ch = input[left];
            input[left] = input[right];
            input[right] = ch;
            left++;
            right--;
        }
    }
}