package leetcode;

public class BinarySearchSmallestCharGreaterThanTarget {
    //Letters also wrap around
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return letters[left] <= target ? letters[0] : letters[left];
    }
}
