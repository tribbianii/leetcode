package leetcode;

public class ArrayMoveZerosKeepOrder {

    public int[] Move(int[] input) {
        int slow = 0;
        int fast = 0;
        while (fast < input.length) {
            if (input[fast] != 0) {
                input[slow++] = input[fast++];
            }
            else {
                fast++;
            }
        }
        while (slow <= fast) {
            input[slow] = 0;
            slow++;
        }
        return input;
    }
}