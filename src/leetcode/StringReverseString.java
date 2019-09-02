package leetcode;

public class StringReverseString{
    public String reverse(String input){
        if (input==null || input.length()==0){
            return input;
        }
        char[] arr = input.toCharArray();
        int left = 0;
        int right = arr.length-1;
        while (left < right){
            char ch = arr[left];
            arr[left] = arr[right];
            arr[right] = ch;
            left++;
            right--;
        }
        return new String(arr);
    }
}