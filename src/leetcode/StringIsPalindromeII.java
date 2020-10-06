package leetcode;

public class StringIsPalindromeII {
    public boolean validPalindrome(String input) {
        return dfs(input, 0, input.length() - 1, 1);
    }
    public boolean dfs(String input, int left, int right, int char_to_delete) {
        if (left >= right) {
            return true;
        }
        if (char_to_delete == 0) {
            if (input.charAt(left) != input.charAt(right)) {
                return false;
            } else {
                return dfs(input, left + 1, right - 1, 0);
            }
        } else {
            if (input.charAt(left) != input.charAt(right)) {
                return dfs(input, left + 1, right, char_to_delete - 1)
                        || dfs(input, left, right - 1, char_to_delete - 1);
            } else {
                return dfs(input, left + 1, right - 1, char_to_delete)
                        || dfs(input, left + 1, right, char_to_delete - 1)
                        || dfs(input, left, right - 1, char_to_delete - 1);
            }
        }
    }
}
