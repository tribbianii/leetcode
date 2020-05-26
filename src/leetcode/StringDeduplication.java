package leetcode;

public class StringDeduplication {
    // scenario 1: "aaabbcc" --> "abc"
    public String removeDuplicate(String input) {
        if (input.length() < 2) {
            return input;
        }
        char[] arr = input.toCharArray();
        int slow = 1;
        int fast = 1;
        while (fast < arr.length) {
            if (arr[fast] == arr[slow - 1]) {
                fast ++;
            } else {
                arr[slow ++] = arr[fast ++];
            }
        }
        return String.copyValueOf(arr, 0, slow);
    }
    // scenario 2: "abbbac" --> "aac" --> "c"
    public String removeDuplicateRepeatedly(String input) {
        if (input.length() < 2) {
            return input;
        }
        char[] arr = input.toCharArray();
        int slow = 0;
        int fast = 0;
        while (fast < arr.length) {
            if (slow == 0 || arr[fast] != arr[slow - 1]) {
                arr[slow ++] = arr[fast ++];
            } else {
                while (fast < arr.length && arr[fast] == arr[slow - 1]) {
                    fast ++;
                }
                slow = slow == 0 ? 0 : slow - 1;
            }
        }
        return String.copyValueOf(arr, 0, slow);
    }
}