package leetcode;

public class StringRemoveAdjacentDupCharII {
    public String deDup(String input) {
        if (input == null || input.length() < 3) {
            return input;
        }
        char[] arr = input.toCharArray();
        int left = 1;
        int right = 1;
        while (right < arr.length) {
            boolean dup = false;
            boolean out = false;
            while (right < arr.length && arr[right] == arr[left - 1]) {
                dup = true;
                right ++;
                out = right == arr.length;
            }
            if (!out && !dup) {
                arr[left ++] = arr[right ++];
            } else if (!out && dup) {
                arr[left] = arr[left - 1];
                arr[left + 1] = arr[right ++];
                left += 2;
            } else if (out && dup) {
                arr[left] = arr[left - 1];
                return String.copyValueOf(arr, 0, left + 1);
            } else {
                return String.copyValueOf(arr, 0, left);
            }
        }
        return String.copyValueOf(arr, 0, left);
    }
}
