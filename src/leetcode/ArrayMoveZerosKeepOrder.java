package leetcode;

public class ArrayMoveZerosKeepOrder {
    public int[] Move(int[] input) {
        int left = 0;
        int right = input.length-1;
        int num = 0;
        while (left < right) {
            left = input[left] != 0 ? left + 1 : left;
            right = input[right] == 0 ? right - 1 : right;
            if(input[left] == 0 && input[right] != 0) {
                Swap(input, left, right);
                right --;
                left ++;
                num ++;
            }
        }
        left = left - num -1;
        while (left < right) {
            Swap(input, left, right);
            left ++;
            right --;
        }
        return input;
    }
    private int[] Swap(int[] input, int left, int right) {
        int temp = input[right];
        input[right] = input[left];
        input[left] = temp;
        return input;
    }
}