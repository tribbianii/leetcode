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
    public void Reverse(char[] str, int i, int j) {
        if (i >= j) {
            return;
        }
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
        Reverse(str, i + 1, j + 1);
    }
}