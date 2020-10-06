package leetcode;

public class StringIsPalindrome {
    public boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            if (i < j && Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
        }
        return true;
    }
    // following is laicode version
    public boolean valid(String input) {
        int i = 0;
        int j = input.length() - 1;
        while (i < j) {
            while (i < j && !isValidChar(input.charAt(i))) {
                i ++;
            }
            while (j > i && !isValidChar(input.charAt(j))) {
                j --;
            }
            if (Character.toLowerCase(input.charAt(i)) != Character.toLowerCase(input.charAt(j))) {
                return false;
            }
            i ++;
            j --;
        }
        return true;
    }
    public boolean isValidChar(char c) {
        return ((c-'0' >= 0) && (c-'0' <= 9)) ||
                ((c-'a' >= 0) && (c-'a' <= 25)) ||
                ((c-'A' >= 0) && (c-'A' <= 25));
    }
}