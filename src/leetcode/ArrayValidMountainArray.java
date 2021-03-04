package leetcode;

public class ArrayValidMountainArray {
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3 || arr[0] >= arr[1]) {
            return false;
        }
        boolean foundPeek = false;
        for (int i = 0; i < arr.length - 1; i ++) {
            if (arr[i] == arr[i + 1]) {
                return false;
            }
            if (!foundPeek) {
                if (arr[i] > arr[i + 1]) {
                    foundPeek = true;
                }
            } else if (arr[i] <= arr[i + 1]) {
                return false;
            }
        }
        return foundPeek;
    }
}
